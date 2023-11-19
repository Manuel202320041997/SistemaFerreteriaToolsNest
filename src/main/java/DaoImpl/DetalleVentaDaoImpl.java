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
import Model.DetalleCompra;
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
	
	public List<DetalleVenta> listarDetalleVentaPorIdVenta(int idVenta) {
		List<DetalleVenta> listaDetalle = new ArrayList<>();
	    try {
	        String consulta = "SELECT id_producto, cantidad, precio_venta FROM detalle_venta WHERE id_venta = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setInt(1, idVenta);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            int idProducto = resultSet.getInt("id_producto"); // Corregir el nombre de la columna
	            int cantidad = resultSet.getInt("cantidad");
	            double precio_venta = resultSet.getDouble("precio_venta");

	            DetalleVenta detalle = new DetalleVenta();
	            detalle.setId_producto(idProducto);
	            detalle.setCantidad(cantidad);
	            detalle.setPrecio_venta(precio_venta);

	            listaDetalle.add(detalle);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listaDetalle;
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
				nombre = rs.getString("descripcion");
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
	public void agregarDetalleVenta(DetalleVenta detalleventa) {
		 try {
		        String consulta = "INSERT INTO detalle_venta (id_venta, id_producto, cantidad, precio_venta) VALUES (?, ?, ?, ?)";
		        PreparedStatement statement = conexion.prepareStatement(consulta);
		        
		        System.out.println("Detalles de la compra a agregar:");
		        System.out.println("ID Compra: " + detalleventa.getId_venta());
		        System.out.println("ID Producto: " + detalleventa.getId_producto());
		        System.out.println("Cantidad: " + detalleventa.getCantidad());
		        System.out.println("Precio Compra: " + detalleventa.getPrecio_venta());

		        statement.setInt(1, detalleventa.getId_venta());
		        statement.setInt(2, detalleventa.getId_producto());
		        statement.setInt(3, detalleventa.getCantidad());
		        statement.setDouble(4, detalleventa.getPrecio_venta());

		        statement.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}

	@Override
	public List<DetalleVenta> listarDetalleVentaPorNumeroFactura(int idFactura) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DetalleVenta obtenerDetallePorNumeroFactura(String numeroFactura) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalleVenta> listarDetalleVentaPorNumeroFactura(String numeroFactura) {
		// TODO Auto-generated method stub
		return null;
	}

}

   
