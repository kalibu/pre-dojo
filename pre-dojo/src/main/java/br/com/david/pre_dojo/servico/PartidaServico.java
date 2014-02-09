package br.com.david.pre_dojo.servico;

import static br.com.david.pre_dojo.Constantes.INICIO_PARTIDA;

import java.util.Date;
import java.util.Set;

import br.com.david.pre_dojo.entidade.Jogador;
import br.com.david.pre_dojo.entidade.Morte;
import br.com.david.pre_dojo.entidade.Partida;
import br.com.david.pre_dojo.entidade.Pontuacao;

public class PartidaServico {

	public Partida criarPartida(Date inicio, String log) {
		log = log.substring(INICIO_PARTIDA.length());
		final String nome = log.substring(0, log.indexOf(" "));

		return new Partida(inicio, nome);
	}

	public void adicionarMorte(final Partida partida, final Morte morte) {
		partida.getMortes().add(morte);

		Pontuacao pontuacaoMatador = retornarPontuacao(partida.getPontuacoes(),
				morte.getMatador());
		pontuacaoMatador.adicionarAssassinato();
		pontuacaoMatador.adicionarArma(morte.getArma());

		Pontuacao pontuacaoMorto = retornarPontuacao(partida.getPontuacoes(),
				morte.getMorto());
		pontuacaoMorto.adicionarMorte();

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
