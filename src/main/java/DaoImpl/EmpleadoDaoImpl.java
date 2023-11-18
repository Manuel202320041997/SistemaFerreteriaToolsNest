package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.Conexion;
import Dao.EmpleadoDao;
import Model.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao{
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public EmpleadoDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
    
	@Override
	public Empleado buscarEmpleadoPorDni(int dniEmpleado) {
		try {
			String consulta = "SELECT * FROM empleado WHERE DNI = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, dniEmpleado);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				Empleado empleado = new Empleado();
				empleado.setId(resultSet.getInt("id"));
				empleado.setDni(resultSet.getInt("dni"));
				empleado.setNombres(resultSet.getString("nombres"));
				empleado.setCorreo(resultSet.getString("correo"));
				empleado.setId_cargo(resultSet.getInt("id_cargo"));
				empleado.setEstado(resultSet.getBoolean("estado"));
				
				return empleado;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
