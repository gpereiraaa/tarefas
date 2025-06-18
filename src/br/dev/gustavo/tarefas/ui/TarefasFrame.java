package br.dev.gustavo.tarefas.ui;

import java.awt.Container;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import br.dev.gustavo.tarefas.dao.FuncionarioDAO;
import br.dev.gustavo.tarefas.dao.TarefasDAO;
import br.dev.gustavo.tarefas.model.Funcionario;
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
		txtNomeTarefa.setBounds(10, 50, 260, 30);
		
		JLabel labelDescricao = new JLabel("Descrição");
		labelDescricao.setBounds(10, 90, 150, 30);
		
		JTextField txtDescricao = new JTextField();
		txtDescricao.setBounds(10, 125, 260, 30);
		
		
		
		
		
		JLabel labelResponsavel = new JLabel("Responsável");
		labelResponsavel.setBounds(10, 165, 150, 30);

		
		JComboBox<Funcionario> cbxFuncionarios = new JComboBox<Funcionario>(carregarMatricula());
		cbxFuncionarios.setBounds(10, 200, 260, 30);
		
		
		
		JLabel labelDataInicio = new JLabel("Data de início");
		labelDataInicio.setBounds(10, 230, 150, 30);
		
		JSpinner spinnerDataInicial = criarSppinerData();
		spinnerDataInicial.setBounds(10, 260, 260, 30);
		
		
		JLabel labelPrazo = new JLabel("Prazo");
		labelPrazo.setBounds(10, 295, 150, 30);
		
		JTextField txtPrazo = new JTextField();
		txtPrazo.setBounds(10, 330, 260, 30);
		
		
		
		JLabel labelDataPrevEnt = new JLabel("Data previsão de entrega");
		labelDataPrevEnt.setBounds(10, 365, 200, 30);
		
		JTextField txtDataPrevEnt = new JTextField();
		txtDataPrevEnt.setBounds(10, 400, 260, 30);
		
		JLabel labelStatus = new JLabel("Status: ");
		labelStatus.setBounds(10, 435, 55, 30);
		
		JComboBox<Enum> cbxStatus = new JComboBox<Enum>(Status.values());
		cbxStatus.setBounds(70, 435, 100, 30);
		
		
		
		
		
		JLabel labelDataEntrega = new JLabel("Data de entrega");
		labelDataEntrega.setBounds(10, 470, 200, 30);
		
		JTextField txtDataEntrega = new JTextField();
		txtDataEntrega.setBounds(10, 505, 260, 30);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 550, 135, 40);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(150, 550, 135, 40);
		
		Date date = (Date) spinnerDataInicial.getValue();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
				
				
				
				

		
		
		
		
		
		Container painel = tela.getContentPane();
		painel.add(labelNomeTarefa);
		painel.add(txtNomeTarefa);
		painel.add(labelDescricao);
		painel.add(txtDescricao);
		painel.add(cbxStatus);
		painel.add(labelResponsavel);
		//painel.add(txtResponsavel);
		painel.add(labelDataInicio);
		painel.add(spinnerDataInicial);
		//painel.add(txtDataInicio);	
		painel.add(labelPrazo);
		painel.add(txtPrazo);
		painel.add(labelDataPrevEnt);
		painel.add(txtDataPrevEnt);
		painel.add(labelStatus);
		painel.add(labelDataEntrega);
		painel.add(txtDataEntrega);
		painel.add(btnSalvar);
		painel.add(btnSair);
		painel.add(cbxFuncionarios);
		
		
		//int prazo = Integer.parseInt(txtDescricao.getText());
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tarefa t = new Tarefa();
				t.setNome(txtNomeTarefa.getText());
				t.setResponsavel((Funcionario) cbxFuncionarios.getSelectedItem());
				t.setDescricao(txtDescricao.getText());
				t.setStatus((Status) cbxStatus.getSelectedItem());
				t.setDataInicio(localDate);
				t.setPrazo(Integer.parseInt(txtPrazo.getText()));
				
				TarefasDAO dao = new TarefasDAO(t);
				dao.salvar();
				
				JOptionPane.showMessageDialog(tela, t.getNome()+ " gravado com sucesso");
				
				txtNomeTarefa.setText(null);
				txtDescricao.setText(null);
				
				
				//Date date = (Date) spinnerDataInicial.getValue();
				//LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				//t.setDataInicio(localDate); 

				
				
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



	private JSpinner criarSppinerData() {
		JSpinner spinner = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
		spinner.setEditor(editor);
		return spinner;

	}
	

	private Vector<Funcionario> carregarMatricula(){
		FuncionarioDAO dao = new FuncionarioDAO(null);
		List<Funcionario> funcionarios = dao.getFuncionarios();
		
		Vector<Funcionario> matriculas = new Vector<>();
		
		for (Funcionario f : funcionarios) {
			matriculas.add(f);
			//matriculas.add(f.getNome());
			//matriculas.add("M: " + f.getMatricula() + ", " + "N: " + f.getNome());
		}
		return matriculas;
	}
	

}
