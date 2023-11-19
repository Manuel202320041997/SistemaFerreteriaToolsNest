package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.SQLException;

//import com.mysql.cj.xdevapi.Statement;

import Dao.Conexion;
import Dao.VentaDao;
import Model.Compra;
import Model.DetalleVenta;
import Model.Venta;

public class VentaDaoImpl implements VentaDao {
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public VentaDaoImpl() {
    	 this.conexion = Conexion.obtenerConexion();
	};
	@Override
	public int agregarVenta(Venta venta) {
		 int idGenerado = -1; // Valor predeterminado en caso de que no se obtenga un ID generado

		    try {
		        String consulta = "INSERT INTO venta (numero_venta, id_cliente, total, id_modo_pago, id_empleado) VALUES (?, ?, ?, ?, ?)";
		        PreparedStatement statement = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

		        statement.setString(1, venta.getNumero_venta());
		        statement.setInt(2, venta.getId_cliente());
		        statement.setDouble(3, venta.getTotal());
		    	statement.setInt(4, venta.getId_modo_pago());
				statement.setInt(5, venta.getId_empleado());

		        statement.executeUpdate();

		        // Obtener las claves generadas (en este caso, solo se espera una clave generada)
		        ResultSet generatedKeys = statement.getGeneratedKeys();
		        if (generatedKeys.next()) {
		            idGenerado = generatedKeys.getInt(1); // Obtener el valor del ID generado
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return idGenerado;
	}
	@Override
	public String obtenerUltimoNumeroFactura() {
		String ultimoNumeroVenta = null;
		
		try {
			String consulta = "SELECT numero_venta FROM venta ORDER BY id DESC LIMIT 1";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				ultimoNumeroVenta = resultSet.getString("numero_venta");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ultimoNumeroVenta;
	}
	@Override
	public void actualizarNumeroFactura(String nuevoNumero) {
		try {
			String consulta = "UPDATE venta SET numero_venta = ? WHERE id = (SELECT MAX(id) FROM venta)";
			statement.setString(1, nuevoNumero);
			
			statement.executeQuery();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}
	@Override
	public int obtenerIdFacturaPorNumeroFactura(String numeroFactura) {
		int id = 0;
		
		try {
			String consulta = "SELECT id FROM venta WHERE numero_venta = ?";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				id = resultSet.getInt("id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public List<Venta> listarVentas() {
	    List<Venta> listarVentas = new ArrayList<>();
	    try {
	        String consulta = "SELECT * FROM venta";
	        statement = conexion.prepareStatement(consulta);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String numero_venta = resultSet.getString("numero_venta");
	            int id_cliente = resultSet.getInt("id_cliente");
	            double total = resultSet.getDouble("total");
	            int id_modo_pago = resultSet.getInt("id_modo_pago");
	            int id_empleado = resultSet.getInt("id_empleado");
	            java.sql.Date fecha_venta = resultSet.getDate("fecha_registro");
	            Boolean estado = resultSet.getBoolean("estado");

	            Venta venta = new Venta();
	            venta.setId(id);
	            venta.setNumero_venta(numero_venta);
	            venta.setId_cliente(id_cliente);
	            venta.setTotal(total);
	            venta.setId_modo_pago(id_modo_pago);
	            venta.setId_empleado(id_empleado);
	            venta.setFechaVenta(fecha_venta);
	            venta.setEstado(estado);

	            listarVentas.add(venta);
	        }
	        return listarVentas;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return Collections.emptyList();
	}

}

