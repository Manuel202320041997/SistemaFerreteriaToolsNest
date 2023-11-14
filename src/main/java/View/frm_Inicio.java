package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import Model.Usuario;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;

public class frm_Inicio extends JFrame {
	private Usuario usuarioValidado;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JDesktopPane desktopPanePrincipal;
	private int x;
	private int y;
	private JMenu menuUsuario;
	private JMenu menuCompras;
	private JMenu menuVentas;
	private JMenu menuAlmacen;
	private JMenu menuContabilidad;
	private JMenu menuRRHH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	            	Usuario usuarioValido = new Usuario(/* parámetros necesarios */);

	                frm_Inicio frame = new frm_Inicio(usuarioValido);
	                System.out.println("Valor de idrolUsuario antes de llamar a configurarPorRolUsuario: " + usuarioValido.getId_rol());
	                //frame.configurarPorRolUsuario(usuarioValido.getId_rol());
	                System.out.println("Después de llamar a configurarPorRolUsuario");
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
	public frm_Inicio(Usuario usuarioValidado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setResizable(false);
        setUndecorated(true);
		contentPane = new JPanel();		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.usuarioValidado = usuarioValidado;
		String nombreUsuario = usuarioValidado.getNombre();		
		int idRolUsuario = usuarioValidado.getId_rol();		
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(40, 39, 61));
		panelTitulo.setBounds(0, 0, 1302, 28);
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setFocusable(false);
		btnMinimizar.setFocusTraversalKeysEnabled(false);
		btnMinimizar.setFocusPainted(false);
		btnMinimizar.setBorder(null);
		btnMinimizar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/borrar1.2.png")));
		btnMinimizar.setBackground(new Color(40, 39, 61));
		btnMinimizar.setBounds(29, 0, 32, 28);
		panelTitulo.add(btnMinimizar);
		
		JButton btnCerrar = new JButton("");
		btnCerrar.setFocusable(false);
		btnCerrar.setFocusTraversalKeysEnabled(false);
		btnCerrar.setFocusPainted(false);
		btnCerrar.setBorder(null);
		btnCerrar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/cerrar1.1.png")));
		btnCerrar.setBackground(new Color(40, 39, 61));
		btnCerrar.setBounds(0, 0, 32, 28);
		panelTitulo.add(btnCerrar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 109, 1280, 22);
		contentPane.add(menuBar);
		
