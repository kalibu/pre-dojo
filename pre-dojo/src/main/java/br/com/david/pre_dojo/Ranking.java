package br.com.david.pre_dojo;

import static br.com.david.pre_dojo.Constantes.PADRAO_DATA;

import java.text.SimpleDateFormat;
import java.util.Set;

import br.com.david.pre_dojo.entidade.Arma;
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

		mostrarVencedorComArma(partida.getPontuacoes());
	}

	private void mostrarVencedorComArma(Set<Pontuacao> pontuacoes) {
		Pontuacao vencedor = null;
		for (Pontuacao pontuacao : pontuacoes) {
			if ((vencedor == null)
					|| (vencedor.getMatou() < pontuacao.getMatou())) {
				vencedor = pontuacao;
			}
		}

		Arma armaPreferida = null;
		Integer qtdMortesArmaPreferida = 0;
		for (Arma arma : vencedor.getArmas().keySet()) {
			if (qtdMortesArmaPreferida < vencedor.getArmas().get(arma)
					.intValue()) {
				armaPreferida = arma;
				qtdMortesArmaPreferida = vencedor.getArmas().get(arma)
						.intValue();
			}
		}

		System.out.println("Vencedor: " + vencedor.getJogador().getNome()
				+ ", arma preferida: " + armaPreferida.getNome() + "("
				+ qtdMortesArmaPreferida + ")");
	}

	private void mostrarPontuacoes(Set<Pontuacao> pontuacoes) {
		for (Pontuacao pontuacao : pontuacoes) {
			StringBuffer sb = new StringBuffer();

			sb.append("Jogador: " + pontuacao.getJogador().getNome());
			sb.append(" - Matou: " + pontuacao.getMatou());
			sb.append(" - Morreu: " + pontuacao.getMorreu());

			if (pontuacao.getMorreu() == 0) {
				sb.append(" (award)");
			}

			System.out.println(sb);
		}

	}
}
