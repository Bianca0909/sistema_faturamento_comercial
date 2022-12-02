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

import sistema_faturamento_comercial.domain.MarcaDomain;
import sistema_faturamento_comercial.service.MarcaService;
import javax.swing.ListSelectionModel;

public class TelaListagemMarcaView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List<MarcaDomain> marcas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemMarcaView frame = new TelaListagemMarcaView();
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
	public TelaListagemMarcaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaCadastroMarcaView telaCadastro = new TelaCadastroMarcaView();
				telaCadastro.setVisible(true);
				dispose();

			}
		});

		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarcaDomain marcaSelecionada = marcas.get(table.getSelectedRow());
                TelaCadastroMarcaView telaCadastroMarca = new TelaCadastroMarcaView();
                telaCadastroMarca.carregarMarcaPorId(marcaSelecionada.getId());
                telaCadastroMarca.setVisible(true);
                dispose();
			}
		});

		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarcaDomain marcaSelecionada = marcas.get(table.getSelectedRow());
                if (JOptionPane.showConfirmDialog(null, "Deseja excluir a marca?") == JOptionPane.OK_OPTION) {
                    try {
                        new MarcaService().excluirMarca(marcaSelecionada.getId());
                        popularTabela();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
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
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnNewButton_4 = new JButton("Sair");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnNewButton_3)
								.addPreferredGap(ComponentPlacement.RELATED, 437, Short.MAX_VALUE)
								.addComponent(btnNewButton_4))
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addComponent(btnNewButton_2)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton_1)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNewButton))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(54)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
						.addContainerGap()));

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "Nome" }));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		popularTabela();
	}

	private void popularTabela() {
		try {
			marcas = new MarcaService().listarMarcas();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.getDataVector().removeAllElements();

			for (MarcaDomain marca : marcas) {
				model.addRow(new Object[] { marca.getId(), marca.getNome() });
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar marcas do banco de dados");
		}
	}
}
