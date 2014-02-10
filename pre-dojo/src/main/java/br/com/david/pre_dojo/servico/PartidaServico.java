package br.com.david.pre_dojo.servico;

import static br.com.david.pre_dojo.Constantes.INICIO_PARTIDA;

import java.util.Date;
import java.util.List;
import java.util.Set;

import br.com.david.pre_dojo.entidade.Jogador;
import br.com.david.pre_dojo.entidade.Morte;
import br.com.david.pre_dojo.entidade.Partida;
import br.com.david.pre_dojo.entidade.Pontuacao;
import br.com.david.pre_dojo.utils.DataUtil;

/**
 * Serviço responsavel por tratar os eventos do log.
 * 
 * @author David
 * 
 */
public class PartidaServico {

	private DataUtil dataUtil;

	public PartidaServico() {
		dataUtil = new DataUtil();
	}

	/**
	 * Cria uma nova partida.
	 * 
	 * @param inicio
	 * @param log
	 * @return
	 */
	public Partida criarPartida(Date inicio, String log) {
		log = log.substring(INICIO_PARTIDA.length());
		final String nome = log.substring(0, log.indexOf(" "));

		return new Partida(inicio, nome);
	}

	/**
	 * Adiciona uma nova morte.
	 * 
	 * @param partida
	 * @param morte
	 */
	public void adicionarMorte(final Partida partida, final Morte morte) {
		partida.getMortes().add(morte);

		Pontuacao pontuacaoMatador = retornarPontuacao(partida.getPontuacoes(),
				morte.getMatador());
		pontuacaoMatador.adicionarAssassinato();
		pontuacaoMatador.adicionarArma(morte.getArma());

		Pontuacao pontuacaoMorto = retornarPontuacao(partida.getPontuacoes(),
				morte.getMorto());
		pontuacaoMorto.adicionarMorte();

		mortesDentroUmMinuto(partida, morte);
	}

	/**
	 * Validar se um jogador matou cinco vezes dentro de 1 minuto.
	 * 
	 * @param partida
	 * @param morte
	 */
	private void mortesDentroUmMinuto(final Partida partida, final Morte morte) {
		int countMortes = 0;
		List<Morte> mortes = partida.getMortes();

		for (Morte morte2 : mortes) {
			if (morte2.getMatador().equals(morte.getMatador())) {
				if (dataUtil
						.dentroDeUmMinuto(morte2.getData(), morte.getData())) {
					countMortes++;
				} else {
					countMortes = 0;
				}
			}
		}
		if (countMortes >= 5) {
			partida.getJogadorMatouMaisDeCincoVezesUmMinuto().add(
					morte.getMatador());
		}
	}

	/**
	 * Se ja existir uma pontuação para esse jogador retorna ela, caso contrario
	 * cria uma nova e retorna.
	 */
	protected Pontuacao retornarPontuacao(Set<Pontuacao> pontuacoes,
			Jogador jogador) {
		// valida se ja existe a pontuação
		for (Pontuacao pontuacao : pontuacoes) {
			if (pontuacao.getJogador().equals(jogador)) {
				return pontuacao;
			}
		}

		final Pontuacao pontuacao = new Pontuacao(jogador);
		pontuacoes.add(pontuacao);
		return pontuacao;

	}

}
