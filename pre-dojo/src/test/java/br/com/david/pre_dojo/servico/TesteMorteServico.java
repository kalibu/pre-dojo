package br.com.david.pre_dojo.servico;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.david.pre_dojo.entidade.Morte;

public class TesteMorteServico {

	@Test
	public void criarNovaMorte() {
		final MorteServico servico = new MorteServico();
		final Date data = new Date();
		final Morte morte = servico.criarMorte(data,
				"Roman killed Nick using M16");

		Assert.assertEquals(data, morte.getData());
		Assert.assertEquals("Roman", morte.getMatador().getNome());
		Assert.assertEquals("Nick", morte.getMorto().getNome());
		Assert.assertEquals("M16", morte.getArma().getNome());
	}

}