		menuUsuario = new JMenu("Usuario");
		menuUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuUsuario);
		
		JMenuItem submenuGestionUsuario = new JMenuItem("Gestionar Usuario");
		submenuGestionUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuUsuario.add(submenuGestionUsuario);
		
		JMenuItem submenuGestionRol = new JMenuItem("Gestionar Rol");
		submenuGestionRol.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuUsuario.add(submenuGestionRol);
		
		menuCompras = new JMenu("Compras");
		menuCompras.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuCompras);
		
		JMenuItem submenuProveedores = new JMenuItem("Proveedores");
		submenuProveedores.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCompras.add(submenuProveedores);
		
		JMenuItem submenuPreciosActualizados = new JMenuItem("Precios Actualizados");
		submenuPreciosActualizados.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCompras.add(submenuPreciosActualizados);
		
		JMenuItem submenuOrdenCompra = new JMenuItem("Ordenes de Compra");
		submenuOrdenCompra.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCompras.add(submenuOrdenCompra);
		
		JMenuItem submenuCotizaciones = new JMenuItem("Cotizaciones");
		submenuCotizaciones.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCompras.add(submenuCotizaciones);
		
		menuVentas = new JMenu("Ventas");
		menuVentas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuVentas);
		
		JMenuItem submenuClientes = new JMenuItem("Clientes");
		submenuClientes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuVentas.add(submenuClientes);
		
		JMenuItem submenuFacturas = new JMenuItem("Facturas");
		submenuFacturas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuVentas.add(submenuFacturas);
		
		menuAlmacen = new JMenu("Almacen");
		menuAlmacen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuAlmacen);
		
		JMenuItem submenuInventario = new JMenuItem("Inventario");
		submenuInventario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAlmacen.add(submenuInventario);
		
		JMenuItem submenuIngresos = new JMenuItem("Ingresos");
		submenuIngresos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAlmacen.add(submenuIngresos);
		
		JMenuItem submenuSalidas = new JMenuItem("Salidas");
		submenuSalidas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAlmacen.add(submenuSalidas);
		
		JMenuItem submenuGuiaRemision = new JMenuItem("Guias de Remisión");
		submenuGuiaRemision.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAlmacen.add(submenuGuiaRemision);
		
		menuContabilidad = new JMenu("Contabilidad");
		menuContabilidad.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuContabilidad);
		
		JMenuItem submenuPagoFacturas = new JMenuItem("Pago de Facturas");
		submenuPagoFacturas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuContabilidad.add(submenuPagoFacturas);
		
		menuRRHH = new JMenu("R.R.H.H.");
		menuRRHH.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuRRHH);
		
		JMenuItem submenuPlanilla = new JMenuItem("Planilla");
		submenuPlanilla.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuRRHH.add(submenuPlanilla);
		
		JMenuItem submenuGestionEmpleados = new JMenuItem("Gestión de Empleados");
		submenuGestionEmpleados.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuRRHH.add(submenuGestionEmpleados);
		
		configurarMenuPorRolUsuario(idRolUsuario);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 28, 1280, 81);
		panel.setBackground(new Color(51, 52, 78));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 119, 81);
		lblNewLabel.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/herramientas-de-ferreteria-icono2.png")));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema de Ferretría ToolsNest");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setForeground(new Color(245, 245, 245));
		lblNewLabel_1.setBounds(114, 11, 319, 58);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario: " + nombreUsuario);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/usuarioicono.png")));
		lblNewLabel_2.setForeground(new Color(245, 245, 245));
		lblNewLabel_2.setBounds(1047, 11, 223, 52);
		panel.add(lblNewLabel_2);
		
		desktopPanePrincipal = new JDesktopPane();
		desktopPanePrincipal.setBackground(new Color(51, 52, 78));
		desktopPanePrincipal.setBounds(0, 131, 1302, 589);
		contentPane.add(desktopPanePrincipal);
				
        panelTitulo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                x = arg0.getX();
                y = arg0.getY();
            }
        });
        
        panelTitulo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                System.out.println("Coordenadas: (" + arg0.getX() + "," + arg0.getY() + ")");
                setLocation(getLocation().x + arg0.getX() - x, getLocation().y + arg0.getY() - y);
            }
        });
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnMinimizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		
		/*EVENTOS PARA ABRIR INTERNAL FRAMES*/
		submenuGestionUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarInternalFrames();
				ifrm_GestionarUsuario ifrm_gestionarusuario = new ifrm_GestionarUsuario();
				ifrm_gestionarusuario.setVisible(true);
				desktopPanePrincipal.add(ifrm_gestionarusuario);
			}
		});
		
		submenuProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarInternalFrames();
				prueba Prueba = new prueba();
				Prueba.setVisible(true);
				desktopPanePrincipal.add(Prueba);			}
		});
	}
	
	private void configurarMenuPorRolUsuario(int idrolUsuario) {
	    System.out.println("ID de Rol del Usuario: " + idrolUsuario); // Agrega esta línea para imprimir el valor
	    if (idrolUsuario == 2) {
	        menuUsuario.setVisible(false);
	        menuContabilidad.setVisible(false);
	        menuRRHH.setVisible(false);
	        // También puedes ocultar otros elementos relacionados con los menús si es necesario
	    }
	}
	
	// Método para cerrar todos los InternalFrames
	private void cerrarInternalFrames() {
	    JInternalFrame[] frames = desktopPanePrincipal.getAllFrames();
	    for (JInternalFrame frame : frames) {
	        frame.dispose();
	    }
	}
}
