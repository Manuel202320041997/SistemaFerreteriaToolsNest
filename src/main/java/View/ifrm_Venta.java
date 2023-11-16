package View;

import java.awt.Color;

import java.awt.EventQueue;
import View.frm_Inicio;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import Controller.ClienteController;
import Controller.DetalleVentaController;
import Controller.VentaController;
import Model.Cliente;
import Model.DetalleVenta;
import Model.Producto;
import Model.Venta;
import Controller.ProductoController;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class ifrm_Venta extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	DefaultTableModel modelo;
	private VentaController facturaController;
	private ProductoController productoController;
	private ClienteController clienteController;
	private VentaController ventaController;
	private DetalleVentaController detalleVentaController;
	private JTextField txtBuscar;
	private JTextField txtSubTotal;
	private JComboBox<String> cboCliente; 
	private JComboBox<String> cboProducto;
	private JTextField txtDescuento;
	private JTextField txtIGV;
	private JTextField txtTotal;
	private JTextField txtCambio;
	private JSpinner spinnerCantidad;
	private JSpinner spinnerEfectivo;	
	private JTable tblVenta;
	private JTable table;
	private JTable tbl_Venta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_Venta frame = new ifrm_Venta();
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
	public ifrm_Venta() {
	    setBounds(0, 0, 1244, 560);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		
		
		    ventaController = new VentaController();
	        productoController = new ProductoController();
	        clienteController = new ClienteController();
	        detalleVentaController = new DetalleVentaController();

	       // actualizarComboBoxClientes();
	       // actualizarComboBoxProductos();

	        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(511, 32, 711, 476);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(62, 160, 73, 13);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Producto:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(62, 216, 92, 13);
		panel.add(lblNewLabel_3);
		
		cboCliente = new JComboBox<String>();
		cboCliente.setBackground(new Color(255, 255, 255));
		cboCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DatosDelProducto();
				//registrarProducto();
				//CargarComboProducto();
			}
		});
		cboCliente.setBounds(157, 152, 186, 31);
		cboCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		cboCliente.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Cliente"}));
		actualizarComboBoxClientes();
		panel.add(cboCliente);
		
		
		cboProducto = new JComboBox<String>();
		cboProducto.setBackground(new Color(255, 255, 255));
		cboProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CargarComboProducto();
			}
		});
		cboProducto.setBounds(157, 208, 186, 31);
		cboProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		cboProducto.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Producto"}));
		actualizarComboBoxProductos();
		panel.add(cboProducto);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(62, 272, 78, 13);
		panel.add(lblNewLabel_4);
		
		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setBounds(166, 272, 124, 20);
		panel.add(spinnerCantidad);
		
		JButton btnAgregar = new JButton("Registrar");
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAgregar.setBackground(new Color(51, 52, 78));
		btnAgregar.setBounds(91, 318, 228, 41);
		btnAgregar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/agregar.png")));
		panel.add(btnAgregar);
		
		JLabel lblNewLabel_5 = new JLabel("Cliente ID:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(62, 101, 85, 13);
		panel.add(lblNewLabel_5);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(157, 95, 81, 29);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBackground(new Color(51, 52, 78));
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/buscar.png")));
		btnBuscar.setBounds(248, 95, 47, 32);
		panel.add(btnBuscar);
		
		JLabel lblNewLabel_6 = new JLabel("SubTotal:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(451, 101, 70, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Descuento:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(439, 137, 82, 13);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("iGV:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(476, 186, 45, 13);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Total:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(465, 236, 45, 13);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Efectivo:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(451, 285, 70, 13);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Cambio:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(451, 332, 70, 13);
		panel.add(lblNewLabel_11);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setEditable(false);
		txtSubTotal.setBounds(531, 100, 96, 19);
		panel.add(txtSubTotal);
		txtSubTotal.setColumns(10);
		
		txtDescuento = new JTextField();
		txtDescuento.setEditable(false);
		txtDescuento.setBounds(531, 136, 96, 19);
		panel.add(txtDescuento);
		txtDescuento.setColumns(10);
		
		txtIGV = new JTextField();
		txtIGV.setEditable(false);
		txtIGV.setBounds(530, 185, 96, 19);
		panel.add(txtIGV);
		txtIGV.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(531, 235, 96, 19);
		panel.add(txtTotal);
		txtTotal.setColumns(10);
		
		txtCambio = new JTextField();
		txtCambio.setEditable(false);
		txtCambio.setBounds(531, 331, 96, 19);
		panel.add(txtCambio);
		txtCambio.setColumns(10);
		
		JLabel Calcular = new JLabel("");
		Calcular.setBorder(new LineBorder(new Color(0, 0, 0)));
		Calcular.setBounds(432, 80, 217, 354);
		panel.add(Calcular);
		
		JSpinner spinnerEfectivo = new JSpinner();
		spinnerEfectivo.setBounds(531, 284, 96, 20);
		panel.add(spinnerEfectivo);
		
		JButton btnNuevaVenta = new JButton("Venta");
		btnNuevaVenta.setForeground(new Color(255, 255, 255));
		btnNuevaVenta.setBackground(new Color(51, 52, 78));
		btnNuevaVenta.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNuevaVenta.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/venta-factura.png")));
		btnNuevaVenta.setBounds(20, 415, 115, 51);
		panel.add(btnNuevaVenta);
		
		JButton btnCambio = new JButton("Cambio");
		btnCambio.setForeground(new Color(255, 255, 255));
		btnCambio.setBackground(new Color(51, 52, 78));
		btnCambio.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCambio.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/intercambiar.png")));
		btnCambio.setBounds(145, 415, 124, 51);
		panel.add(btnCambio);
		
		JButton btnRegistrarVenta = new JButton("Vender");
		btnRegistrarVenta.setForeground(new Color(255, 255, 255));
		btnRegistrarVenta.setBackground(new Color(51, 52, 78));
		btnRegistrarVenta.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegistrarVenta.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/vender.png")));
		btnRegistrarVenta.setBounds(279, 415, 126, 51);
		panel.add(btnRegistrarVenta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(40, 39, 61));
		panel_1.setBounds(0, 0, 711, 70);
		//getContentPane().setBackground(new Color(51, 52, 78));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(21, 0, 64, 64);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\logo.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Facturas");
		lblNewLabel_1.setBounds(315, 10, 138, 33);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		/*
		JComboBox cboCliente = new JComboBox();
		cboCliente.setBounds(166, 159, 124, 21);
		panel.add(cboCliente);
		
		JComboBox cboProducto = new JComboBox();
		cboProducto.setBounds(164, 215, 126, 21);
		panel.add(cboProducto);
		*/
		
		JLabel lblNewLabel_6_1_1 = new JLabel("");
		lblNewLabel_6_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1_1.setBounds(31, 80, 324, 296);
		panel.add(lblNewLabel_6_1_1);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCalcular.setForeground(new Color(255, 255, 255));
		btnCalcular.setBounds(476, 387, 142, 29);
		btnCalcular.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/calculadora.png")));
		btnCalcular.setBackground(new Color(51, 52, 78));
		panel.add(btnCalcular);
	
		
		/*
		JLabel lblNewLabel = new JLabel("New label");
		scrollPane.setColumnHeaderView(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iconos\\herramientas-de-ferreteria-icono2.png"));
		*/
		 
			modelo = new DefaultTableModel(
		            new Object[][] {},
		            new String[] {
		                "Nombre", "Cantidad", "P. Venta"
		            }
		        );

			tbl_Venta = new JTable(modelo);
			tbl_Venta.getColumnModel().getColumn(0).setPreferredWidth(50); // ID
			tbl_Venta.getColumnModel().getColumn(1).setPreferredWidth(30); // DNI
			tbl_Venta.getColumnModel().getColumn(2).setPreferredWidth(20); // Nombre

			 //mostrarTabla();
			 JScrollPane scrollPane = new JScrollPane(tbl_Venta);
			 scrollPane.setBounds(22, 32, 449, 476);
			 getContentPane().add(scrollPane);
			/* 
			 tblCliente_1 = new JTable();
			 scrollPane.setColumnHeaderView(tblCliente_1);
			 */
			 tbl_Venta = new JTable();
			 tbl_Venta.setBounds(0, 0, 1, 1);
			 getContentPane().add(tbl_Venta);
		 
		
			 btnAgregar.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        Object spinnerValue = spinnerCantidad.getValue();

				        if (spinnerValue instanceof Integer) {
				            int cantidad = (int) spinnerValue;
				            if (cantidad > 0) {
				                String nombreProducto = (String) cboProducto.getSelectedItem();
				                Producto productoInfo = productoController.obtenerStockyPrecioPorNombre(nombreProducto);

				                if (productoInfo != null) {
				                    int stockProducto = productoInfo.getStock();
				                    double precioProducto = productoInfo.getPrecio_venta();

				                    if (stockProducto >= cantidad) {
				                        Object[] fila = {nombreProducto, cantidad, precioProducto};
				                        modelo.addRow(fila);
				                    } else {
				                        JOptionPane.showMessageDialog(ifrm_Venta.this, "No contamos con el suficiente Stock para la Cantidad ingresada.", "Error", JOptionPane.ERROR_MESSAGE);
				                    }
				                } else {
				                    JOptionPane.showMessageDialog(ifrm_Venta.this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
				                }
				            } else {
				                JOptionPane.showMessageDialog(ifrm_Venta.this, "La cantidad debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
				            }
				        } else {
				            JOptionPane.showMessageDialog(ifrm_Venta.this, "Por favor, ingrese una cantidad válida en el Spinner.", "Error", JOptionPane.ERROR_MESSAGE);
				        }
				    }
				});
		 
		 btnBuscar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        try {
			            int idCliente = Integer.parseInt(txtBuscar.getText());
			            Cliente clienteEncontrado = clienteController.buscarClientePorId(idCliente);

			            if (clienteEncontrado != null) {
			                // Limpia el ComboBox y agrega el nombre del cliente encontrado
			                cboCliente.removeAllItems();
			                cboCliente.addItem(clienteEncontrado.getNombre());
			            } else {
			                JOptionPane.showMessageDialog(ifrm_Venta.this, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			            }

			        } catch (Exception e2) {
			            e2.printStackTrace();
			        }
			    }
			});
		 
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String clienteSeleccionado = (String) cboCliente.getSelectedItem();
					
					List<DetalleVenta> detalleProductos = new ArrayList<>();
					
					for (int i = 0; i < modelo.getRowCount(); i++) {
					    String nombreProducto = (String) modelo.getValueAt(i, 0);
					    int idProducto = productoController.obtenerIdProductoPorNombre(nombreProducto);
					    int cantidad = (int) modelo.getValueAt(i, 1);
					    double Pre = (double) modelo.getValueAt(i, 2);					    

					    DetalleVenta detalle = new DetalleVenta(idProducto, cantidad, Pre);
					    detalleProductos.add(detalle);
					}			

			        // Realizar el cálculo y obtener los resultados
					 Map<String, Double> resultados = detalleVentaController.calcularVenta(clienteSeleccionado, detalleProductos);

			        // Mostrar los resultados en los campos de texto
			        txtSubTotal.setText(String.valueOf(resultados.get("subTotal")));
			        txtDescuento.setText(String.valueOf(resultados.get("descuento")));
			        txtIGV.setText(String.valueOf(resultados.get("igv")));
			        txtTotal.setText(String.valueOf(resultados.get("totalPagar")));
					
				}
			});
			
			btnCambio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Object spinnerValue = spinnerEfectivo.getValue();
					double total = Double.parseDouble(txtTotal.getText());
			        if (spinnerValue instanceof Double) {
			        	
			            double efectivo = (double) spinnerValue;
			            
			            if (efectivo > 0) {  // Validar que la cantidad sea mayor que cero
			            	
			            	if(efectivo >= total) {
			            		
			            		double cambio = efectivo - total;				            	
				            	txtCambio.setText(String.valueOf(cambio));
			            	}
			            	else {
			            		JOptionPane.showMessageDialog(ifrm_Venta.this, "El efectivo ingresado es menor al total a Pagar", "Error", JOptionPane.ERROR_MESSAGE);
			            	}			            	
			            }
			            else {
			            	JOptionPane.showMessageDialog(ifrm_Venta.this, "Ingresa efectivo del Cliente", "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        }
				}
			});
			
			btnRegistrarVenta.addActionListener(new ActionListener() {
				private List<DetalleVenta> detallesVenta = new ArrayList<>();
				public void actionPerformed(ActionEvent e) {
					
					String nombreCliente = (String) cboCliente.getSelectedItem();
			        int idCliente = clienteController.obtenerIdClientePorNombre(nombreCliente);
			        double totalVenta = Double.parseDouble(txtTotal.getText());

			        if (totalVenta <= 0) {
			            JOptionPane.showMessageDialog(ifrm_Venta.this, "No hay productos en la factura para vender.", "Error", JOptionPane.ERROR_MESSAGE);
			            return;
			        }

			        String numeroVenta = ventaController.generarNumeroFactura();
			        int idVenta = ventaController.registrarVenta(numeroVenta, idCliente, totalVenta);

			        for (DetalleVenta detalle : detallesVenta) {
			            ventaController.registrarDetalleVenta(idVenta, detalle.getId_producto(), detalle.getCantidad(), detalle.getPrecio_venta());
			        }

			        JOptionPane.showMessageDialog(ifrm_Venta.this, "Venta registrada con éxito. Número de factura: " + numeroVenta, "Éxito", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			
			btnNuevaVenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiar();
				}
			});
	}
	
	public void actualizarComboBoxProductos() {
        // Llama al controlador para obtener la lista de productos
        List<Producto> listaProductos = productoController.listarProducto();

        // Limpia el ComboBox
        cboProducto.removeAllItems();

        // Agrega los nombres de los productos al ComboBox
        for (Producto producto : listaProductos) {
           cboProducto.addItem(producto.getDescripcion());
        }
    }

	public void actualizarComboBoxClientes() {
        List<Cliente> listarCliente = clienteController.listarCliente();

        cboCliente.removeAllItems();

        for (Cliente cliente : listarCliente) {
            cboCliente.addItem(cliente.getNombre());
        }
    }

	    private void limpiar() {
	        // Restablece los ComboBox
	        cboCliente.setSelectedIndex(0);
	        cboProducto.setSelectedIndex(0);

	        // Limpia los JTextField
	        txtSubTotal.setText("");
	        txtDescuento.setText("");
	        txtIGV.setText("");
	        txtTotal.setText("");
	        txtCambio.setText("");
	        txtBuscar.setText("");

	        // Limpia el JSpinner
	        spinnerCantidad.setValue(0);
	        spinnerEfectivo.setValue(0.0);

	        // Limpia el modelo de la tabla
	        DefaultTableModel modelo = (DefaultTableModel) tblVenta.getModel();
	        modelo.setRowCount(0); // Elimina todas las filas de la tabla
	    }
	}