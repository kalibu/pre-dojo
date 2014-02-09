package br.com.david.pre_dojo.entidade;

import static br.com.david.pre_dojo.Constantes.INICIO_PARTIDA;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entidade responsavel por quardar os atributos de uma partida no jogo.
 * 
 * @author David
 * 
 */
public class Partida {

	private final String nome;
	private List<Morte> mortes;
	private final Date inicio;
	private Date fim;

	public Partida(Date inicio, String log) {
		mortes = new ArrayList<Morte>();
		this.inicio = inicio;

		log = log.substring(INICIO_PARTIDA.length());
		this.nome = log.substring(0, log.indexOf(" "));
	}

	public void adicionarMorte(Morte morte) {
		getMortes().add(morte);
	}

	public Date getInicio() {
		return inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public List<Morte> getMortes() {
		return mortes;
	}

	public void setMortes(List<Morte> mortes) {
		this.mortes = mortes;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "\nPartida [nome=" + nome + ", \nmortes=" + mortes + ", inicio="
				+ inicio + ", fim=" + fim + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fim == null) ? 0 : fim.hashCode());
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + ((mortes == null) ? 0 : mortes.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Partida other = (Partida) obj;
		if (fim == null) {
			if (other.fim != null)
				return false;
		} else if (!fim.equals(other.fim))
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (mortes == null) {
			if (other.mortes != null)
				return false;
		} else if (!mortes.equals(other.mortes))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
