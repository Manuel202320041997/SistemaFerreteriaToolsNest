package Dao;

import java.util.List;

import Model.DetalleVenta;
//import Model.Producto;


public interface DetalleVentaDao {
	public List<DetalleVenta> listarDetalleVenta();

	public DetalleVenta obtenerDetallePorNombre(String nombreVenta);
	
	public void agregarDetalleVenta(DetalleVenta detalle);
}
