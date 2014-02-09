package br.com.david.pre_dojo;

import static br.com.david.pre_dojo.Constantes.FIM_PARTIDA;
import static br.com.david.pre_dojo.Constantes.INICIO_PARTIDA;
import static br.com.david.pre_dojo.Constantes.MUNDO;
import static br.com.david.pre_dojo.Constantes.PADRAO_DATA;
import static br.com.david.pre_dojo.Constantes.SEPARADOR_LINHA_LOG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.david.pre_dojo.entidade.Morte;
import br.com.david.pre_dojo.entidade.Partida;
import br.com.david.pre_dojo.servico.MorteServico;
import br.com.david.pre_dojo.servico.PartidaServico;

public class Leitor {

	private static final SimpleDateFormat SDF = new SimpleDateFormat(
			PADRAO_DATA);

	private List<Partida> partidas;
	private Partida partidaAtual;

	private MorteServico morteServico;
	private PartidaServico partidaServico;

	public Leitor() {
		this.morteServico = new MorteServico();
		this.partidaServico = new PartidaServico();
	}

	public List<Partida> lerArquivoLog(String caminho) throws IOException,
			ParseException {

		partidas = new ArrayList<Partida>();

		final InputStreamReader isr = new InputStreamReader(getClass()
				.getResourceAsStream(caminho));
		final BufferedReader br = new BufferedReader(isr);
		while (br.ready()) {
			final String linha = br.readLine();
			carregarLinhaLog(linha);
		}
		br.close();

		return partidas;
	}

	protected void carregarLinhaLog(String linhaLog) throws ParseException {

		if ((linhaLog == null) || linhaLog.isEmpty()) {
			return;
		}

		final int separadorDataLog = linhaLog.indexOf(SEPARADOR_LINHA_LOG);
		final String data = linhaLog.substring(0, separadorDataLog);
		final Date dataLog = SDF.parse(data);
		final String log = linhaLog.substring(separadorDataLog + 3);

		if (log.indexOf(INICIO_PARTIDA) != -1) {
			// inicio da partida
			carregarInicioPartida(dataLog, log);
		} else if (log.indexOf(FIM_PARTIDA) != -1) {
			// final da partida
			carregarFimPartida(dataLog, log);
		} else if (log.indexOf(MUNDO) != -1) {
			// morto pelo mundo
			carregarMortePeloMundo(dataLog, log);
		} else {
			// morto por um jogador
			carregarMorte(dataLog, log);
		}
	}

	private void carregarMorte(Date dataLog, String log) {
		final Morte morte = morteServico.criarMorte(dataLog, log);
		partidaServico.adicionarMorte(partidaAtual, morte);
	}

	private void carregarMortePeloMundo(Date dataLog, String log) {
		// System.out.println(PARTIDA + partidaAtual.getNome() + " "
		// + MORTO_POR_MUNDO);
	}

	private void carregarFimPartida(Date dataLog, String log) {
		partidaAtual.setFim(dataLog);
	}

	private void carregarInicioPartida(Date dataLog, String log) {
		partidaAtual = partidaServico.criarPartida(dataLog, log);
		partidas.add(partidaAtual);
	}

	protected List<Partida> getPartidas() {
		return partidas;
	}

	protected void setPartidas(List<Partida> partidas) {
		this.partidas = partidas;
	}

	protected Partida getPartidaAtual() {
		return partidaAtual;
	}

	protected void setPartidaAtual(final Partida partidaAtual) {
		this.partidaAtual = partidaAtual;
	}

}
