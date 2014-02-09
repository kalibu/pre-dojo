package br.com.david.pre_dojo.entidade;

import org.junit.Assert;
import org.junit.Test;

public class TestePontuacao {

	@Test
	public void testeNovaArma() {
		final Pontuacao pontuacao = new Pontuacao(new Jogador("David"));

		final Arma arma = new Arma("Arma");
		pontuacao.adicionarArma(arma);

		Assert.assertEquals(1, pontuacao.getArmas().get(arma).intValue());
	}

	@Test
	public void testeArmaExistente() {
		final Pontuacao pontuacao = new Pontuacao(new Jogador("David"));

		final Arma arma = new Arma("Arma");
		pontuacao.adicionarArma(arma);
		pontuacao.adicionarArma(arma);

		Assert.assertEquals(2, pontuacao.getArmas().get(arma).intValue());
	}

	@Test
	public void testeMultiplasArmas() {
		final Pontuacao pontuacao = new Pontuacao(new Jogador("David"));

		final Arma arma = new Arma("Arma");
		final Arma arma2 = new Arma("Arma2");
		final Arma arma3 = new Arma("Arma3");
		pontuacao.adicionarArma(arma);
		pontuacao.adicionarArma(arma);
		pontuacao.adicionarArma(arma2);
		pontuacao.adicionarArma(arma3);
		pontuacao.adicionarArma(arma);
		pontuacao.adicionarArma(arma);
		pontuacao.adicionarArma(arma3);
		pontuacao.adicionarArma(arma2);
		pontuacao.adicionarArma(arma3);

		Assert.assertEquals(4, pontuacao.getArmas().get(arma).intValue());
		Assert.assertEquals(2, pontuacao.getArmas().get(arma2).intValue());
		Assert.assertEquals(3, pontuacao.getArmas().get(arma3).intValue());
	}
}
