package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import Model.VentaConCliente;
import Model.Cliente;
import Model.DetalleVenta;
import Model.Venta;
import Model.VentaConCliente;
import Controller.DetalleVentaController;
import Controller.VentaConClienteController;
import Controller.VentaController;
import Controller.ProductoController;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class ifrm_DetalleVenta extends JInternalFrame {
	
	
	private static final long serialVersionUID = 1L;
	DefaultTableModel modelo;
	DefaultTableModel modelo2;
	private JTable tblDetalleVenta;
	private JTable tblDetalle;
	private JTable tblFactura;
	ArrayList<DetalleVenta> listarProducto = new ArrayList<>();
	private DetalleVentaController detalleVentaController;
	private VentaController ventaController;
	private ProductoController productoController;
	private VentaConClienteController ventaConClienteController; 
	private JDialog dialog;
	private JTable table;
	
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
	
		detalleVentaController = new DetalleVentaController();
		ventaController = new VentaController();
		ventaConClienteController = new VentaConClienteController();
		productoController = new ProductoController();
		
		
		
	
		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	               "Fecha", "N° Factura", "Cliente","ID Cliente","Telefono","N° DNI","Total"
	            }
	        );
	
		tblFactura = new JTable(modelo);
		tblFactura.setDefaultEditor(Object.class, null);
		tblFactura.getColumnModel().getColumn(0).setPreferredWidth(20); // fecha
		tblFactura.getColumnModel().getColumn(1).setPreferredWidth(30); // n° factura
		tblFactura.getColumnModel().getColumn(1).setPreferredWidth(50); // Cliente
		tblFactura.getColumnModel().getColumn(1).setPreferredWidth(20); // id cliente
		tblFactura.getColumnModel().getColumn(1).setPreferredWidth(30); // telefono
		tblFactura.getColumnModel().getColumn(1).setPreferredWidth(30); // dni
		tblFactura.getColumnModel().getColumn(1).setPreferredWidth(20);
		 
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
		 
		
			modelo = new DefaultTableModel(
		            new Object[][] {},
		            new String[] {
		               "Fecha", "N° Factura", "Cliente","ID Cliente","Telefono","N° DNI","Total"
		            }
		        );
		
			tblFactura = new JTable(modelo);
			tblFactura.setDefaultEditor(Object.class, null);
			tblFactura.getColumnModel().getColumn(0).setPreferredWidth(20); // fecha
			tblFactura.getColumnModel().getColumn(1).setPreferredWidth(30); // n° factura
			tblFactura.getColumnModel().getColumn(1).setPreferredWidth(50); // Cliente
			tblFactura.getColumnModel().getColumn(1).setPreferredWidth(20); // id cliente
			tblFactura.getColumnModel().getColumn(1).setPreferredWidth(30); // telefono
			tblFactura.getColumnModel().getColumn(1).setPreferredWidth(30); // dni
			tblFactura.getColumnModel().getColumn(1).setPreferredWidth(20); // total
			
			mostrarTabla();
			 JScrollPane scrollPane = new JScrollPane(tblFactura);
			 scrollPane.setBounds(83, 102, 841, 396);
			 getContentPane().add(scrollPane);
			 
			 tblFactura.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        if (e.getClickCount() == 2) {
				            int filaSeleccionada = tblFactura.getSelectedRow();
				            if (filaSeleccionada != -1) {
				                // Obtener la factura seleccionada
				                //Factura factura = obtenerFacturaDesdeLaFila(filaSeleccionada);
				            	Object columFactura = tblFactura.getValueAt(filaSeleccionada, 1);
				            	String numeroFactura = columFactura.toString();

				                // Aquí debes abrir una nueva vista con el detalle de la factura
				                // Puedes usar un JDialog, un JInternalFrame o cualquier otro contenedor
				                mostrarDetalleFactura(numeroFactura);
				            }
				        }
				    }
				});
		}
		
		private void mostrarTabla() {
		    modelo.setRowCount(0); // Limpiar la tabla antes de agregar datos	   
		    List<VentaConCliente> ventasConCliente = ventaConClienteController.listarVentasConCliente();
		    
		    for (VentaConCliente ventaConCliente : ventasConCliente) {
		        Venta venta = ventaConCliente.getVenta();
		        Cliente cliente = ventaConCliente.getCliente();

		        Object[] fila2 = {
		        	venta.getFechaVenta(),
		            venta.getNumero_venta(),
		            cliente.getNombre(),
		            cliente.getId(),
		            cliente.getTelefono(),
		            cliente.getDni(),
		            venta.getTotal()
		        };

		        modelo.addRow(fila2);
		    }
		}
		
		public void mostrarDetalleFactura(String numeroFactura) {
		    dialog = new JDialog();
		    dialog.setTitle("Detalle de la Factura " + numeroFactura);
		    dialog.setSize(600, 480);

		    dialog.setLocationRelativeTo(null);
		    
		    JPanel contentPanel = new JPanel();
		    contentPanel.setBackground(new Color(67, 16, 58));
		    dialog.getContentPane().add(contentPanel);
		    
		    modelo2 = new DefaultTableModel(
		            new Object[][] {},
		            new String[] {
		               "Producto","Cantidad","Precio Unitario"
		            }
		        );
		
			tblDetalle = new JTable(modelo2);
			tblDetalle.setDefaultEditor(Object.class, null);		
			tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(100); // Producto
			tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(20); // Cantidad
			tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(20); // precio		
			
			mostrarTablaDetalle(numeroFactura);
			JScrollPane scrollPane = new JScrollPane(tblDetalle);
			scrollPane.setBounds(37, 85, 500, 290);
			contentPanel.add(scrollPane);
		
		    dialog.setVisible(true);
		}
		
		public void mostrarTablaDetalle(String numeroFactura) {
		    modelo2.setRowCount(0);

		    List<DetalleVenta> listarDetalle = detalleVentaController.listarDetalleVentaPorNumeroFactura(numeroFactura);

		    for (DetalleVenta detalleVenta : listarDetalle) {
		        String nombreProducto = productoController.obtenerNombreProductoPorId(detalleVenta.getId_producto()); // Corregido aquí
		        Object[] fila = {
		                nombreProducto,
		                detalleVenta.getCantidad(),
		                detalleVenta.getPrecio_venta(),
		        };
		        modelo2.addRow(fila);
		    }
		}
}

