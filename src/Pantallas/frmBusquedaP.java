package Pantallas;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class frmBusquedaP extends JDialog
{
	private JTextField textDireccion;
	private JTable tableArchivos;
	private JButton btnMostrarEnCarpeta;
	private JPanel panelDireccion;
	private JButton btnExaminar;
	
	public frmBusquedaP() {
		setTitle("Predicas");
		setMinimumSize(new Dimension(550, 400));
		setModal(true);
		
		setBounds(100, 100, 550, 400);
		
		
		panelDireccion = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelDireccion, GroupLayout.PREFERRED_SIZE, 532, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
							.addGap(2)))
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panelDireccion, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
		);
		
		btnMostrarEnCarpeta = new JButton("Mostrar En Carpeta");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(btnMostrarEnCarpeta))
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(11)
					.addComponent(btnMostrarEnCarpeta)
					.addGap(6)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
		);
		
		tableArchivos = new JTable();
		tableArchivos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo", "Predicador", "Fecha", "Hora", "Grabada"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tableArchivos);
		panel_1.setLayout(gl_panel_1);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setEditable(false);
		
		btnExaminar = new JButton("Examinar");
		
		JSeparator separator = new JSeparator();
		GroupLayout gl_panelDireccion = new GroupLayout(panelDireccion);
		gl_panelDireccion.setHorizontalGroup(
			gl_panelDireccion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDireccion.createSequentialGroup()
					.addGroup(gl_panelDireccion.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDireccion.createSequentialGroup()
							.addContainerGap()
							.addComponent(textDireccion, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnExaminar, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
							.addGap(20))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
					.addGap(0))
		);
		gl_panelDireccion.setVerticalGroup(
			gl_panelDireccion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDireccion.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelDireccion.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExaminar))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
		);
		panelDireccion.setLayout(gl_panelDireccion);
		getContentPane().setLayout(groupLayout);
	}

	public JTextField getTextDireccion()
	{
		return textDireccion;
	}

	public void setTextDireccion(JTextField textDireccion)
	{
		this.textDireccion = textDireccion;
	}

	public JTable getTableArchivos()
	{
		return tableArchivos;
	}

	public void setTableArchivos(JTable tableArchivos)
	{
		this.tableArchivos = tableArchivos;
	}

	public JButton getBtnMostrarEnCarpeta()
	{
		return btnMostrarEnCarpeta;
	}

	public void setBtnMostrarEnCarpeta(JButton btnMostrarEnCarpeta)
	{
		this.btnMostrarEnCarpeta = btnMostrarEnCarpeta;
	}

	public JPanel getPanelDireccion()
	{
		return panelDireccion;
	}

	public void setPanelDireccion(JPanel panelDireccion)
	{
		this.panelDireccion = panelDireccion;
	}

	public JButton getBtnExaminar()
	{
		return btnExaminar;
	}

	public void setBtnExaminar(JButton btnExaminar)
	{
		this.btnExaminar = btnExaminar;
	}
	
	
}
