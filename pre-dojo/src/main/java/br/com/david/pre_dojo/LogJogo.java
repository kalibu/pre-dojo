package br.com.david.pre_dojo;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import br.com.david.pre_dojo.entidade.Partida;

/**
 * Classe para ler o arquivo e montar o ranking. Caso seja necessario adicionar
 * outra forma de visualização, essa classe não seria mais necessaria.
 * 
 * @author David
 * 
 */
public class LogJogo {

	public static final String CAMINHO = "/log.txt";

	public static void main(String[] args) {
		final Leitor leitor = new Leitor();
		final Ranking ranking = new Ranking();
		try {
			final List<Partida> partidas = leitor.lerArquivoLog(CAMINHO);

			for (Partida partida : partidas) {
				ranking.mostrarRankingPartida(partida);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
