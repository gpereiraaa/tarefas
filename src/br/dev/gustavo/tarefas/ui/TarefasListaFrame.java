package br.dev.gustavo.tarefas.ui;

import java.awt.Container;
import java.awt.DefaultFocusTraversalPolicy;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TarefasListaFrame {
	
	private JLabel labelTitulo;
	private JButton btnNovaTarefa;
	private JButton btnSair;
	
	private JTable tabelaTarefas;
	private DefaultTableModel modelTabela;
	private JScrollPane scroll;
	
	private String[] colunas = {"Nome tarefa", "Descrição","Funcionário responsável","Data de início","Prazo","Status"};
	
	public TarefasListaFrame(JFrame tela) {
		criarTela(tela);
	}

	
	private void criarTela(JFrame tela3) {
		
		JDialog tela = new JDialog(tela3, true);
		tela.setSize(600, 500);
		tela.setTitle("Lista de Tarefas");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		
		labelTitulo = new JLabel("Tarefas");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 28));
		labelTitulo.setBounds(10, 10, 400, 40);
		
		modelTabela = new DefaultTableModel(colunas, 1);
		tabelaTarefas = new JTable(modelTabela);
		scroll = new JScrollPane(tabelaTarefas);
		scroll.setBounds(10, 60, 580, 340);
		
		btnNovaTarefa = new JButton("Nova tarefa");
		btnNovaTarefa.setBounds(10, 410, 150, 40);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(200, 410, 150, 40);
		
		
		btnNovaTarefa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TarefasFrame(tela);
				
			}
		});
		
		
				
		btnSair.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(tela, "Sair da área de tarefas?");
				if(resposta == 0) {
					tela.dispose();
				}
						
			}
		});
		
		
		
		Container painel = tela.getContentPane();
		painel.add(labelTitulo);
		painel.add(scroll);
		painel.add(btnNovaTarefa);
		painel.add(btnSair);
	
	
	
	
	
	
		tela.setVisible(true);
	
	}
}
