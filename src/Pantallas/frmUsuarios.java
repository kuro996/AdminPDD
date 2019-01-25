package Pantallas;

import javax.swing.JDialog;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class frmUsuarios extends JDialog{
	public frmUsuarios() {
		
		setMinimumSize(new Dimension(400, 500));
		setTitle("Usuarios");
		setModal(true);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 261, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
