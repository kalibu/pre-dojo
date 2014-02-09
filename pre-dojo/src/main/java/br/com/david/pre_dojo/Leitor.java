package br.com.david.pre_dojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.david.pre_dojo.entidade.Partida;

public class Leitor {

	private final static SimpleDateFormat SDF = new SimpleDateFormat(
			"dd/MM/yyyy hh:mm:ss");
	
	private final static String SEPARADOR_LINHA_LOG = " - ";
	private final static String INICIO_PARTIDA = "New match";
	private final static String FIM_PARTIDA = "Match";
	private final static String MUNDO = "<WORLD>";
	
	private List<Partida> partidas;
	private Partida partidaAtual;

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

	private void carregarLinhaLog(String linhaLog) throws ParseException{
		final int separadorDataLog = linhaLog.indexOf(SEPARADOR_LINHA_LOG);
		final String data = linhaLog.substring(0, separadorDataLog);
		final Date dataLog = SDF.parse(data);
		final String log = linhaLog.substring(separadorDataLog+3);
		
		if(log.indexOf(INICIO_PARTIDA) != -1){
			//inicio da partida
			carregarInicioPartida(dataLog, log);
		}else if(log.indexOf(FIM_PARTIDA) != -1){
			//final da partida
			carregarFimPartida(dataLog, log);
		}else if(log.indexOf(MUNDO) != -1){
			//morto pelo mundo
			carregarMortePeloMundo(dataLog, log);
		}else{
			//morto por um jogador
			carregarMorte(dataLog, log);
		}
	}

	private void carregarMorte(Date dataLog, String log) {
		System.out.println("uma morte");
	}

	private void carregarMortePeloMundo(Date dataLog, String log) {
		System.out.println("morto por mundo");
	}

	private void carregarFimPartida(Date dataLog, String log) {
		System.out.println("final partida");
	}

	private void carregarInicioPartida(Date dataLog, String log) {
		partidaAtual = new Partida(dataLog);
		partidas.add(partidaAtual);
		String nomePartida = log.substring(INICIO_PARTIDA.length()+1);
		nomePartida = nomePartida.substring(0, nomePartida.indexOf(" "));
		partidaAtual.setNome(nomePartida);
	}
}
