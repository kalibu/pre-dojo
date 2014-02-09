package br.com.david.pre_dojo;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

public class TesteLeitor {

	@Test(expected = NullPointerException.class)
	public void testeArquivoInvalido() throws IOException, ParseException {
		new Leitor().lerArquivoLog("arquivoInvalido.txt");
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testeLinhaLogInvalida() throws ParseException {
		new Leitor().carregarLinhaLog("linha invalida");
	}

	@Test
	public void testeLinhaVazia() throws ParseException {
		final Leitor leitor = new Leitor();
		leitor.carregarLinhaLog("");
		Assert.assertNull(leitor.getPartidaAtual());
	}

	@Test
	public void testeLinhaNula() throws ParseException {
		final Leitor leitor = new Leitor();
		leitor.carregarLinhaLog(null);
		Assert.assertNull(leitor.getPartidaAtual());
	}
}
