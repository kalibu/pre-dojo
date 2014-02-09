package br.com.david.pre_dojo;

import java.io.IOException;

public class LogJogo 
{
	
	public static final String CAMINHO = "/log.txt";
	
    public static void main( String[] args ) throws IOException 
    {
    	  Leitor leitor = new Leitor();
    	  leitor.lerArquivoLog(CAMINHO);
    }
}
