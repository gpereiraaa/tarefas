package br.dev.gustavo.tarefas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		
		String caminho = "/Users/25132694/tarefasDS1TA/tarefas";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(caminho);
			br = new BufferedReader(fr);
			String retorno = br.readLine();
			
			while(retorno != null) {
				System.out.println(retorno);
				retorno = br.readLine();
			};
		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não foi encontrado!");
		} catch (Exception erro) {
			System.out.println("Ocorreu um erro!");
		}
		
		
		
		
	}

}
