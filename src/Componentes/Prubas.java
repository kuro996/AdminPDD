package Componentes;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;

public class Prubas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prubas frame = new Prubas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Prubas() {
		
		
		URL url;

		setBounds(100, 100, 450, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		JCheckBoxTree tree = new JCheckBoxTree();
		tree.setSelectChilds(true);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
//				Runtime r = Runtime.getRuntime();
//				Process p = null;
//
//				try {
//					p = r.exec("explorer.exe /select,C:\\Users\\libanez\\Downloads\\dedsec.gif");
//				} catch (Exception e) {
//					System.out.println("Error al ejecutar");
//				}
				
				
					try
					{
						UIManager.setLookAndFeel(new AcrylLookAndFeel());
						repaint();
					} catch (UnsupportedLookAndFeelException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				

			}
		});

		CLabel lblNewLabel = new CLabel();

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(tree, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(22)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE).addComponent(btnNewButton)
						.addGap(166)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addComponent(tree, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addComponent(btnNewButton).addGap(26))
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addComponent(lblNewLabel,
										GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()))));

		Image img = new ImageIcon("C:\\Users\\Leandro Iba\u00F1ez\\Pictures\\Creaciones\\Carpetas\\BAKE.png")
				.getImage();

		ImageIcon img2 = new ImageIcon(
				img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH));
		lblNewLabel.setIcon(img2);
		contentPane.setLayout(gl_contentPane);
		
//		try {
//			Image img = new ImageIcon("Copy.gif").getImage();
//	
//			ImageIcon img2 = new ImageIcon(
//					img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
//			//Icon icon = new ImageIcon("Copy.gif");
//			JLabel label = new JLabel(img2);
//			this.getContentPane().add(label);
//			this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
//			this.pack();
//			this.setLocationRelativeTo(null);
//			this.setVisible(true);
//			
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
	}

}
