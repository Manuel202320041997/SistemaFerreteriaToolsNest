package Controller;
import java.util.List;

import Dao.ProveedorDao;
import DaoImpl.ProveedorDaoImpl;
import Model.Proveedor;

public class ProveedorController {
	private ProveedorDao proveedordao = null;
	
	public ProveedorController() {
		proveedordao = new ProveedorDaoImpl();
	}
	
	public List<Proveedor> listarProveedor(){
		List<Proveedor> listaProveedor = null;
		listaProveedor = proveedordao.listarProveedor();
		return listaProveedor;
	}
	
	public void agregarProveedor(Proveedor proveedor) {
		try {
			Proveedor proveedorObj = new Proveedor();
			proveedorObj.setRazon_social(proveedor.getRazon_social());
			proveedorObj.setTelefono(proveedor.getTelefono());
			proveedorObj.setDireccion(proveedor.getDireccion());
			proveedorObj.setCorreo(proveedor.getCorreo());
			
			proveedordao.agregarProveedor(proveedorObj);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	
	public Proveedor buscarProveeedorPorId(int idProveedor) {
		return proveedordao.buscarProveeedorPorId(idProveedor);
	}
	
	public void editarProveedor(Proveedor proveedor) {
		try {
			Proveedor proveedorObj = new Proveedor();
			proveedorObj.setId(proveedor.getId());
			proveedorObj.setRazon_social(proveedor.getRazon_social());
			proveedorObj.setTelefono(proveedor.getTelefono());
			proveedorObj.setDireccion(proveedor.getDireccion());
			proveedorObj.setCorreo(proveedor.getCorreo());
			
			proveedordao.editarProveedor(proveedorObj);
			
		} catch (Exception e) {
			System.err.println("Error al editar Proveedor: " + e.getMessage());
		}
	}
	
	public void eliminarProveedor(int idProveedor) {
		proveedordao.eliminarProveedor(idProveedor);
	}
	
	public int obtenerIdProveedorPorNombre(String nombreProveedor) {
		return proveedordao.buscarIdProveedorPorNombre(nombreProveedor);
	}
}