package br.com.david.pre_dojo.servico;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import br.com.david.pre_dojo.entidade.Arma;
import br.com.david.pre_dojo.entidade.Jogador;
import br.com.david.pre_dojo.entidade.Morte;
import br.com.david.pre_dojo.entidade.Partida;
import br.com.david.pre_dojo.entidade.Pontuacao;

public class TestePartidaServico {

	@Test
	public void testeRetornarPontuacaoJogadorNovo() {

		final PartidaServico servico = new PartidaServico();
		final Jogador jogador = new Jogador("David");
		Pontuacao pontuacao = servico.retornarPontuacao(
				new HashSet<Pontuacao>(), jogador);

		Assert.assertEquals(0, pontuacao.getMatou());
		Assert.assertEquals(0, pontuacao.getMorreu());
		Assert.assertEquals(jogador, pontuacao.getJogador());
		Assert.assertEquals(0, pontuacao.getArmas().size());
	}

	@Test
	public void testeRetornarPontuacaoJogadorExistente() {
		final PartidaServico servico = new PartidaServico();
		final Jogador jogador = new Jogador("David");
		final Set<Pontuacao> pontuacoes = new HashSet<Pontuacao>();
		final Pontuacao pontuacao = new Pontuacao(jogador);
		pontuacao.adicionarAssassinato();
		pontuacao.adicionarAssassinato();
		pontuacao.adicionarMorte();
		pontuacao.adicionarArma(new Arma("AR15"));
		pontuacoes.add(pontuacao);

		final Pontuacao pontuacaoRetornada = servico.retornarPontuacao(
				pontuacoes, jogador);

		Assert.assertEquals(2, pontuacaoRetornada.getMatou());
		Assert.assertEquals(1, pontuacaoRetornada.getMorreu());
		Assert.assertEquals(jogador, pontuacaoRetornada.getJogador());
		Assert.assertEquals(1, pontuacaoRetornada.getArmas().size());
	}

	@Test
	public void testeAdicionarMorte() {
		final PartidaServico servico = new PartidaServico();
		final Jogador matador = new Jogador("matador");
		final Jogador morto = new Jogador("morto");
		final Arma arma = new Arma("arma");
		final Morte morte = new Morte(matador, morto, arma, new Date());
		final Partida partida = new Partida(new Date(), "nomePartida");
		servico.adicionarMorte(partida, morte);

		final Pontuacao pontuacaoMatador = servico.retornarPontuacao(
				partida.getPontuacoes(), matador);
		Assert.assertEquals(1, pontuacaoMatador.getMatou());
		Assert.assertEquals(0, pontuacaoMatador.getMorreu());
		Assert.assertEquals(matador, pontuacaoMatador.getJogador());
		Assert.assertEquals(1, pontuacaoMatador.getArmas().get(arma).intValue());

		final Pontuacao pontuacaoMorto = servico.retornarPontuacao(
				partida.getPontuacoes(), morto);
		Assert.assertEquals(0, pontuacaoMorto.getMatou());
		Assert.assertEquals(1, pontuacaoMorto.getMorreu());
		Assert.assertEquals(morto, pontuacaoMorto.getJogador());
		Assert.assertEquals(0, pontuacaoMorto.getArmas().size());
	}

	@Test
	public void testeCriarNovaPartida() {
		final PartidaServico servico = new PartidaServico();
		final Date data = new Date();
		final Partida partida = servico.criarPartida(data,
				"New match 11348965 has started");

		Assert.assertEquals(data, partida.getInicio());
		Assert.assertEquals("11348965", partida.getNome());
	}

	@Test
	public void testeAdicionarCincoMortesUmMinuto() {
		final PartidaServico servico = new PartidaServico();
		final Jogador matador = new Jogador("matador");
		final Jogador morto = new Jogador("morto");
		final Arma arma = new Arma("arma");
		final Partida partida = new Partida(new Date(), "nomePartida");

		final Morte morte = new Morte(matador, morto, arma, new Date());
		servico.adicionarMorte(partida, morte);
		final Morte morte2 = new Morte(matador, morto, arma, new Date());
		servico.adicionarMorte(partida, morte2);
		final Morte morte3 = new Morte(matador, morto, arma, new Date());
		servico.adicionarMorte(partida, morte3);
		final Morte morte4 = new Morte(matador, morto, arma, new Date());
		servico.adicionarMorte(partida, morte4);
		final Morte morte5 = new Morte(matador, morto, arma, new Date());
		servico.adicionarMorte(partida, morte5);

		Assert.assertTrue(partida.getJogadorMatouMaisDeCincoVezesUmMinuto()
				.contains(matador));
	}

	@Test
	public void testeAdicionarCincoMortesMaisDeUmMinuto() {
		final PartidaServico servico = new PartidaServico();
		final Jogador matador = new Jogador("matador");
		final Jogador morto = new Jogador("morto");
		final Arma arma = new Arma("arma");
		final Partida partida = new Partida(new Date(), "nomePartida");

		final Morte morte = new Morte(matador, morto, arma, new Date());
		servico.adicionarMorte(partida, morte);
		final Morte morte2 = new Morte(matador, morto, arma, new Date());
		servico.adicionarMorte(partida, morte2);
		final Morte morte3 = new Morte(matador, morto, arma, new Date());
		servico.adicionarMorte(partida, morte3);
		final Morte morte4 = new Morte(matador, morto, arma, new Date());
		servico.adicionarMorte(partida, morte4);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, 1);
		final Morte morte5 = new Morte(matador, morto, arma, c.getTime());
		servico.adicionarMorte(partida, morte5);

		Assert.assertFalse(partida.getJogadorMatouMaisDeCincoVezesUmMinuto()
				.contains(matador));
	}

	@Test
	public void testeAdicionarCincoMortesUmMinutoFim() {
		final PartidaServico servico = new PartidaServico();
		final Jogador matador = new Jogador("matador");
		final Jogador morto = new Jogador("morto");
		final Arma arma = new Arma("arma");
		final Partida partida = new Partida(new Date(), "nomePartida");

		final Morte morte = new Morte(matador, morto, arma, new Date());
		servico.adicionarMorte(partida, morte);
		final Morte morte2 = new Morte(matador, morto, arma, new Date());
		servico.adicionarMorte(partida, morte2);
		final Morte morte3 = new Morte(matador, morto, arma, new Date());
		servico.adicionarMorte(partida, morte3);
		final Morte morte4 = new Morte(matador, morto, arma, new Date());
		servico.adicionarMorte(partida, morte4);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MINUTE, 1);
		final Morte morte5 = new Morte(matador, morto, arma, c.getTime());
		servico.adicionarMorte(partida, morte5);
		final Morte morte6 = new Morte(matador, morto, arma, c.getTime());
		servico.adicionarMorte(partida, morte6);
		final Morte morte7 = new Morte(matador, morto, arma, c.getTime());
		servico.adicionarMorte(partida, morte7);
		final Morte morte8 = new Morte(matador, morto, arma, c.getTime());
		servico.adicionarMorte(partida, morte8);
		final Morte morte9 = new Morte(matador, morto, arma, c.getTime());
		servico.adicionarMorte(partida, morte9);

		Assert.assertTrue(partida.getJogadorMatouMaisDeCincoVezesUmMinuto()
				.contains(matador));
	}

}
