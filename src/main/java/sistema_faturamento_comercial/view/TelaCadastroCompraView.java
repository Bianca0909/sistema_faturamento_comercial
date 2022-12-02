package sistema_faturamento_comercial.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
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

import sistema_faturamento_comercial.dao.ProdutoDAO;
import sistema_faturamento_comercial.domain.ClienteDomain;
import sistema_faturamento_comercial.domain.CompraDomain;
import sistema_faturamento_comercial.domain.EnderecoDomain;
import sistema_faturamento_comercial.domain.ProdutoDomain;
import sistema_faturamento_comercial.service.ClienteService;
import sistema_faturamento_comercial.service.CompraService;
import sistema_faturamento_comercial.service.EnderecoService;
import sistema_faturamento_comercial.util.NegocioException;

public class TelaCadastroCompraView extends JFrame {

	private JPanel contentPane;
	private JTextField codigoField;
    private List<ClienteDomain> clientes;
    private List<ProdutoDomain> produtos;
    private List<EnderecoDomain> enderecos;
    private JTextField formaPagamentoField;
  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCompraView frame = new TelaCadastroCompraView();
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
	public TelaCadastroCompraView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		final JComboBox comboCliente = new JComboBox();
		comboCliente.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				ClienteService clienteService = new ClienteService();
				try {
					clientes = clienteService.listarClientes();
					comboCliente.removeAll();
					for(ClienteDomain cliente: clientes) {
						comboCliente.addItem(cliente);
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
		
		JLabel lblNewLabel_2 = new JLabel("Endereço:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
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
		
		JLabel lblNewLabel_3 = new JLabel("Forma de pagamento:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
	
		
		JButton btnNewButton = new JButton("Prosseguir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompraDomain compra = new CompraDomain();
				ClienteDomain cliente = new ClienteDomain();
				EnderecoDomain endereco = new EnderecoDomain();
				ProdutoDomain produto = new ProdutoDomain();
				ProdutoDAO produtoDao = new ProdutoDAO();
				
				compra.setDataCompra(LocalDate.now());
				compra.setFormaPagamento(formaPagamentoField.getText());
				endereco = (EnderecoDomain) comboEndereco.getSelectedItem();
				compra.setEnderecoId(endereco.getId());
				cliente = (ClienteDomain) comboCliente.getSelectedItem();
				compra.setClienteId(cliente.getId());
				
				try {
					if (codigoField.getText().equals("")) {
						new CompraService().inserirCompra(compra);
					} else {
						compra.setId(Integer.parseInt(codigoField.getText()));
						new CompraService().alterarCompra(compra);
						
					}
				
					
				} catch (NegocioException e1) {
					e1.printStackTrace();
				}
				
				TelaFinalizarCompraView telaFinalizacao = new TelaFinalizarCompraView();
				telaFinalizacao.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagemCompraView telaListagemCompra = new TelaListagemCompraView();
				telaListagemCompra.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_7 = new JLabel("ÁREA DE COMPRA");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		formaPagamentoField = new JTextField();
		formaPagamentoField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(24)
											.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(comboCliente, 0, 611, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(comboEndereco, 0, 768, Short.MAX_VALUE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(formaPagamentoField, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
							.addGap(267))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 599, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_7)
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboCliente, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
								.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboEndereco, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addComponent(formaPagamentoField, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void carregarCompraPorId(Integer id) {
		try {
			CompraDomain compraEncontrada = new CompraService().buscarCompraPorId(id);

			if (compraEncontrada == null) {
				JOptionPane.showMessageDialog(null, "Funcionário não foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				codigoField.setText(Integer.toString(compraEncontrada.getId()));
				
				
			}

		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
