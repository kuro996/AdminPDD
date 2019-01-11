package Pantallas;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import Componentes.JCheckBoxTree;

public class frmPermisos extends JDialog{
	private JTable tblAsig;
	private JButton btnEditar;
	private JButton btnCancelar;
	private JCheckBoxTree arbPermisos;
	private JRadioButton rdbtnUsuarios;
	private JRadioButton rdbtnEquipos;
	private JScrollPane scrollPane_1;
	
	
	public frmPermisos() {
		setMinimumSize(new Dimension(400, 500));
		setTitle("Permisos por Usuario");
		setModal(true);
		
		setBounds(100, 100, 410, 550);
		
		btnEditar = new JButton("Editar");
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setVisible(false);
		
		JPanel panelArbol = new JPanel();
		
		JPanel panelTbl = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(btnEditar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(238))
				.addComponent(panelArbol, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
				.addComponent(panelTbl, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelArbol, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelTbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		tblAsig = new JTable();
		scrollPane.setViewportView(tblAsig);
		
		
		rdbtnUsuarios = new JRadioButton("Usuarios");
		rdbtnUsuarios.setSelected(true);
		
		rdbtnEquipos = new JRadioButton("Equipos");
		GroupLayout gl_panelTbl = new GroupLayout(panelTbl);
		gl_panelTbl.setHorizontalGroup(
			gl_panelTbl.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
				.addGroup(gl_panelTbl.createSequentialGroup()
					.addGap(49)
					.addComponent(rdbtnUsuarios, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
					.addGap(112)
					.addComponent(rdbtnEquipos, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
					.addGap(89))
		);
		gl_panelTbl.setVerticalGroup(
			gl_panelTbl.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelTbl.createSequentialGroup()
					.addGroup(gl_panelTbl.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnUsuarios, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(rdbtnEquipos, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(5)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
		);
		panelTbl.setLayout(gl_panelTbl);
		GridBagLayout gbl_panelArbol = new GridBagLayout();
		gbl_panelArbol.columnWidths = new int[]{0, 0};
		gbl_panelArbol.rowHeights = new int[]{0, 0};
		gbl_panelArbol.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelArbol.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelArbol.setLayout(gbl_panelArbol);
		
		ButtonGroup bottonGroup=new ButtonGroup();
		bottonGroup.add(rdbtnUsuarios);
		bottonGroup.add(rdbtnEquipos);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panelArbol.add(scrollPane_1, gbc_scrollPane_1);
		
		arbPermisos = new JCheckBoxTree();
		scrollPane_1.setViewportView(arbPermisos);
		arbPermisos.setEnabled(false);
		getContentPane().setLayout(groupLayout);
		
	}


	public JTable getTblAsig()
	{
		return tblAsig;
	}


	public void setTblAsig(JTable tblAsig)
	{
		this.tblAsig = tblAsig;
	}


	public JButton getBtnEditar()
	{
		return btnEditar;
	}


	public void setBtnEditar(JButton btnEditar)
	{
		this.btnEditar = btnEditar;
	}


	public JButton getBtnCancelar()
	{
		return btnCancelar;
	}


	public void setBtnCancelar(JButton btnCancelar)
	{
		this.btnCancelar = btnCancelar;
	}


	public JCheckBoxTree getArbPermisos()
	{
		return arbPermisos;
	}


	public void setArbPermisos(JCheckBoxTree arbPermisos)
	{
		this.arbPermisos = arbPermisos;
	}


	public JRadioButton getRdbtnUsuarios()
	{
		return rdbtnUsuarios;
	}


	public void setRdbtnUsuarios(JRadioButton rdbtnUsuarios)
	{
		this.rdbtnUsuarios = rdbtnUsuarios;
	}


	public JRadioButton getRdbtnEquipos()
	{
		return rdbtnEquipos;
	}


	public void setRdbtnEquipos(JRadioButton rdbtnEquipos)
	{
		this.rdbtnEquipos = rdbtnEquipos;
	}
}
