package Controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import DTO.Equipo;
import DTO.Funcion;
import DTO.Usuario;
import Main.AdminPDD;
import Pantallas.frmPermisos;

public class PermisoController implements ActionListener, MouseListener, ChangeListener
{

	private static final String name = "Principal.Seguridad.Permisos";
	private frmPermisos ventana;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Equipo> equipos;
	private AdminPDD modelo;

	public PermisoController(frmPermisos ventana, AdminPDD modelo)
	{
		this.ventana = ventana;
		this.modelo = modelo;
		this.ventana.getArbPermisos().addMouseListener(this);
		this.ventana.getBtnEditar().addActionListener(this);
		this.ventana.getBtnCancelar().addActionListener(this);
		this.ventana.getRdbtnUsuarios().addActionListener(this);
		this.ventana.getRdbtnEquipos().addActionListener(this);
		this.ventana.getTblAsig().addMouseListener(this);
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

			this.usuarios = this.modelo.getUsuarios();
			for (Usuario u : usuarios)
			{
				tabla.addRow(new String[] { String.valueOf(u.getId()), u.getNombre(), u.getApellido(), u.getLogin() });
			}
		} else
		{
			tabla = new DefaultTableModel(null, new String[] { "Id", "Nombre", "Codigo" })
			{
				boolean[] columnEditables = new boolean[] { false };

				public boolean isCellEditable(int row, int column)
				{
					return false;
				}
			};

			this.equipos = this.modelo.getEquipos();
			for (Equipo e : equipos)
			{
				tabla.addRow(new String[] { String.valueOf(e.getId()), e.getNombre(), e.getCodigo() });
			}
		}
		this.ventana.getTblAsig().setModel(tabla);

	}

	private void llenarArbol()
	{
		DefaultMutableTreeNode asd = new DefaultMutableTreeNode(new Funcion(1, "Principal", "Principal"));
		asd = llenarNodo(asd, new Funcion(1, "Principal", "Principal"));
		DefaultTreeModel as = new DefaultTreeModel(asd);
		this.ventana.getArbPermisos().setModel(as);
		for (int i = 0; i < this.ventana.getArbPermisos().getRowCount(); i++)
		{
			this.ventana.getArbPermisos().expandRow(i);
		}

	}

	private DefaultMutableTreeNode llenarNodo(DefaultMutableTreeNode nodo, Funcion f)
	{
		ArrayList<Funcion> fun = modelo.obtenerHijos(f.getCodigo());
		if (fun.size() > 0)
		{
			for (Funcion i : fun)
			{
				DefaultMutableTreeNode newnode = new DefaultMutableTreeNode(i);
				nodo.add(llenarNodo(newnode, i));
			}
		}
		return nodo;

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
			if (this.ventana.getTblAsig().getSelectedRow() < 0)
			{
				JOptionPane.showMessageDialog(this.ventana, "Debe seleccionar una fila", "alerta", 1);
			} else if (this.ventana.getBtnEditar().getText().equals("Editar"))
			{
				this.ventana.getBtnEditar().setText("Aceptar");
				this.ventana.getBtnCancelar().setVisible(true);
				this.ventana.getArbPermisos().setSelectChilds(true);
				this.ventana.getTblAsig().setEnabled(false);
				this.ventana.getRdbtnEquipos().setEnabled(false);
				this.ventana.getRdbtnUsuarios().setEnabled(false);
				this.ventana.getArbPermisos().setEnabled(true);

			} else
			{
				String ids = "";
				for(TreePath i : this.ventana.getArbPermisos().getCheckedPaths()) {
					DefaultMutableTreeNode nod = this.ventana.getArbPermisos().getNode(i.getLastPathComponent().toString(), (DefaultMutableTreeNode)this.ventana.getArbPermisos().getModel().getRoot());
					Funcion fun=(Funcion)nod.getUserObject();
					ids=fun.getFun()+","+ids;
					
				}
				int row = this.ventana.getTblAsig().getSelectedRow();
				this.modelo.darPermisos(this.usuarios.get(row).getId(),ids);
				this.ventana.getBtnEditar().setText("Editar");
				this.ventana.getBtnCancelar().setVisible(false);
				this.ventana.getArbPermisos().setSelectChilds(false);
				this.ventana.getArbPermisos().setEnabled(false);
				this.ventana.getTblAsig().setEnabled(true);
				this.ventana.getRdbtnEquipos().setEnabled(true);
				this.ventana.getRdbtnUsuarios().setEnabled(true);
				this.ventana.getArbPermisos().setEditable(false);

			}
		}else if(e.getSource()==this.ventana.getBtnCancelar()){
			
			this.ventana.getBtnEditar().setText("Editar");
			this.ventana.getBtnCancelar().setVisible(false);
			this.ventana.getArbPermisos().setSelectChilds(false);
			this.ventana.getArbPermisos().setEnabled(false);
			this.ventana.getTblAsig().setEnabled(true);
			this.ventana.getRdbtnEquipos().setEnabled(true);
			this.ventana.getRdbtnUsuarios().setEnabled(true);
			this.ventana.getArbPermisos().setEditable(false);
			
			this.ventana.getTblAsig().clearSelection();
			this.ventana.getArbPermisos().clearSelections();
			
		}
		else if (e.getSource() == this.ventana.getRdbtnUsuarios() || e.getSource() == this.ventana.getRdbtnEquipos())
		{
			llenarTablas();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (e.getSource() == this.ventana.getTblAsig() && this.ventana.getTblAsig().isEnabled())
		{
			this.ventana.getArbPermisos().clearSelections();
			int row = this.ventana.getTblAsig().getSelectedRow();
			if (row >= 0)
			{
				if (this.ventana.getRdbtnUsuarios().isSelected())
				{
					for (Funcion i : modelo.obtenerPermisos(this.usuarios.get(row).getId(),0))
					{
						this.ventana.getArbPermisos().SelectObject(i.getNombre(),
								(DefaultMutableTreeNode) this.ventana.getArbPermisos().getModel().getRoot(), 0);
					}
				} else
				{
					for (Funcion i : modelo.obtenerPermisos(0,this.equipos.get(row).getId()))
					{
						this.ventana.getArbPermisos().SelectObject(i.getNombre(),
								(DefaultMutableTreeNode) this.ventana.getArbPermisos().getModel().getRoot(), 0);
					}
				}
			}
		}
		else if (e.getSource()==this.ventana.getRdbtnEquipos() || e.getSource()==this.ventana.getRdbtnUsuarios()) {
			this.ventana.getArbPermisos().clearSelections();
			this.ventana.getTblAsig().clearSelection();
		}
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
