package sistema_faturamento_comercial.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import sistema_faturamento_comercial.domain.EnderecoDomain;
import sistema_faturamento_comercial.domain.FuncionarioDomain;
import sistema_faturamento_comercial.service.EnderecoService;
import sistema_faturamento_comercial.service.FuncionarioService;
import sistema_faturamento_comercial.util.NegocioException;

public class TelaCadastroFuncionarioView extends JFrame {

	private JPanel contentPane;
	private JTextField codigoField;
	private JTextField nomeField;
	private JTextField pisField;
	private JTextField documentoField;
	private JTextField salarioField;
	private JTextField funcaoField;
	List<EnderecoDomain> enderecos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionarioView frame = new TelaCadastroFuncionarioView();
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
	public TelaCadastroFuncionarioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));

		codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		nomeField = new JTextField();
		nomeField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("PIS:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		pisField = new JTextField();
		pisField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Documento:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		documentoField = new JTextField();
		documentoField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Salário:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		salarioField = new JTextField();
		salarioField.setColumns(10);

		funcaoField = new JTextField();
		funcaoField.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Função:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_6 = new JLabel("Endereço:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));

		final JComboBox comboEndereco = new JComboBox();
		comboEndereco.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				EnderecoService enderecoService = new EnderecoService();
				try {
					enderecos = enderecoService.listarEnderecos();
					comboEndereco.removeAll();
					for (EnderecoDomain endereco : enderecos) {
						comboEndereco.addItem(endereco);
					}

				} catch (NegocioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuncionarioDomain funcionarioDomain = new FuncionarioDomain();
				EnderecoDomain endereco = new EnderecoDomain();

				funcionarioDomain.setNome(nomeField.getText());
				funcionarioDomain.setPis(pisField.getText());
				funcionarioDomain.setDocumento(documentoField.getText());
				funcionarioDomain.setSalario(new BigDecimal(salarioField.getText().replace(",", ".")));
				funcionarioDomain.setFuncao(funcaoField.getText());
				endereco = (EnderecoDomain) comboEndereco.getSelectedItem();
				funcionarioDomain.setEndereco(endereco.getId());
				try {
					if (codigoField.getText().equals("")) {
						new FuncionarioService().inserirFuncionario(funcionarioDomain);
					} else {
						funcionarioDomain.setId(Integer.parseInt(codigoField.getText()));
						new FuncionarioService().alterarFuncionario(funcionarioDomain);
					}
					limparCampos();
					JOptionPane.showMessageDialog(null, "Funcionário salvo com sucesso");
				} catch (NegocioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnNewButton_1_1 = new JButton("Voltar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenuView telaMenu = new TelaMenuView();
				telaMenu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblNewLabel_7 = new JLabel("Cadastro de funcionários");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
						.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(lblNewLabel_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 45,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1, Alignment.LEADING)
										.addComponent(lblNewLabel, Alignment.LEADING)
										.addComponent(lblNewLabel_4, Alignment.LEADING)
										.addComponent(lblNewLabel_5, Alignment.LEADING))
								.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 96,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(funcaoField, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
								.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addComponent(nomeField, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(salarioField, Alignment.LEADING)
										.addComponent(documentoField, Alignment.LEADING).addComponent(pisField,
												Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
								.addComponent(comboEndereco, 0, 651, Short.MAX_VALUE).addComponent(btnNewButton_1,
										Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 130,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel_7).addGap(157)))));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(25).addComponent(lblNewLabel_7)
								.addGap(105)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, 27,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(pisField, GroupLayout.PREFERRED_SIZE, 28,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_2))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(documentoField, GroupLayout.PREFERRED_SIZE, 27,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4).addComponent(salarioField,
												GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(funcaoField, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5))
								.addGap(31)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_6).addComponent(comboEndereco,
												GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 54,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 57,
												GroupLayout.PREFERRED_SIZE))
								.addContainerGap()));
		contentPane.setLayout(gl_contentPane);

	}

	private void limparCampos() {
		codigoField.setText("");
		nomeField.setText("");
		pisField.setText("");
		documentoField.setText("");
		salarioField.setText("");
		funcaoField.setText("");

	}
	
	public void carregarFuncionarioPorId(Integer id) {
		try {
			FuncionarioDomain funcionarioEncontrado = new FuncionarioService().buscarFuncionarioPorId(id);

			if (funcionarioEncontrado == null) {
				JOptionPane.showMessageDialog(null, "Funcionário não foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				codigoField.setText(Integer.toString(funcionarioEncontrado.getId()));
				nomeField.setText(funcionarioEncontrado.getNome());
				pisField.setText(funcionarioEncontrado.getPis());
				documentoField.setText(funcionarioEncontrado.getDocumento());
				salarioField.setText(funcionarioEncontrado.getSalario().toString());
				funcaoField.setText(funcionarioEncontrado.getFuncao());
				
			}

		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
