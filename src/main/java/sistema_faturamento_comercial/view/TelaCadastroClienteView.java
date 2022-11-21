package sistema_faturamento_comercial.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import sistema_faturamento_comercial.domain.ClienteDomain;
import sistema_faturamento_comercial.service.ClienteService;
import sistema_faturamento_comercial.util.NegocioException;

public class TelaCadastroClienteView extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField emailField;
	private JTextField documentoField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_4;
	private JTextField idField;
	private JLabel lblNewLabel_5;
	private JTextField dataField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroClienteView frame = new TelaCadastroClienteView();
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
	public TelaCadastroClienteView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 722, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Documento: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_3 = new JLabel("Data de nascimento:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		nomeField = new JTextField();
		nomeField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		
		documentoField = new JTextField();
		documentoField.setColumns(10);
		
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ClienteDomain cliente = new ClienteDomain();
				cliente.setNome(nomeField.getText());
				cliente.setEmail(emailField.getText());
				cliente.setDocumento(documentoField.getText());
				cliente.setDataNascimento(LocalDate.parse(dataField.getText(), formatter));
				
			try {
				if (idField.getText().equals("")) {
					
						new ClienteService().inserirCliente(cliente);
					} else {
						cliente.setId(Integer.parseInt(idField.getText()));
						new ClienteService().alterarCliente(cliente);
				} 
				limparCampos();
				JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso");
			} catch (NegocioException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TelaListagemClienteView telaListagem = new TelaListagemClienteView();
			telaListagem.setVisible(true);
			dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblNewLabel_4 = new JLabel("CADASTRO DE CLIENTES");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 25));
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setColumns(10);
		
		lblNewLabel_5 = new JLabel("ID:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		dataField = new JTextField();
		dataField.setToolTipText("");
		dataField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(emailField, 529, 529, 529))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(documentoField, 149, 149, 149)
							.addGap(18)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(dataField))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(204)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, 528, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(60, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(209, Short.MAX_VALUE)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
					.addGap(203))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(idField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(dataField)
						.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(documentoField, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, Alignment.TRAILING))
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addGap(32))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void limparCampos() {
		idField.setText("");
		nomeField.setText("");
		emailField.setText("");
		documentoField.setText("");
		dataField.setText("");
		
	}
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public void carregarClientePorId(Integer id) {
		try {
			ClienteDomain clienteEncontrado = new ClienteService().buscarClientePorId(id);

			if (clienteEncontrado == null) {
				JOptionPane.showMessageDialog(null, "Cliente não foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				idField.setText(Integer.toString(clienteEncontrado.getId()));
				nomeField.setText(clienteEncontrado.getNome());
				emailField.setText(clienteEncontrado.getEmail());
				documentoField.setText(clienteEncontrado.getDocumento());
				dataField.setText(clienteEncontrado.getDataNascimento().format(formatter));
			}

		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
