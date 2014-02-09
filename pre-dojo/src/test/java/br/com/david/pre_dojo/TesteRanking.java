package br.com.david.pre_dojo;

import java.util.Date;

import org.junit.Test;

import br.com.david.pre_dojo.entidade.Arma;
import br.com.david.pre_dojo.entidade.Jogador;
import br.com.david.pre_dojo.entidade.Morte;
import br.com.david.pre_dojo.entidade.Partida;
import br.com.david.pre_dojo.servico.PartidaServico;

public class TesteRanking {

	@Test
	public void validarRanking() {
		final PartidaServico servico = new PartidaServico();
		final Jogador matador = new Jogador("matador");
		final Jogador morto = new Jogador("morto");
		final Arma arma = new Arma("arma");
		final Morte morte = new Morte(matador, morto, arma, new Date());
		final Partida partida = new Partida(new Date(), "nomePartida");
		servico.adicionarMorte(partida, morte);
		servico.adicionarMorte(partida, morte);
		servico.adicionarMorte(partida, morte);

		final Ranking ranking = new Ranking();
		ranking.mostrarRankingPartida(partida);
	}

}
