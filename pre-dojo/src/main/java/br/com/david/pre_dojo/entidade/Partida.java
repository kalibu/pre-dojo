package br.com.david.pre_dojo.entidade;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidade responsavel por quardar os atributos de uma partida no jogo.
 * @author David
 *
 */
public class Partida {

	private String nome;
	private List<Morte> mortes;

	public List<Morte> getMortes() {
		if (mortes == null) {
			mortes = new ArrayList<Morte>();
		}
		return mortes;
	}

	public void setMortes(List<Morte> mortes) {
		this.mortes = mortes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
