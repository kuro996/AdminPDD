package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import Main.AdminPDD;
import Pantallas.frmPermisos;

public class PermisoController implements ActionListener, MouseListener {

	private static final String name = "Principal.Seguridad.Permisos";
	private frmPermisos ventana;
	private AdminPDD modelo;

	public PermisoController(frmPermisos ventana, AdminPDD modelo) {
		this.ventana = ventana;
		this.modelo = modelo;
		this.ventana.getArbPermisos().addMouseListener(this);
		this.ventana.getBtnEditar().addActionListener(this);
		this.verificarPermisos();
	}

	public void inicializar() {
		for (int i = 0; i < this.ventana.getArbPermisos().getRowCount(); i++) {
			this.ventana.getArbPermisos().expandRow(i);
		}
		this.ventana.setVisible(true);
	}

	private void verificarPermisos() {
		ArrayList<String> per = this.modelo.Permisos(this.name);
		this.ventana.getBtnEditar().setVisible(per.contains((String) "Permisos.editar"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.ventana.getBtnEditar()) {
			if (this.ventana.getBtnEditar().getText().equals("Editar")) {
				this.ventana.getBtnEditar().setText("Aceptar");
				this.ventana.getArbPermisos().setEnabled(true);
								
			} else {
				this.ventana.getArbPermisos().clearSelection();
				this.ventana.getArbPermisos().setEnabled(false);
				this.ventana.getBtnEditar().setText("Editar");
				
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!this.ventana.getArbPermisos().isEnabled())
			this.ventana.getArbPermisos().clearSelection();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
