package br.dev.gustavo.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.gustavo.tarefas.model.Funcionario;
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
	
	public void salvar() {
		try {
			bw.write(tarefa.toString());
			bw.flush();
			System.out.println(tarefa.getNome() + " gravado com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Tarefa> getTarefas(){
		
		List<Tarefa> tarefas = new ArrayList<>();
		
		try {
			String linha = "";
			
			while (linha !=null) {
				linha = br.readLine();
				if(linha !=null) {
					String[] tarefasVetor = linha.split(",");
					Tarefa tarefa = new Tarefa();
					tarefa.setDataEntrega(tarefasVetor[0]);
					tarefa.setDataInicio(tarefasVetor[1]);
					tarefa.setStatus(tarefasVetor[2]);
				}
				return tarefas;
			}
			
		} catch (Exception e) {
			return null;
		}
	}
}
