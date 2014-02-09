package br.com.david.pre_dojo;

import static br.com.david.pre_dojo.Constantes.PADRAO_DATA;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.david.pre_dojo.entidade.Morte;
import br.com.david.pre_dojo.entidade.Partida;

public class TesteLeitor {

	private static final SimpleDateFormat SDF = new SimpleDateFormat(
			PADRAO_DATA);

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

	@Test(expected = ParseException.class)
	public void testeDataInvalida() throws ParseException {
		final Leitor leitor = new Leitor();
		leitor.carregarLinhaLog("23/04/2013 - teste");
		Assert.assertNull(leitor.getPartidaAtual());
	}

	@Test(expected = ParseException.class)
	public void testeDataInvalida2() throws ParseException {
		final Leitor leitor = new Leitor();
		leitor.carregarLinhaLog("23/04/ano 15:34:22 - teste");
		Assert.assertNull(leitor.getPartidaAtual());
	}

	@Test
	public void testeInicioPartida() throws ParseException {
		final Leitor leitor = new Leitor();
		leitor.setPartidas(new ArrayList<Partida>());
		leitor.carregarLinhaLog("23/04/2013 15:34:22 - New match 11348965 has started");
		Assert.assertNotNull(leitor.getPartidaAtual());

		Assert.assertEquals("11348965", leitor.getPartidaAtual().getNome());
		Assert.assertEquals(SDF.parseObject("23/04/2013 15:34:22"), leitor
				.getPartidaAtual().getInicio());
	}

	@Test
	public void testeMorte() throws ParseException {
		final Leitor leitor = new Leitor();
		leitor.setPartidaAtual(new Partida(new Date(), "11348965 has started"));

		leitor.carregarLinhaLog("23/04/2013 15:36:04 - Roman killed Nick using M16");
		Assert.assertNotNull(leitor.getPartidaAtual());

		Assert.assertEquals(1, leitor.getPartidaAtual().getMortes().size());
		final Morte morte = leitor.getPartidaAtual().getMortes().get(0);
		Assert.assertEquals("Roman", morte.getMatador().getNome());
		Assert.assertEquals("Nick", morte.getMorto().getNome());
		Assert.assertEquals("M16", morte.getArma().getNome());
		Assert.assertEquals(SDF.parseObject("23/04/2013 15:36:04"),
				morte.getData());
	}

	@Test
	public void testeMortePorMundo() throws ParseException {
		final Leitor leitor = new Leitor();
		leitor.carregarLinhaLog("23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN");
		Assert.assertNull(leitor.getPartidaAtual());
		Assert.assertNull(leitor.getPartidas());
	}

	@Test
	public void testeFimPartida() throws ParseException {
		final Leitor leitor = new Leitor();
		leitor.setPartidaAtual(new Partida(new Date(), "11348965 has started"));
		leitor.carregarLinhaLog("23/04/2013 15:39:22 - Match 11348965 has ended");

		Assert.assertEquals(SDF.parseObject("23/04/2013 15:39:22"), leitor
				.getPartidaAtual().getFim());
	}
}
