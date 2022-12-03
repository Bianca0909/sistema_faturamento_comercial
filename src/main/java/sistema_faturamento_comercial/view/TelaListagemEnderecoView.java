package sistema_faturamento_comercial.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import sistema_faturamento_comercial.domain.ClienteDomain;
import sistema_faturamento_comercial.domain.EnderecoDomain;
import sistema_faturamento_comercial.service.ClienteService;
import sistema_faturamento_comercial.service.EnderecoService;
import sistema_faturamento_comercial.util.NegocioException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class TelaListagemEnderecoView extends JFrame {
	private JTable table;
	List<EnderecoDomain> enderecos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemEnderecoView frame = new TelaListagemEnderecoView();
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
	public TelaListagemEnderecoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 467);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroEnderecoView telacadastroEndereco = new TelaCadastroEnderecoView();
				telacadastroEndereco.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnderecoDomain enderecoSelecionado = enderecos.get(table.getSelectedRow());
				TelaCadastroEnderecoView telaCadastroEndereco = new TelaCadastroEnderecoView();
				telaCadastroEndereco.carregarEnderecoPorId(enderecoSelecionado.getId());
				telaCadastroEndereco.setVisible(true);
				dispose();
			}
		});
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnderecoDomain enderecoSelecionado = enderecos.get(table.getSelectedRow());
				
				if(JOptionPane.showConfirmDialog(null, "Deseja excluir o endereço?") == JOptionPane.OK_CANCEL_OPTION) {
					
					try {
						new EnderecoService().excluirEndereco(enderecoSelecionado.getId());
						popularTabela();
					} catch (NegocioException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showConfirmDialog(null, e1.getMensagemDeErro());
					}
				}
			}
		});
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuView telaMenu = new TelaMenuView();
				telaMenu.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("LISTAGEM DE ENDEREÇOS");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 25));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 729, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(227)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Pa\u00EDs", "Estado", "Cidade", "CEP", "Bairro", "Rua", "N\u00FAmero", "Complemento"
			}
		));
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		popularTabela();
	}
	
	
	private void popularTabela() {
		try {
			enderecos = new EnderecoService().listarEnderecos();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (EnderecoDomain enderecoDomain : enderecos) {
				model.addRow(new Object[] { enderecoDomain.getId(), enderecoDomain.getPais(), enderecoDomain.getEstado(),
						enderecoDomain.getCidade(), enderecoDomain.getCep(), enderecoDomain.getBairro(), enderecoDomain.getRua(),
						enderecoDomain.getNumero(), enderecoDomain.getComplemento()});
			}
		} catch (NegocioException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar clientes do banco de dados");
		}
	}
}
