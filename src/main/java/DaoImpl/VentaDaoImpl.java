package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

//import com.mysql.cj.xdevapi.Statement;

import Dao.Conexion;
import Dao.VentaDao;
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
		        String consulta = "INSERT INTO venta (numero_venta, id_cliente, total) VALUES (?, ?, ?)";
		        PreparedStatement statement = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

		        statement.setString(1, venta.getNumero_venta());
		        statement.setInt(2, venta.getId_cliente());
		        statement.setDouble(3, venta.getTotal());

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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void actualizarNumeroFactura(String nuevoNumero) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int obtenerIdFacturaPorNumeroFactura(String numeroFactura) {
		// TODO Auto-generated method stub
		return 0;
	}

}

