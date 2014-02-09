package br.com.david.pre_dojo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitor {

	public void lerArquivoLog(String caminho) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(caminho)));
  	  
    	while(br.ready()){  
    	   String linha = br.readLine();  
    	   System.out.println(linha);  
    	}  
    	br.close();
	}
	
}
