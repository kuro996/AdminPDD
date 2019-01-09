package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Main.Main;
import Pantallas.frmPrincipal;

public class PrincipalController implements ActionListener {
	
	private frmPrincipal ventana;

	public PrincipalController(frmPrincipal ventana) {
		this.ventana = ventana;
		this.ventana.getItmCerrarSesion().addActionListener(this);
		this.ventana.getItmSalir().addActionListener(this);
	}
	
	public void inicializar() {
		this.ventana.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.ventana.getItmCerrarSesion()) {
			this.ventana.dispose();
			Main.main(null);
		}else if(e.getSource()==this.ventana.getItmSalir()) {
			this.ventana.dispose();
		}
		
	}
}
