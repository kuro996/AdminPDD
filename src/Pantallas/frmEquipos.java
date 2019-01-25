package Pantallas;

import javax.swing.JDialog;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class frmEquipos extends JDialog{
	public frmEquipos() {
		setMinimumSize(new Dimension(400, 500));
		setTitle("Equipos");
		setModal(true);
		
		JLabel lblNewLabel = new JLabel("New label");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(166)
					.addComponent(lblNewLabel)
					.addContainerGap(222, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(120)
					.addComponent(lblNewLabel)
					.addContainerGap(127, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
