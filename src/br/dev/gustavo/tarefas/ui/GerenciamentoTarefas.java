package br.dev.gustavo.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GerenciamentoTarefas {
	
	public GerenciamentoTarefas() {
		criarTela();
	}
	
	
	private void criarTela() {
		JFrame tela = new JFrame("Gerenciamento de Tarefas");
		tela.setSize(530, 200);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		
		JButton btnFuncionario = new JButton("Funcionários");
		btnFuncionario.setBounds(10, 30, 250, 100);
		
		JButton btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(265, 30, 250, 100);
	
		
		
		
		btnFuncionario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FuncionariosListaFrame(tela);
				
			}
		});
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TarefasListaFrame(tela);
				
			}
		});
		
		Container painel = tela.getContentPane();
		painel.add(btnFuncionario);
		painel.add(btnTarefas);
		
		
		
		tela.setVisible(true);
	
	}

}
