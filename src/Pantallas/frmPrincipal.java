package Pantallas;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class frmPrincipal extends JFrame{
	public frmPrincipal() {
		setTitle("Administracion PDD Jos\u00E9 C. Paz");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Toolkit t = Toolkit.getDefaultToolkit();
		this.setBounds(0, 0, t.getScreenSize().width, t.getScreenSize().height);
				
	}

}
