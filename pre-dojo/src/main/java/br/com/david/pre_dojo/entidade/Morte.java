package br.com.david.pre_dojo.entidade;

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

	public Morte(Jogador matador, Jogador morto, Arma arma, Date data) {
		this.matador = matador;
		this.morto = morto;
		this.arma = arma;
		this.data = data;
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
		return "Morte [matador=" + matador + ", morto=" + morto + ", arma="
				+ arma + ", data=" + data + "]";
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
