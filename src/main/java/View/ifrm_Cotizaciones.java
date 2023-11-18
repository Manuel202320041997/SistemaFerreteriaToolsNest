package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class ifrm_Cotizaciones extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	DefaultTableModel modelo;
	private JTable tblProductos;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_Cotizaciones frame = new ifrm_Cotizaciones();
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
	public ifrm_Cotizaciones() {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		

		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	            		"ID", "Nombre", "Precio Compra", "Cantidad"
	            }
	        );

		tblProductos = new JTable(modelo);
		tblProductos.getColumnModel().getColumn(0).setPreferredWidth(20); // ID
		tblProductos.getColumnModel().getColumn(1).setPreferredWidth(150); // Nombre
		tblProductos.getColumnModel().getColumn(2).setPreferredWidth(20); // Correo
		tblProductos.getColumnModel().getColumn(3).setPreferredWidth(20);
		//mostrarTabla();
	 // Crear un JScrollPane y agregar la JTable a él
		JScrollPane scrollPane = new JScrollPane(tblProductos);
		scrollPane.setBounds(10, 11, 928, 560);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(948, 11, 306, 560);
		panel.setBackground(new Color(245,245,245));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("COTIZACIONES");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_10.setBounds(0, 34, 306, 40);
		panel.add(lblNewLabel_10);
		
		JComboBox cboProducto = new JComboBox();
		cboProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboProducto.setBounds(128, 107, 147, 22);
		panel.add(cboProducto);
		
		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setBounds(128, 142, 147, 22);
		panel.add(spinnerCantidad);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(128, 177, 147, 22);
		panel.add(textField);
		
		JLabel lblNewLabel_4_2 = new JLabel("P. Unitario:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(24, 177, 94, 20);
		panel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cantidad:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(24, 140, 94, 22);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Producto:");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1.setBounds(24, 107, 94, 20);
		panel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DETALLES DE PRODUCTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1_1.setBounds(10, 85, 286, 130);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Total:");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2_1.setBounds(24, 318, 94, 20);
		panel.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("SubTotal:");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1_1.setBounds(24, 248, 94, 20);
		panel.add(lblNewLabel_4_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(128, 318, 147, 22);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("IGV:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(24, 281, 94, 22);
		panel.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("");
		lblNewLabel_3_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "CALCULOS DE COTIZACION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1_1_1.setBounds(10, 226, 286, 130);
		panel.add(lblNewLabel_3_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(128, 284, 147, 22);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(128, 250, 147, 22);
		panel.add(textField_3);		
	}
}
