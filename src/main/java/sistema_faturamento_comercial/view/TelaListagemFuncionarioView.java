package sistema_faturamento_comercial.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sistema_faturamento_comercial.domain.FuncionarioDomain;
import sistema_faturamento_comercial.service.FuncionarioService;
import javax.swing.JLabel;
import java.awt.Color;

public class TelaListagemFuncionarioView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List<FuncionarioDomain> funcionarios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemFuncionarioView frame = new TelaListagemFuncionarioView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaListagemFuncionarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton adicionarButton = new JButton("Adicionar");
		adicionarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroFuncionarioView telaCadastroFuncionario = new TelaCadastroFuncionarioView();
				telaCadastroFuncionario.setVisible(true);
				dispose();
			}
		});
		adicionarButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioDomain funcionarioSelecionado = funcionarios.get(table.getSelectedRow());
                TelaCadastroFuncionarioView telaCadastroFuncionario = new TelaCadastroFuncionarioView();
                telaCadastroFuncionario.carregarFuncionarioPorId(funcionarioSelecionado.getId(), funcionarioSelecionado.getEndereco());
                telaCadastroFuncionario.setVisible(true);
                dispose();
				
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_1_1 = new JButton("Excluir");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioDomain funcionarioSelecionado = funcionarios.get(table.getSelectedRow());
                if (JOptionPane.showConfirmDialog(null, "Deseja excluir o funcionário?") == JOptionPane.OK_OPTION) {
                    try {
                        new FuncionarioService().excluirFuncionario(funcionarioSelecionado.getId());
                        popularTabela();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                }
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuView telaMenu = new TelaMenuView();
				telaMenu.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnCadastrar = new JButton("Sair");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_4 = new JLabel("LISTAGEM DE FUNCIONÁRIOS");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 647, Short.MAX_VALUE)
									.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(adicionarButton, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(286)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(adicionarButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
						.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "PIS", "Documento", "Sal\u00E1rio", "Fun\u00E7\u00E3o", "Endere\u00E7o "
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}
	
	private void popularTabela() {
		try {
			funcionarios = new FuncionarioService().listarFuncionarios();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (FuncionarioDomain funcionario : funcionarios) {
				model.addRow(new Object[] { funcionario.getId(), funcionario.getNome(), funcionario.getPis(), funcionario.getDocumento(), funcionario.getSalario(), funcionario.getFuncao(), funcionario.getEndereco() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar funcionários do banco de dados");
		}
	}
}
