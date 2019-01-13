package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import DTO.Equipo;
import DTO.Usuario;
import Main.AdminPDD;
import Pantallas.frmPermisos;

public class PermisoController implements ActionListener, MouseListener, ChangeListener
{

	private static final String name = "Principal.Seguridad.Permisos";
	private frmPermisos ventana;
	private AdminPDD modelo;

	public PermisoController(frmPermisos ventana, AdminPDD modelo)
	{
		this.ventana = ventana;
		this.modelo = modelo;
		this.ventana.getArbPermisos().addMouseListener(this);
		this.ventana.getBtnEditar().addActionListener(this);
		this.ventana.getRdbtnUsuarios().addActionListener(this);
		this.ventana.getRdbtnEquipos().addActionListener(this);
		this.verificarPermisos();
	}

	public void inicializar()
	{
		llenarArbol();
		llenarTablas();
		this.ventana.setVisible(true);
	}

	private void llenarTablas()
	{
		DefaultTableModel tabla = new DefaultTableModel();
		if (this.ventana.getRdbtnUsuarios().isSelected())
		{
			tabla = new DefaultTableModel(null, new String[] { "Id", "Nombre", "Apellido", "Login" })
			{
				boolean[] columnEditables = new boolean[] { false };

				public boolean isCellEditable(int row, int column)
				{
					return false;
				}
			};

			for (Usuario u : this.modelo.getUsuarios())
			{
				tabla.addRow(new String[] { String.valueOf(u.getId()), u.getNombre(), u.getApellido(), u.getLogin() });
			}
		}else {
			tabla = new DefaultTableModel(null, new String[] { "Id", "Nombre", "Codigo"})
			{
				boolean[] columnEditables = new boolean[] { false };

				public boolean isCellEditable(int row, int column)
				{
					return false;
				}
			};

			for (Equipo e : this.modelo.getEquipos())
			{
				tabla.addRow(new String[] { String.valueOf(e.getId()), e.getNombre(), e.getCodigo()});
			}
		}
		this.ventana.getTblAsig().setModel(tabla);

	}

	private void llenarArbol()
	{
		DefaultMutableTreeNode asd = new DefaultMutableTreeNode("yo");

		for (int i = 0; i < 11; i++)
		{
			asd.add(new DefaultMutableTreeNode(String.valueOf(i)));
		}

		DefaultTreeModel as = new DefaultTreeModel(asd);
		this.ventana.getArbPermisos().setModel(as);

	}

	private void verificarPermisos()
	{
		ArrayList<String> per = this.modelo.Permisos(this.name);
		this.ventana.getBtnEditar().setVisible(per.contains((String) "Permisos.editar"));

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.ventana.getBtnEditar())
		{
			if (this.ventana.getBtnEditar().getText().equals("Editar"))
			{
				this.ventana.getBtnEditar().setText("Aceptar");
				this.ventana.getArbPermisos().setEnabled(true);

			} else
			{
				this.ventana.getBtnEditar().setText("Editar");
				this.ventana.getArbPermisos().setEnabled(false);
				this.ventana.getArbPermisos().setEditable(false);

			}
		}else if(e.getSource()==this.ventana.getRdbtnUsuarios() || e.getSource()==this.ventana.getRdbtnEquipos()) {
			llenarTablas();
		}
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

	@Override
	public void stateChanged(ChangeEvent e)
	{
		 
	}

}
