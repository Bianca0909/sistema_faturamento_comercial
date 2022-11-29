package sistema_faturamento_comercial.view;

import java.awt.EventQueue;
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

import sistema_faturamento_comercial.domain.ProdutoDomain;
import sistema_faturamento_comercial.service.ProdutoService;
import sistema_faturamento_comercial.util.NegocioException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Font;

public class TelaListagemProdutoView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private List<ProdutoDomain> Produtos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemProdutoView frame = new TelaListagemProdutoView();
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
	public TelaListagemProdutoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton inserirButton = new JButton("Adicionar");
		inserirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProdutoView telaCadastro = new TelaCadastroProdutoView();
				telaCadastro.setVisible(true);
				dispose();
			}
		});
		
		JButton editarButton = new JButton("Editar");
		editarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoDomain ProdutoSelecionado = Produtos.get(table.getSelectedRow());
				TelaCadastroProdutoView telaCadastro = new TelaCadastroProdutoView();
				telaCadastro.carregarProdutoPorId(ProdutoSelecionado.getId());
				telaCadastro.setVisible(true);
				dispose();
			}
		});
		
		JButton excluirButton = new JButton("Excluir");
		excluirButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoDomain ProdutoSelecionado = Produtos.get(table.getSelectedRow());
				if (JOptionPane.showConfirmDialog(null, "Deseja excluir o Produto?") != JOptionPane.OK_OPTION) {
					return;
				}
				
				try {
					new ProdutoService().excluirProduto(ProdutoSelecionado.getId());
					popularTabela();
				} catch (NegocioException e1) {
					
					JOptionPane.showConfirmDialog(null, e1.getMensagemDeErro());
				}
			}
		});
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(612)
					.addComponent(excluirButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(editarButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(inserirButton)
					.addContainerGap(79, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(56, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 808, GroupLayout.PREFERRED_SIZE)
					.addGap(40))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(410, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(397))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(93)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(excluirButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(editarButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(inserirButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(19))
		);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Descrição", "Preço", "Quantidade", "Código Marca", "Código Categoria"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}
	
	private void popularTabela() {
		try {
			Produtos = new ProdutoService().listarProdutos();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (ProdutoDomain ProdutoDomain : Produtos) {
				model.addRow(new Object[] { ProdutoDomain.getId(), ProdutoDomain.getNome(), ProdutoDomain.getDescricao(),
						ProdutoDomain.getPreco(), ProdutoDomain.getQuantidade(), ProdutoDomain.getMarcaId(), ProdutoDomain.getCategoriaId() });
			}
		} catch (NegocioException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao buscar Produtos do banco de dados");
		}
	}
}
