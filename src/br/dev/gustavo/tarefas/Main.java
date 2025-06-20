package br.dev.gustavo.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;

import br.dev.gustavo.tarefas.dao.FuncionarioDAO;
import br.dev.gustavo.tarefas.model.Funcionario;
import br.dev.gustavo.tarefas.model.Tarefa;
import br.dev.gustavo.tarefas.ui.FuncionarioFrame;
import br.dev.gustavo.tarefas.ui.FuncionariosListaFrame;
import br.dev.gustavo.tarefas.ui.GerenciamentoTarefas;
import br.dev.gustavo.tarefas.ui.TarefasFrame;

public class Main {
	static String caminho = "/Users/25132694/tarefasDS1TA/tarefas";
	public static void main(String[] args) {
		
		
		//FuncionarioDAO dao = new FuncionarioDAO(null);
		//dao.getFuncionarios();
		
		
		new GerenciamentoTarefas();
		
		//new TarefasFrame();
		
		//new FuncionariosListaFrame();
		
		
//		UUID uuid = UUID.randomUUID();
//		System.out.println(uuid);
//		
//		String escola = "Senai Jandira";
//		String cidade = escola.substring(6, 13);
//		System.out.println(cidade);
//		
//		String uuid8 = uuid.toString().substring(0, 8);
//		System.out.println(uuid8);
//		
//		
//		Funcionario f = new Funcionario("Pedro", "Programador");
//		f.setSetor("TI");
//		
//		Funcionario f2 = new Funcionario();
//		f2.setNome("Carlos");
//		f2.setCargo("Analista de Sistemas");
//		f2.setSetor("TI");
//		
//		FuncionarioDAO dao = new FuncionarioDAO(f2);
//		dao.salvar();
		
		
		
		
		
		//Tarefa tarefa1 = new Tarefa("Lavar a louça");
		
		
		//escreverArquivo();
		//lerArquivo();
		
		
		
		
	}
	
	private static void escreverArquivo() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(caminho, true);
			bw = new BufferedWriter(fw);
			
			//Adicionando conteúdo ao arquivo
			//
			//bw.append("Gustavo");
			bw.append("xpto\n");
			bw.append("Senai Jandira\n");
			bw.append("Programação de computadores\n");
			
			//Mandando escrever no arquivo
			bw.flush();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void lerArquivo() {
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
