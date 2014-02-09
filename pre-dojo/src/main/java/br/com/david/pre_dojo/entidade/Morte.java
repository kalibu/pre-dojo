package br.com.david.pre_dojo.entidade;

import java.util.Date;

/**
 * Entidade responsavel por quardar os atributos de uma morte no jogo.
 * @author David
 *
 */
public class Morte {

	private Jogador matador;
	private Jogador morto;
	private Date data;

	public Jogador getMatador() {
		return matador;
	}

	public void setMatador(Jogador matador) {
		this.matador = matador;
	}

	public Jogador getMorto() {
		return morto;
	}

	public void setMorto(Jogador morto) {
		this.morto = morto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
