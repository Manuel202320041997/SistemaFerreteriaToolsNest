package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import Controller.ClienteController;
import Controller.ProductoController;
import Model.Cliente;
import Model.Producto;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.util.List;

public class ifrm_ListaInventario extends JInternalFrame {

	private ProductoController productocontroller;
	DefaultTableModel modelo;
	private static final long serialVersionUID = 1L;
	private JTable tblInventario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_ListaInventario frame = new ifrm_ListaInventario();
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
	public ifrm_ListaInventario() {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		productocontroller = new ProductoController();

		
		tblInventario = new JTable();
		tblInventario.setBounds(26, 530, 1218, 0);
		getContentPane().add(tblInventario);
		
		JLabel lblNewLabel = new JLabel("Inventario");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(567, 10, 166, 28);
		getContentPane().add(lblNewLabel);
		
		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "ID", "Descripcion", "Id_marca", "Precio Compra", "Precio Venta", "Stock","Id SubCat"
	            }
	        );

		tblInventario = new JTable(modelo);
		tblInventario.getColumnModel().getColumn(0).setPreferredWidth(10); // ID
		tblInventario.getColumnModel().getColumn(1).setPreferredWidth(180); // Descripcion
		tblInventario.getColumnModel().getColumn(2).setPreferredWidth(20); // Id Marca
		tblInventario.getColumnModel().getColumn(3).setPreferredWidth(20); // P. Compra
		tblInventario.getColumnModel().getColumn(4).setPreferredWidth(20); // P. Venta
		tblInventario.getColumnModel().getColumn(5).setPreferredWidth(20); // Stock
		tblInventario.getColumnModel().getColumn(6).setPreferredWidth(20); // Id SubCat
		
		
		 mostrarTabla();
		 JScrollPane scrollPane = new JScrollPane(tblInventario);
		 scrollPane.setBounds(26, 66, 1218, 466);
		 getContentPane().add(scrollPane);
		 
		 tblInventario = new JTable();
		 scrollPane.setColumnHeaderView(tblInventario);
		

	}
	
	private void mostrarTabla() {
	    modelo.setRowCount(0); // Limpiar la tabla antes de agregar datos
	    List<Producto> listarProducto = productocontroller.listarProducto();
	    
	    for (Producto producto : listarProducto) {
	        Object[] fila = {
	        		
	        		producto.getId(),
	        		producto.getDescripcion(),
	        		producto.getId_marca(),
	        		producto.getPrecio_compra(),
	        		producto.getPrecio_venta(),
	        		producto.getStock(),
	        		producto.getId_subcategoria()	  
	        		
	        };
	        modelo.addRow(fila);
	    }
	}

}

