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
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

public class frmLogin extends JFrame {
	private JTextField textUsu;
	private JTextField textPass;
	private JButton btnIngresar;
	private JButton btnCancelar;

	public frmLogin() {

		Toolkit t = Toolkit.getDefaultToolkit();
		this.setBounds(t.getScreenSize().width / 2 - 200, t.getScreenSize().height / 2 - 100, 400, 200);
		
		setMinimumSize(new Dimension(400, 200));
		setTitle("Ingreso al Sistema");
		

		btnIngresar = new JButton("Ingresar");

		btnCancelar = new JButton("Cancelar");

		textUsu = new JTextField();
		textUsu.setColumns(10);

		textPass = new JPasswordField();
		textPass.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");

		JLabel lblPassword = new JLabel("Password");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(btnIngresar, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
					.addGap(77)
					.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addGap(56))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUsuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(10))
						.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textPass, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
						.addComponent(textUsu, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
					.addGap(106))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textUsu)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblUsuario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textPass)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIngresar)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(41))
		);
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