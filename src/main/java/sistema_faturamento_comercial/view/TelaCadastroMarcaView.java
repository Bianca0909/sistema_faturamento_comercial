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

import sistema_faturamento_comercial.domain.MarcaDomain;
import sistema_faturamento_comercial.service.MarcaService;
import sistema_faturamento_comercial.util.NegocioException;
import java.awt.Color;

public class TelaCadastroMarcaView extends JFrame {

	private JPanel contentPane;
	private JTextField codigoCampo;
	private JTextField nomeCampo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroMarcaView frame = new TelaCadastroMarcaView();
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
	public TelaCadastroMarcaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel codigoId = new JLabel("Código: ");
		codigoId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		codigoCampo = new JTextField();
		codigoCampo.setEditable(false);
		codigoCampo.setColumns(10);
		
		JLabel nomeLabel = new JLabel("Nome: ");
		nomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		nomeCampo = new JTextField();
		nomeCampo.setColumns(10);
		
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MarcaDomain marca = new MarcaDomain();
                marca.setNome(nomeCampo.getText());

                try {
					if (codigoCampo.getText().equals("")) {
						new MarcaService().inserirMarca(marca);	
					} else {
						marca.setId(Integer.parseInt(codigoCampo.getText()));
						new MarcaService().alterarMarca(marca);
					}
					limparCampos();
				} catch (NegocioException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton sairButton = new JButton("Sair");
		sairButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagemMarcaView telaListagem = new TelaListagemMarcaView();
				telaListagem.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("CADASTRO DE MARCAS");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(61)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(codigoId)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(codigoCampo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(nomeLabel, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(nomeCampo, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(sairButton, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
											.addComponent(cadastrarButton))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(93, Short.MAX_VALUE)
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(codigoId)
						.addComponent(codigoCampo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(nomeCampo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(nomeLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(cadastrarButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(sairButton, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
					.addGap(23))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void limparCampos() {
        codigoCampo.setText("");
        nomeCampo.setText("");

    }

    public void carregarMarcaPorId(Integer id) {
        try {
            MarcaDomain marcaEncontrado = new MarcaService().buscarMarcaPorId(id);

            if (marcaEncontrado == null) {
                JOptionPane.showMessageDialog(null, "Cliente não foi localizado", "Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                codigoCampo.setText(Integer.toString(marcaEncontrado.getId()));
                nomeCampo.setText(marcaEncontrado.getNome());
            }

        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(null, e.getMensagemDeErro(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
