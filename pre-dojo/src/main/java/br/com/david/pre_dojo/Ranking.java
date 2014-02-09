package br.com.david.pre_dojo;

import static br.com.david.pre_dojo.Constantes.PADRAO_DATA;

import java.text.SimpleDateFormat;
import java.util.Set;

import br.com.david.pre_dojo.entidade.Arma;
import br.com.david.pre_dojo.entidade.Jogador;
import br.com.david.pre_dojo.entidade.Partida;
import br.com.david.pre_dojo.entidade.Pontuacao;

/**
 * Classe responsavel por mostrar o ranking via log dos usuarios.
 * 
 * @author David
 * 
 */
public class Ranking {

	private static final SimpleDateFormat SDF = new SimpleDateFormat(
			PADRAO_DATA);

	/**
	 * Imprime o ranking da partida.
	 * 
	 * @param partida
	 */
	public void mostrarRankingPartida(Partida partida) {

		System.out.println("Partida: " + partida.getNome());
		System.out.println("Duração: " + SDF.format(partida.getInicio())
				+ " - " + SDF.format(partida.getFim()));

		Jogador jogador = carregarJogadorComMaiorSeguenciaDeAssassinatosSeguidos(partida
				.getPontuacoes());

		mostrarPontuacoes(partida.getPontuacoes(), jogador);

		mostrarVencedorComArma(partida.getPontuacoes());
	}

	/**
	 * Separa o jogador com o maior numero de assassinatos seguidos.
	 * 
	 * @param pontuacoes
	 * @return
	 */
	private Jogador carregarJogadorComMaiorSeguenciaDeAssassinatosSeguidos(
			Set<Pontuacao> pontuacoes) {

		int maiorNumeroDeAssassinatosSeguidos = 0;
		Jogador jogadorComMaiorNumeroDeAssassinatosSeguidos = null;
		for (Pontuacao pontuacao : pontuacoes) {
			if (maiorNumeroDeAssassinatosSeguidos < pontuacao
					.getAssassinatosSeguidos()) {
				maiorNumeroDeAssassinatosSeguidos = pontuacao
						.getAssassinatosSeguidos();
				jogadorComMaiorNumeroDeAssassinatosSeguidos = pontuacao
						.getJogador();
			}
		}

		return jogadorComMaiorNumeroDeAssassinatosSeguidos;
	}

	/**
	 * Imprime o vencedor da partida com a sua arma preferida.
	 * 
	 * @param pontuacoes
	 */
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

	/**
	 * Mostra a pontuação da partida.
	 * 
	 * @param pontuacoes
	 * @param jogadorComMaiorSequenciaDeAssassinatosSeguidos
	 */
	private void mostrarPontuacoes(Set<Pontuacao> pontuacoes,
			Jogador jogadorComMaiorSequenciaDeAssassinatosSeguidos) {
		for (Pontuacao pontuacao : pontuacoes) {
			StringBuffer sb = new StringBuffer();

			sb.append("Jogador: " + pontuacao.getJogador().getNome());
			sb.append(" - Matou: " + pontuacao.getMatou());
			sb.append(" - Morreu: " + pontuacao.getMorreu());

			if (pontuacao.getMorreu() == 0) {
				sb.append(" (award)");
			}

			if (pontuacao.getJogador().equals(
					jogadorComMaiorSequenciaDeAssassinatosSeguidos)) {
				sb.append(" (streak)");
			}

			System.out.println(sb);
		}

	}
}
