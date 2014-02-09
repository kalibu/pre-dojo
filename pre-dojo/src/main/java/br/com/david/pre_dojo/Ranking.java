package br.com.david.pre_dojo;

import static br.com.david.pre_dojo.Constantes.PADRAO_DATA;

import java.text.SimpleDateFormat;
import java.util.Set;

import br.com.david.pre_dojo.entidade.Partida;
import br.com.david.pre_dojo.entidade.Pontuacao;

public class Ranking {

	private static final SimpleDateFormat SDF = new SimpleDateFormat(
			PADRAO_DATA);

	public void mostrarRankingPartida(Partida partida) {

		System.out.println("Partida: " + partida.getNome());
		System.out.println("Duração: " + SDF.format(partida.getInicio())
				+ " - " + SDF.format(partida.getFim()));

		mostrarPontuacoes(partida.getPontuacoes());

	}

	private void mostrarPontuacoes(Set<Pontuacao> pontuacoes) {
		for (Pontuacao pontuacao : pontuacoes) {
			StringBuffer sb = new StringBuffer();

			sb.append("Jogador: " + pontuacao.getJogador().getNome());
			sb.append(" - Matou: " + pontuacao.getMatou());
			sb.append(" - Morreu: " + pontuacao.getMorreu());

			System.out.println(sb);
		}

	}
}
