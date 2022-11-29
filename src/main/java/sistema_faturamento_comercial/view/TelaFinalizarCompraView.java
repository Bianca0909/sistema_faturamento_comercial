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

import sistema_faturamento_comercial.domain.CompraDomain;
import sistema_faturamento_comercial.domain.CompraProdutoDomain;
import sistema_faturamento_comercial.domain.ProdutoDomain;
import sistema_faturamento_comercial.service.CompraProdutoService;
import sistema_faturamento_comercial.service.CompraService;
import sistema_faturamento_comercial.service.ProdutoService;
import sistema_faturamento_comercial.util.NegocioException;
import java.awt.Color;

public class TelaFinalizarCompraView extends JFrame {

	private JPanel contentPane;
	private JTextField quantidadeField;
	List<CompraDomain> compras;
	List<ProdutoDomain> produtos;
	private JTextField totalField;
	private JTextField codigoField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFinalizarCompraView frame = new TelaFinalizarCompraView();
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
	public TelaFinalizarCompraView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ÁREA DA COMPRA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_1 = new JLabel("Número da compra:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		final JComboBox comboCompra = new JComboBox();
		comboCompra.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				CompraService compraService = new CompraService();
				try {
					compras = compraService.listarCompras();
					comboCompra.removeAll();
					for(CompraDomain compra: compras) {
						comboCompra.addItem(compra);
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
		
		JLabel lblNewLabel_2 = new JLabel("Produto: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		final JComboBox comboProdutos = new JComboBox();
		comboProdutos.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				ProdutoService produtoService = new ProdutoService();
				try {
					produtos = produtoService.listarProdutos();
					comboCompra.removeAll();
					for(ProdutoDomain produto: produtos) {
						comboProdutos.addItem(produto);
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
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		quantidadeField = new JTextField();
		quantidadeField.setColumns(10);
		
		JButton btnNewButton = new JButton("Finalizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompraProdutoDomain compraProduto = new CompraProdutoDomain();
				ProdutoDomain produto = new ProdutoDomain();
				CompraDomain compra = new CompraDomain();
				
				compra = (CompraDomain) comboCompra.getSelectedItem();
				compraProduto.setCompraId(compra.getId());
				produto = (ProdutoDomain) comboProdutos.getSelectedItem();
				compraProduto.setProdutoId(produto.getId());
				compraProduto.setQuantidade(Integer.parseInt(quantidadeField.getText()));
				compraProduto.setTotal(compraProduto.retornaTotal(produto, Integer.parseInt(quantidadeField.getText())));
				

				try {
					if (codigoField.getText().equals("")) {
						new CompraProdutoService().inserirCompraProduto(compraProduto);
					} else {
						compraProduto.setId(Integer.parseInt(codigoField.getText()));
						new CompraProdutoService().alterarCompraProduto(compraProduto);
					}
				} catch (NegocioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		totalField = new JTextField();
		totalField.setEditable(false);
		totalField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Total:");
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_5 = new JLabel("Código finalização: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Calcular valor");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 557, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)
							.addGap(290))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(26)
							.addComponent(comboCompra, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(totalField, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_2))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboProdutos, GroupLayout.PREFERRED_SIZE, 391, GroupLayout.PREFERRED_SIZE)
									.addGap(24)
									.addComponent(lblNewLabel_3)
									.addGap(4)
									.addComponent(quantidadeField, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(88, Short.MAX_VALUE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboCompra, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(49)
							.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(quantidadeField, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboProdutos, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addComponent(lblNewLabel_3)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(totalField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
