package Controller;

import Dao.EmpleadoDao;
import DaoImpl.EmpleadoDaoImpl;
import Model.Empleado;

public class EmpleadoController {
	private EmpleadoDao empleadodao = null;
	
	public EmpleadoController() {
		empleadodao = new EmpleadoDaoImpl();
	}
	
	public Empleado buscarEmpleadoPorDni(int dniEmpleado) {
		return empleadodao.buscarEmpleadoPorDni(dniEmpleado);
	}
	
}
