package Pantallas;

import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class frmLogin extends JFrame {
	private JTextField textUsu;
	private JTextField textPass;
	private JButton btnIngresar;
	private JButton btnCancelar;

	public frmLogin() {
		setTitle("Ingreso al Sistema");

		this.setResizable(false);
		Toolkit t = Toolkit.getDefaultToolkit();
		this.setBounds(t.getScreenSize().width / 2 - 200, t.getScreenSize().height / 2 - 100, 400, 200);

		btnIngresar = new JButton("Ingresar");

		btnCancelar = new JButton("Cancelar");

		textUsu = new JTextField();
		textUsu.setColumns(10);

		textPass = new JPasswordField();
		textPass.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");

		JLabel lblPassword = new JLabel("Password");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(48)
						.addComponent(btnIngresar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
						.addGap(56))
				.addGroup(groupLayout.createSequentialGroup().addGap(31)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblUsuario)
								.addComponent(lblPassword))
						.addGap(45)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textPass, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
								.addComponent(textUsu, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(116, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(33)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textUsu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsuario))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword))
						.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnIngresar)
								.addComponent(btnCancelar))
						.addGap(46)));
		getContentPane().setLayout(groupLayout);

	}

	public JTextField getTextUsu() {
		return textUsu;
	}

	public void setTextUsu(JTextField textUsu) {
		this.textUsu = textUsu;
	}

	public JTextField getTextPass() {
		return textPass;
	}

	public void setTextPass(JTextField textPass) {
		this.textPass = textPass;
	}

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}
}