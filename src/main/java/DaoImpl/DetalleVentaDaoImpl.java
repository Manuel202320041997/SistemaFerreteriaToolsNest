package DaoImpl;
import java.util.List;

import javax.swing.JComboBox;


import Dao.Conexion;
import Dao.DetalleVentaDao;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Controller.VentaController;
import Model.DetalleVenta;

public class DetalleVentaDaoImpl implements DetalleVentaDao{
	
	//Modelo de los datos
	ArrayList<DetalleVenta> listarProductos = new ArrayList<>();
	//Lista para el detalle de venta de los productos
	private DetalleVenta producto;
	private int idDetalleVenta;
	private int id_venta;
	private int id_producto;
	private String nombre ="";
	private int cantidad;
	private double p_unitario;
	private double subTotal;
	private double descuento;
	private double igv;
	private double totalPagar;
	private int estado;
	private JComboBox<String> cboProducto;
	private PreparedStatement statement = null;
    private Connection conexion;
    
    
    
    public DetalleVentaDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }

	@Override
	public List<DetalleVenta> listarDetalleVenta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetalleVenta obtenerDetallePorNombre(String nombreVenta) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	public void DatosDelProducto() {
		try {
			String sql = "SELECT * FROM producto WHERE descripcion= '"+this.cboProducto.getSelectedItem()+"'";
			Connection cn = Conexion.obtenerConexion();
			Statement st;
			st = cn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				id_producto = rs.getInt("id");
				nombre = rs.getString("nombre");
				cantidad = rs.getInt("cantidad");
				p_unitario =rs.getDouble("precio");
				igv = rs.getInt("porcentajeigv");
				
			    this.CalcularIGV(p_unitario, igv);
			
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error al obtener datos del producto"+ e);
		}
	}	
		//Metodo para el Calculo del IGV
	public double CalcularIGV(double p_unitario, double igv) {
	    double igvCalculado = igv; // Inicializa igvCalculado como 0.0

	    switch ((int) igvCalculado) {
	        case 0:
	            igv = 0.0;
	            break;

	        case 12:
	        	igv = (p_unitario * cantidad) * 0.12;
	        	
	        case 14:
	            igv = (p_unitario * cantidad) * 0.14;
	            break;

	        default:
	            break;
	    }

	    return igvCalculado;
	
	}

	@Override
	public void agregarDetalleVenta(DetalleVenta detalle) {
		 try {
		        String consulta = "INSERT INTO detalle_venta (id_venta, id_producto, cantidad, precio_venta) VALUES (?, ?, ?, ?)";
		        PreparedStatement statement = conexion.prepareStatement(consulta);

		        statement.setInt(1, detalle.getId_venta());
		        statement.setInt(2, detalle.getId_producto());
		        statement.setInt(3, detalle.getCantidad());
		        statement.setDouble(4, detalle.getPrecio_venta());

		        statement.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}

}

   
