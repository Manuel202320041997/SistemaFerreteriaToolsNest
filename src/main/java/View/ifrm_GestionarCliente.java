package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controller.ClienteController;
//import Controller.ReporteController;
import Model.Cliente;
//import Model.Reporte;
//import Model.ReporteExcel;
import DaoImpl.ClienteDaoImpl;
import javax.swing.JTextField;
import javax.swing.JButton;
import Dao.ClienteDao;
import javax.swing.ImageIcon;

public class ifrm_GestionarCliente extends JInternalFrame {

	
	private ClienteController clienteController;
	
	DefaultTableModel modelo;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JTable tblCliente;
	private JTable tblCliente_1;
	private JTextField txtBuscar;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_GestionarCliente frame = new ifrm_GestionarCliente();
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
	public ifrm_GestionarCliente() {
		setBounds(0, 0, 1280, 589);
		getContentPane().setLayout(null);

		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		
		clienteController = new ClienteController();

		
		JPanel panel = new JPanel();
		panel.setBounds(942, 23, 285, 514);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion de Clientes");
		lblNewLabel.setBounds(34, 10, 220, 27);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel.add(lblNewLabel);
		
		
		/*
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(146, 171, 134, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(146, 230, 134, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(146, 283, 132, 20);
		panel.add(textField_3);*/
		
		JLabel lblNewLabel_1 = new JLabel("DNI:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(45, 120, 40, 26);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(34, 173, 65, 26);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Correo:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(42, 232, 57, 26);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Telefono:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_2.setBounds(34, 285, 65, 26);
		panel.add(lblNewLabel_1_1_1_1_2);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iconos\\agregaricono.png"));
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnGuardar.setBackground(new Color(78, 156, 54));
		btnGuardar.setBounds(59, 338, 176, 33);
		panel.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iconos\\limpiaricono.png"));
		btnLimpiar.setForeground(Color.WHITE);
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLimpiar.setBackground(new Color(252, 187, 33));
		btnLimpiar.setBounds(59, 381, 176, 31);
		panel.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iconos\\eliminaricono.png"));
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnEliminar.setBackground(new Color(144, 8, 9));
		btnEliminar.setBounds(59, 422, 176, 33);
		panel.add(btnEliminar);
		
		JButton btnExcel = new JButton("Excel");
		btnExcel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iconos\\excelicono.png"));
		btnExcel.setForeground(new Color(255, 255, 255));
		btnExcel.setBackground(new Color(33, 114, 69));
		btnExcel.setBounds(59, 465, 85, 27);
		panel.add(btnExcel);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(122, 126, 132, 20);
		panel.add(txtDni);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(122, 179, 132, 20);
		panel.add(txtNombre);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(122, 238, 128, 20);
		panel.add(txtCorreo);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(122, 291, 132, 20);
		panel.add(txtTelefono);
		
		JButton btnPdf = new JButton("PDF");
		btnPdf.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\iconos\\pdficono.png"));
		btnPdf.setForeground(new Color(255, 255, 255));
		btnPdf.setBackground(new Color(173, 8, 8));
		btnPdf.setBounds(154, 465, 81, 27);
		panel.add(btnPdf);
		
		JLabel lblNewLabel_1_1 = new JLabel("Buscar por ID:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(55, 70, 89, 20);
		panel.add(lblNewLabel_1_1);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtBuscar.setColumns(10);
		txtBuscar.setBounds(143, 70, 86, 20);
		panel.add(txtBuscar);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBackground(new Color(204, 226, 178));
		btnBuscar.setBounds(238, 67, 37, 23);
		btnBuscar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/lupaicono.png")));
		panel.add(btnBuscar);
		
		txtId = new JTextField();
		txtId.setBounds(10, 22, 4, 12);
		panel.add(txtId);
		txtId.setColumns(10);
		
		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "ID", "DNI", "Nombre", "Correo", "Telefono"
	            }
	        );

		tblCliente = new JTable(modelo);
		tblCliente.getColumnModel().getColumn(0).setPreferredWidth(20); // ID
		tblCliente.getColumnModel().getColumn(1).setPreferredWidth(100); // DNI
		tblCliente.getColumnModel().getColumn(2).setPreferredWidth(20); // Nombre
		tblCliente.getColumnModel().getColumn(3).setPreferredWidth(20); // Correo
		tblCliente.getColumnModel().getColumn(4).setPreferredWidth(20); // Telefono

		
		
		 mostrarTabla();
		 JScrollPane scrollPane = new JScrollPane(tblCliente);
		 scrollPane.setBounds(24, 23, 878, 514);
		 getContentPane().add(scrollPane);
		 
		 tblCliente_1 = new JTable();
		 scrollPane.setColumnHeaderView(tblCliente_1);
		 
		 
		 btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						
						Cliente cliente = new Cliente();
						cliente.setDni(Integer.parseInt(txtDni.getText()));
						cliente.setNombre(txtNombre.getText());
						cliente.setCorreo(txtCorreo.getText());
						cliente.setTelefono(txtTelefono.getText());

			            	            
			            clienteController.agregarCliente(cliente);
			            mostrarTabla();
			            limpiar();
			            JOptionPane.showMessageDialog(ifrm_GestionarCliente.this, "Cliente agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				       
				    } catch (Exception ex) {
				        JOptionPane.showMessageDialog(ifrm_GestionarCliente.this, "Ocurrió un error al registrar el Cliente", "Error", JOptionPane.ERROR_MESSAGE);
				    }
				}
			});
		 
			txtBuscar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					txtBuscar.setText("");
				}
			});
			
			
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiar();
				}
			});
			
			btnBuscar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent arg0) {
			        try {
			            int idCliente = Integer.parseInt(txtBuscar.getText());
			            Cliente clienteEncontrado = clienteController.buscarClientePorId(idCliente);

			            // Verificar si se encontró un cliente
			            if (clienteEncontrado != null) {
			                // Establecer los valores en los campos
			                txtId.setText(String.valueOf(clienteEncontrado.getId()));
			                txtDni.setText(String.valueOf(clienteEncontrado.getDni()));
			                txtNombre.setText(clienteEncontrado.getNombre());
			                txtCorreo.setText(clienteEncontrado.getCorreo());
			                txtTelefono.setText(clienteEncontrado.getTelefono());
			            } else {
			                // Manejar la situación donde no se encuentra el cliente
			                JOptionPane.showMessageDialog(ifrm_GestionarCliente.this, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			            }

			        } catch (NumberFormatException ex) {
			            // Capturar excepción si el formato del ID no es válido
			            JOptionPane.showMessageDialog(ifrm_GestionarCliente.this, "ID inválido", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    }
			});
		
			
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int filaSeleccionada = tblCliente.getSelectedRow();
				    
				    if (filaSeleccionada >= 0) {
				        try {
				            Object idObject = tblCliente.getValueAt(filaSeleccionada, 0);
				            int idCliente = Integer.parseInt(idObject.toString()); // Intenta la conversión

				            int confirmacion = JOptionPane.showConfirmDialog(ifrm_GestionarCliente.this, "¿Está seguro de que desea eliminar este Producto?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

				            if (confirmacion == JOptionPane.YES_OPTION) {
				                clienteController.eliminarCliente(idCliente); // Llama al método del controlador para eliminar el alumno
				                mostrarTabla();
				            }
				        } catch (NumberFormatException ex) {
				            JOptionPane.showMessageDialog(ifrm_GestionarCliente.this, "Error de conversión: El valor no es un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
				        }
				    } else {
				        JOptionPane.showMessageDialog(ifrm_GestionarCliente.this, "Por favor, seleccione un Usuario para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				    }   
				}
			});
		 
		 btnExcel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					/* ReporteController controller = new ReporteController();
		        	 List<Reporte> listarReporte = controller.listarReporte();
		        	 ReporteExcel.reporte();*/
					
				}
			});

		}
		
		private void mostrarTabla() {
		    modelo.setRowCount(0); // Limpiar la tabla antes de agregar datos
		    List<Cliente> listarCliente = clienteController.listarCliente();
		    
		    for (Cliente cliente : listarCliente) {
		        Object[] fila = {
		        		
		        		cliente.getId(),
		        		cliente.getDni(),
		        		cliente.getNombre(),
		        		cliente.getCorreo(),
		        		cliente.getTelefono()	        		
		        };
		        modelo.addRow(fila);
		    }
		}
		
		private void limpiar() {
			
			txtDni.setText("");
			txtNombre.setText("");
			txtCorreo.setText("");
			txtTelefono.setText("");
		}
	}