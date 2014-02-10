package br.com.david.pre_dojo.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private Set<Pontuacao> pontuacoes;
	private Set<Jogador> jogadorMatouMaisDeCincoVezesUmMinuto;

	public Partida(Date inicio, String nome) {
		mortes = new ArrayList<Morte>();
		pontuacoes = new HashSet<Pontuacao>();
		jogadorMatouMaisDeCincoVezesUmMinuto = new HashSet<Jogador>();
		this.inicio = inicio;
		this.nome = nome;
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

	public Set<Pontuacao> getPontuacoes() {
		return pontuacoes;
	}

	public Set<Jogador> getJogadorMatouMaisDeCincoVezesUmMinuto() {
		return jogadorMatouMaisDeCincoVezesUmMinuto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fim == null) ? 0 : fim.hashCode());
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + ((mortes == null) ? 0 : mortes.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((pontuacoes == null) ? 0 : pontuacoes.hashCode());
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
		if (pontuacoes == null) {
			if (other.pontuacoes != null)
				return false;
		} else if (!pontuacoes.equals(other.pontuacoes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Partida [nome=" + nome + ", mortes=" + mortes + ", inicio="
				+ inicio + ", fim=" + fim + ", pontuacoes=" + pontuacoes + "]";
	}

}
