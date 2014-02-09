package br.com.david.pre_dojo.servico;

import static br.com.david.pre_dojo.Constantes.KILLED;
import static br.com.david.pre_dojo.Constantes.USING;

import java.util.Date;

import br.com.david.pre_dojo.entidade.Arma;
import br.com.david.pre_dojo.entidade.Jogador;
import br.com.david.pre_dojo.entidade.Morte;

public class MorteServico {

	public Morte criarMorte(Date dataMorte, String log) {
		final String nomeMatador = log.substring(0, log.indexOf(" "));
		log = log.substring(nomeMatador.length());
		log = log.substring(KILLED.length());
		final String nomeMorto = log.substring(0, log.indexOf(" "));
		log = log.substring(nomeMorto.length());
		log = log.substring(USING.length());
		final String nomeArma = log;

		return new Morte(new Jogador(nomeMatador), new Jogador(nomeMorto),
				new Arma(nomeArma), dataMorte);
	}

}
