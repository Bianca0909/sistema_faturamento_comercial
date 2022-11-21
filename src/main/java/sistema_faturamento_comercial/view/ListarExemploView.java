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
import javax.swing.table.DefaultTableModel;

import sistema_faturamento_comercial.domain.ExemploDomain;
import sistema_faturamento_comercial.service.ExemploService;
import javax.swing.ListSelectionModel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ListarExemploView extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private List<ExemploDomain> exemplos;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarExemploView frame = new ListarExemploView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListarExemploView() {
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroExemploView cadastroExemploView = new CadastroExemploView();
				cadastroExemploView.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setIcon(null);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExemploDomain exemploSelecionado = exemplos.get(table.getSelectedRow());
				CadastroExemploView cadastroExemploView = new CadastroExemploView();
				cadastroExemploView.carregarExemploPorId(exemploSelecionado.getId());
				cadastroExemploView.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setIcon(null);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExemploDomain exemploSelecionado = exemplos.get(table.getSelectedRow());
				if (JOptionPane.showConfirmDialog(null, "Deseja excluir o cliente?") == JOptionPane.OK_OPTION) {
					try {
						new ExemploService().excluirExemplo(exemploSelecionado.getId());
						popularTabela();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setIcon(null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(170, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(439)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 752, GroupLayout.PREFERRED_SIZE))
					.addGap(20))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(126, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnNewButton, 0, 0, Short.MAX_VALUE)
							.addComponent(btnNewButton_1, 0, 0, Short.MAX_VALUE)))
					.addGap(20)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE)
					.addGap(27))
		);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		popularTabela();
	}
	
	private void popularTabela() {
		try {
			exemplos = new ExemploService().listarExemplo();
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.getDataVector().removeAllElements();
			
			for (ExemploDomain exemplo: exemplos) {
				model.addRow(new Object[] { exemplo.getId(), exemplo.getNome()});
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar exemplo do banco de dados");
		}
	}
}
