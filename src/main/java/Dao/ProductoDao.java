package Dao;

import java.util.List;
import Model.Producto;

public interface ProductoDao {
	public List<Producto> listarProducto();

	//public List<Producto> listarProductoPorMarca(int idMarca);
	
	public void registrarProducto(Producto producto);

	public Producto obtenerProductoPorId(int idProducto);

	public void actualizarStock(int idProducto, int nuevoStock);

	public void eliminarProducto(int idProducto);

	public Producto obtenerStockyPrecioPorNombre(String nombreProducto);

	public int obtenerIdProductoPorNombre(String nombreProducto);
	
	/*FUNCIONES PARA ACTUALIZACION DE PRECIOS*/
	
	public void actualizarPrecioCompraPorcentaje(double numeroActualizar, int marca);
	   
	public void actualizarPrecioCompraSoles(double numeroActualizar, int marca);
		   
	public void actualizarPrecioVentaPorcentaje(double numeroActualizar, int marca);
		   
    public void actualizarPrecioVentaSoles(double numeroActualizar, int marca);

}
