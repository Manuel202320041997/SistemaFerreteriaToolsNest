package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import Model.Venta;
import Model.DetalleVenta;
import Controller.ProductoController;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class ifrm_DetalleVenta extends JInternalFrame {
	
	
	private static final long serialVersionUID = 1L;
	DefaultTableModel modelo;
	private JTable tblDetalleVenta;
	ArrayList<DetalleVenta> listarProducto = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_DetalleVenta frame = new ifrm_DetalleVenta();
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
	public ifrm_DetalleVenta() {
        setBounds(0, 0, 976, 537);

		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
	
		
	
		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "Id", "Nombre","Cantidad","P. Venta","Sub Total","Descuento","IGV","Total a Pagar","Accion"
	            }
	        );
	
		tblDetalleVenta = new JTable(modelo);
		tblDetalleVenta.getColumnModel().getColumn(0).setPreferredWidth(20); // ID
		tblDetalleVenta.getColumnModel().getColumn(1).setPreferredWidth(100); // DNI
		//mostrarTabla();
		 JScrollPane scrollPane = new JScrollPane(tblDetalleVenta);
		 scrollPane.setBounds(83, 113, 804, 385);
		 getContentPane().add(scrollPane);
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setLayout(null);
		 panel_1.setForeground(Color.WHITE);
		 panel_1.setBackground(new Color(40, 39, 61));
		 panel_1.setBounds(0, 0, 973, 82);
		 getContentPane().add(panel_1);
		 
		 JLabel lblNewLabel = new JLabel("Detalle de Venta");
		 lblNewLabel.setBounds(349, 26, 262, 35);
		 panel_1.add(lblNewLabel);
		 lblNewLabel.setForeground(new Color(255, 255, 255));
		 lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 33));
		 
		 JLabel lblNewLabel_1 = new JLabel("New label");
		 lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\logo.png"));
		 lblNewLabel_1.setBounds(10, 10, 73, 62);
		 panel_1.add(lblNewLabel_1);
		 
		 JLabel lblNewLabel_2 = new JLabel("New label");
		 lblNewLabel_2.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/tiempo.png")));
		 lblNewLabel_2.setBounds(10, 102, 63, 82);
		 getContentPane().add(lblNewLabel_2);
	}
}
