package br.com.david.pre_dojo;

import java.util.List;
import java.util.Set;

import br.com.david.pre_dojo.entidade.Arma;
import br.com.david.pre_dojo.entidade.Partida;
import br.com.david.pre_dojo.entidade.Pontuacao;

public class Ranking {

	public void mostrarRankingPartida(Partida partida) {

		System.out.println("Partida: " + partida.getNome());
		System.out.println("Duração: " + partida.getInicio() + " - "
				+ partida.getFim());

		mostrarPontuacoes(partida.getPontuacoes());

	}

	private void mostrarPontuacoes(Set<Pontuacao> pontuacoes) {
		for (Pontuacao pontuacao : pontuacoes) {
			StringBuffer sb = new StringBuffer();

			sb.append("Jogador: " + pontuacao.getJogador().getNome());
			sb.append(" - Matou: " + pontuacao.getMatou());
			sb.append(" - Morreu: " + pontuacao.getMorreu());
			sb.append(" - Armas: ");

			sb.append(mostrarArmas(pontuacao.getArmas()));

			System.out.println(sb);
		}

	}

	private String mostrarArmas(List<Arma> armas) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < armas.size(); i++) {
			Arma arma = armas.get(i);
			sb.append(arma.getNome());

			if (i != (armas.size() - 1)) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
}
