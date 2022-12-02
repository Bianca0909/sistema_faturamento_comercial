package sistema_faturamento_comercial.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sistema_faturamento_comercial.domain.ClienteDomain;
import sistema_faturamento_comercial.domain.EnderecoDomain;
import sistema_faturamento_comercial.service.ClienteService;
import sistema_faturamento_comercial.service.EnderecoService;
import sistema_faturamento_comercial.util.NegocioException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TelaCadastroEnderecoView extends JFrame {

	private JPanel contentPane;
	private JTextField codigoField;
	private JTextField paisField;
	private JTextField estadoField;
	private JTextField cidadeField;
	private JTextField cepField;
	private JTextField ruaField;
	private JTextField numeroField;
	private JTextField complementoField;
	private JTextField bairroField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEnderecoView frame = new TelaCadastroEnderecoView();
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
	public TelaCadastroEnderecoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Cadastro de endereços");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Código:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("País:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("Estado:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_4 = new JLabel("Cidade:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_5 = new JLabel("CEP:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_6 = new JLabel("Rua:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_7 = new JLabel("Número:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_8 = new JLabel("Complemento:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setColumns(10);
		
		paisField = new JTextField();
		paisField.setColumns(10);
		
		estadoField = new JTextField();
		estadoField.setColumns(10);
		
		cidadeField = new JTextField();
		cidadeField.setColumns(10);
		
		cepField = new JTextField();
		cepField.setColumns(10);
		
		ruaField = new JTextField();
		ruaField.setColumns(10);
		
		numeroField = new JTextField();
		numeroField.setColumns(10);
		
		complementoField = new JTextField();
		complementoField.setColumns(10);
		
		JButton voltarButton = new JButton("Voltar");
		voltarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagemEnderecoView telaListagemEndereco = new TelaListagemEnderecoView();
				telaListagemEndereco.setVisible(true);
				dispose();
			}
		});
		voltarButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnderecoDomain enderecoDomain = new EnderecoDomain();
				
				enderecoDomain.setPais(paisField.getText());
				enderecoDomain.setEstado(estadoField.getText());
				enderecoDomain.setCidade(cidadeField.getText());
				enderecoDomain.setCep(cepField.getText());
				enderecoDomain.setBairro(bairroField.getText());
				enderecoDomain.setRua(ruaField.getText());
				enderecoDomain.setNumero(Long.parseLong(numeroField.getText()));
				enderecoDomain.setComplemento(complementoField.getText());
				
				
				try {
					if (codigoField.getText().equals("")) {
						new EnderecoService().inserirEndereco(enderecoDomain);	
					} else {
						enderecoDomain.setId(Integer.parseInt(codigoField.getText()));
						new EnderecoService().alterarEndereco(enderecoDomain);
					}
					limparCampos();
				} catch (NegocioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		cadastrarButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_9 = new JLabel("Bairro:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		bairroField = new JTextField();
		bairroField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(157)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(bairroField, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(voltarButton)
									.addPreferredGap(ComponentPlacement.RELATED, 360, Short.MAX_VALUE)
									.addComponent(cadastrarButton))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cepField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(paisField, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_3)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblNewLabel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(cidadeField, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
										.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
										.addComponent(estadoField, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(ruaField, GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(numeroField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(complementoField, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(paisField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(estadoField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(cidadeField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(cepField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_9)
						.addComponent(bairroField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(ruaField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_7)
						.addComponent(numeroField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(complementoField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(voltarButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cadastrarButton, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void limparCampos() {
		codigoField.setText("");
		paisField.setText("");
		estadoField.setText("");
		cidadeField.setText("");
		cepField.setText("");
		bairroField.setText("");
		ruaField.setText("");
		numeroField.setText("");
		complementoField.setText("");
		
	}
	
	public void carregarEnderecoPorId(Integer id) {
		try {
			EnderecoDomain enderecoEncontrado = new EnderecoService().buscarEnderecoPorId(id);

			if (enderecoEncontrado == null) {
				JOptionPane.showMessageDialog(null, "Endereço não foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				codigoField.setText(Integer.toString(enderecoEncontrado.getId()));
				paisField.setText(enderecoEncontrado.getPais());
				estadoField.setText(enderecoEncontrado.getEstado());
				cidadeField.setText(enderecoEncontrado.getCidade());
				cepField.setText(enderecoEncontrado.getCep());
				ruaField.setText(enderecoEncontrado.getRua());
				bairroField.setText(enderecoEncontrado.getBairro());
				numeroField.setText(enderecoEncontrado.getNumero().toString());
				complementoField.setText(enderecoEncontrado.getComplemento());
				
			}

		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
