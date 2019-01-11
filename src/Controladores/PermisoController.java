package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import Main.AdminPDD;
import Pantallas.frmPermisos;

public class PermisoController implements ActionListener, MouseListener
{

	private static final String name = "Permisos";
	private frmPermisos ventana;
	private AdminPDD modelo;

	public PermisoController(frmPermisos ventana, AdminPDD modelo)
	{
		this.ventana = ventana;
		this.modelo = modelo;
		this.ventana.getArbPermisos().addMouseListener(this);
		this.verificarPermisos();
	}

	public void inicializar()
	{
		ArrayList<String> per = this.modelo.Permisos(this.name);
		this.ventana.getBtnEditar().setVisible(per.contains((String) "Permisos.editar"));

		this.ventana.setVisible(true);
	}

	private void verificarPermisos()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (!this.ventana.getArbPermisos().isEnabled())
			this.ventana.getArbPermisos().clearSelection();

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

}
