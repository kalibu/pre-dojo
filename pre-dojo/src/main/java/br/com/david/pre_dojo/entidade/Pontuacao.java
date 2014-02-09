package br.com.david.pre_dojo.entidade;

import java.util.ArrayList;
import java.util.List;

public class Pontuacao {

	private final Jogador jogador;
	private List<Arma> armas;
	private int morreu;
	private int matou;

	public Pontuacao(final Jogador jogador) {
		armas = new ArrayList<Arma>();
		this.morreu = 0;
		this.matou = 0;
		this.jogador = jogador;
	}

	public void adicionarMorte() {
		this.morreu++;
	}

	public void adicionarAssassinato() {
		this.matou++;
	}

	public void adicionarArma(final Arma arma) {
		this.armas.add(arma);
	}

	public Jogador getJogador() {
		return jogador;
	}

	public List<Arma> getArmas() {
		return armas;
	}

	public void setArmas(List<Arma> armas) {
		this.armas = armas;
	}

	public int getMorreu() {
		return morreu;
	}

	public void setMorreu(int morreu) {
		this.morreu = morreu;
	}

	public int getMatou() {
		return matou;
	}

	public void setMatou(int matou) {
		this.matou = matou;
	}

	@Override
	public String toString() {
		return "Pontuacao [jogador=" + jogador + ", armas=" + armas
				+ ", morreu=" + morreu + ", matou=" + matou + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jogador == null) ? 0 : jogador.hashCode());
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
		Pontuacao other = (Pontuacao) obj;
		if (jogador == null) {
			if (other.jogador != null)
				return false;
		} else if (!jogador.equals(other.jogador))
			return false;
		return true;
	}

}
