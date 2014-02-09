package br.com.david.pre_dojo.entidade;

import java.util.HashMap;
import java.util.Map;

public class Pontuacao {

	private final Jogador jogador;
	private Map<Arma, Integer> armas;
	private int morreu;
	private int matou;
	private int assassinatosSeguidos;

	public Pontuacao(final Jogador jogador) {
		armas = new HashMap<Arma, Integer>();
		this.morreu = 0;
		this.matou = 0;
		this.jogador = jogador;
		this.assassinatosSeguidos = 0;
	}

	public void adicionarMorte() {
		this.morreu++;
		this.assassinatosSeguidos = 0;
	}

	public void adicionarAssassinato() {
		this.matou++;
		this.assassinatosSeguidos++;
	}

	public void adicionarArma(final Arma arma) {
		if (this.armas.containsKey(arma)) {
			Integer qtd = armas.get(arma);
			armas.put(arma, ++qtd);
		} else {
			armas.put(arma, 1);
		}
	}

	public Jogador getJogador() {
		return jogador;
	}

	public Map<Arma, Integer> getArmas() {
		return armas;
	}

	public void setArmas(Map<Arma, Integer> armas) {
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

	public int getAssassinatosSeguidos() {
		return assassinatosSeguidos;
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
