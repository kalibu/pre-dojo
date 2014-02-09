package br.com.david.pre_dojo;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import br.com.david.pre_dojo.entidade.Partida;

public class LogJogo {	

	public static final String CAMINHO = "/log.txt";

	public static void main(String[] args) {
		Leitor leitor = new Leitor();
		List<Partida> partidas = null;
		try {
			partidas = leitor.lerArquivoLog(CAMINHO);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(partidas);
	}
}
