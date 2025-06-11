package br.dev.gustavo.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.gustavo.tarefas.model.Status;
import br.dev.gustavo.tarefas.model.Tarefa;

public class TarefasFrame {
	
	public TarefasFrame(JDialog tela) {
		criarTela(tela);
	}
	
	
	
	
	private void criarTela(JDialog tela4) {
		JDialog tela = new JDialog(tela4, true);
		tela.setSize(300, 700);
		tela.setTitle("Tarefas");
		tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		JLabel labelNomeTarefa = new JLabel("Nome da tarefa");
		labelNomeTarefa.setBounds(10, 15, 150, 30);
		
		JTextField txtNomeTarefa = new JTextField();
		txtNomeTarefa.setBounds(10, 50, 200, 30);
		
		JLabel labelDescricao = new JLabel("Descrição");
		labelDescricao.setBounds(10, 90, 150, 30);
		
		JTextField txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 125, 200, 30);
		
		JLabel labelResponsavel = new JLabel("Responsável");
		labelResponsavel.setBounds(10, 165, 150, 30);
		
		JTextField txtResponsavel= new JTextField();
		txtResponsavel.setBounds(10, 200, 200, 30);
		
		JLabel labelDataInicio = new JLabel("Data de início");
		labelDataInicio.setBounds(10, 230, 150, 30);
		
		JTextField txtDataInicio = new JTextField();
		txtDataInicio.setBounds(10, 260, 200, 30);
		
		
		JLabel labelPrazo = new JLabel("Prazo");
		labelPrazo.setBounds(10, 295, 150, 30);
		
		JTextField txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 330, 200, 30);
		
		JLabel labelDataPrevEnt = new JLabel("Data previsão de entrega");
		labelDataPrevEnt.setBounds(10, 365, 200, 30);
		
		JTextField txtDataPrevEnt = new JTextField();
		txtDataPrevEnt.setBounds(10, 400, 200, 30);
		
		JLabel labelStatus = new JLabel("Status: ");
		labelStatus.setBounds(10, 435, 200, 30);
		
		JLabel labelDataEntrega = new JLabel("Data de entrega");
		labelDataEntrega.setBounds(10, 470, 200, 30);
		
		JTextField txtDataEntrega = new JTextField();
		txtDataEntrega.setBounds(10, 505, 200, 30);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 550, 150, 40);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(165, 550, 130, 40);
		
		
		
		
		
		
		
		Container painel = tela.getContentPane();
		painel.add(labelNomeTarefa);
		painel.add(txtNomeTarefa);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(labelResponsavel);
		painel.add(txtResponsavel);
		painel.add(labelDataInicio);
		painel.add(txtDataInicio);	
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(labelDataPrevEnt);
		painel.add(txtDataPrevEnt);
		painel.add(labelStatus);
		painel.add(labelDataEntrega);
		painel.add(txtDataEntrega);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tarefa t = new Tarefa();
				t.setNome(txtNomeTarefa.getText());
				t.setDescricao(txtDescricao.getText());
				//t.setResponsavel(txtResponsavel.getText());
				//t.setDataInicio(txtDataInicio.getText());
				
			}
		});
		
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(tela, "Sair do sistema?");
				if(resposta == 0) {
					tela.dispose();
				}
				
			}
		});
		
		
		
		tela.setVisible(true);
		
		
	}
	
	

}
