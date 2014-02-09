package br.com.david.pre_dojo.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entidade responsavel por quardar os atributos de uma partida no jogo.
 * @author David
 *
 */
public class Partida {

	private String nome;
	private List<Morte> mortes;
	private Date inicio;
	private Date fim;
	
	public Partida(Date inicio) {
		mortes = new ArrayList<Morte>();
		setInicio(inicio);
	}
	
	public void adicionarMorte(Morte morte){
		getMortes().add(morte);
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

}
