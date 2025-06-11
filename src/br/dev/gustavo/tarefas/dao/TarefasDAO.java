package br.dev.gustavo.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import br.dev.gustavo.tarefas.model.Tarefa;

public class TarefasDAO {
	
	private Tarefa tarefa;
	
	private FileWriter fw;
	private BufferedWriter bw;
	private FileReader fr;
	private BufferedReader br;
	
	private String arquivo ="/Users/25132694/tarefasDS1TA/tarefas.csv";
	
	public TarefasDAO(Tarefa tarefa) {
		this.tarefa = tarefa;
		try {
			fw = new FileWriter(arquivo, true);
			bw = new BufferedWriter(fw);
			fr = new FileReader(arquivo);
			br = new BufferedReader(fr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
