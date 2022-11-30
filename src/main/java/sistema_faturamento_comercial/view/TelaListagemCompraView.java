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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import sistema_faturamento_comercial.domain.CompraDomain;
import sistema_faturamento_comercial.service.CompraService;

public class TelaListagemCompraView extends JFrame {

	private JPanel contentPane;
	private JTable table;
    private List<CompraDomain> compras;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemCompraView frame = new TelaListagemCompraView();
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
	public TelaListagemCompraView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCompraView telaCadastroCompra = new TelaCadastroCompraView();
				telaCadastroCompra.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompraDomain compraSelecionada = compras.get(table.getSelectedRow());
				TelaCadastroCompraView telaCadastroCompra = new TelaCadastroCompraView();
				telaCadastroCompra.carregarCompraPorId(compraSelecionada.getId());
				telaCadastroCompra.setVisible(true);
				dispose();
				
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompraDomain compraSelecionada = compras.get(table.getSelectedRow());
                if (JOptionPane.showConfirmDialog(null, "Deseja excluir a compra?") == JOptionPane.OK_OPTION) {
                    try {
                        new CompraService().excluirCompra(compraSelecionada.getId());
                        popularTabela();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                }
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton detalhesButton = new JButton("Detalhes");
		detalhesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagemCompraProdutoView telaListagemCompraProduto = new TelaListagemCompraProdutoView();
				telaListagemCompraProduto.setVisible(true);
				dispose();
			}
		});
		detalhesButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_1_1 = new JButton("Voltar");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 667, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(detalhesButton)
							.addPreferredGap(ComponentPlacement.RELATED, 502, Short.MAX_VALUE)
							.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(80, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(detalhesButton, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
							.addComponent(btnEditar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Data", "Forma de pagamento", "C\u00F3digo endere\u00E7o", "C\u00F3digo cliente"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}
	
	private void popularTabela() {
		try {
			compras = new CompraService().listarCompras();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();
			
			for (CompraDomain compra : compras) {
				model.addRow(new Object[] { compra.getId(), compra.getDataCompra(), compra.getFormaPagamento(), compra.getEnderecoId(), compra.getClienteId() });
				   
			   }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar funcionários do banco de dados");
		}
	}

}
