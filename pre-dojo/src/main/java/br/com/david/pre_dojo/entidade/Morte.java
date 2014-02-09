package br.com.david.pre_dojo.entidade;

import static br.com.david.pre_dojo.Constantes.KILLED;
import static br.com.david.pre_dojo.Constantes.USING;

import java.util.Date;

/**
 * Entidade responsavel por quardar os atributos de uma morte no jogo.
 * 
 * @author David
 * 
 */
public class Morte {

	private final Jogador matador;
	private final Jogador morto;
	private final Arma arma;
	private final Date data;

	public Morte(Date dataMorte, String log) {
		final String nomeMatador = log.substring(0, log.indexOf(" "));
		log = log.substring(nomeMatador.length());
		log = log.substring(KILLED.length());
		final String nomeMorto = log.substring(0, log.indexOf(" "));
		log = log.substring(nomeMorto.length());
		log = log.substring(USING.length());
		final String nomeArma = log;

		this.data = dataMorte;
		this.matador = new Jogador(nomeMatador);
		this.morto = new Jogador(nomeMorto);
		this.arma = new Arma(nomeArma);
	}

	public Jogador getMatador() {
		return matador;
	}

	public Jogador getMorto() {
		return morto;
	}

	public Arma getArma() {
		return arma;
	}

	public Date getData() {
		return data;
	}

	@Override
	public String toString() {
		return "\nMorte [matador=" + matador + ", morto=" + morto + ", arma="
				+ arma + ", data=" + data + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arma == null) ? 0 : arma.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((matador == null) ? 0 : matador.hashCode());
		result = prime * result + ((morto == null) ? 0 : morto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Morte other = (Morte) obj;
		if (arma == null) {
			if (other.arma != null)
				return false;
		} else if (!arma.equals(other.arma))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (matador == null) {
			if (other.matador != null)
				return false;
		} else if (!matador.equals(other.matador))
			return false;
		if (morto == null) {
			if (other.morto != null)
				return false;
		} else if (!morto.equals(other.morto))
			return false;
		return true;
	}
}
