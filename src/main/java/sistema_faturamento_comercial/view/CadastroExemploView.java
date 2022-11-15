package sistema_faturamento_comercial.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import sistema_faturamento_comercial.domain.ExemploDomain;
import sistema_faturamento_comercial.service.ExemploService;
import sistema_faturamento_comercial.util.NegocioException;

public class CadastroExemploView extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField codigoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroExemploView frame = new CadastroExemploView();
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
	public CadastroExemploView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Exemplo de cadastro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		nomeField = new JTextField();
		nomeField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExemploDomain exemplo = new ExemploDomain();
				exemplo.setNome(nomeField.getText());
				
				new ExemploService().inserirExemplo(exemplo);
				limparCampos();
				JOptionPane.showMessageDialog(null, "Exemplo salvo com sucesso");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		codigoField = new JTextField();
		codigoField.setEditable(false);
		codigoField.setColumns(10);
		
		JLabel codigotext = new JLabel("Código: ");
		codigotext.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(264)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(codigotext, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
							.addGap(61)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
								.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(270, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(306, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(278))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(codigoField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(codigotext, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nomeField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(55))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void limparCampos() {
		codigoField.setText("");
		nomeField.setText("");
		
	}
	
	public void carregarExemploPorId(Integer id) {
		try {
			ExemploDomain exemploEncontrado = new ExemploService().buscarExemploPorId(id);

			if (exemploEncontrado == null) {
				JOptionPane.showMessageDialog(null, "Cliente não foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
			} else {
				codigoField.setText(Integer.toString(exemploEncontrado.getId()));
				nomeField.setText(exemploEncontrado.getNome());
			}

		} catch (NegocioException e) {
			JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
