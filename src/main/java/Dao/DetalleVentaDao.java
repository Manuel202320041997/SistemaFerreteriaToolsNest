package Dao;

import java.util.List;

import Model.DetalleVenta;
//import Model.Producto;


public interface DetalleVentaDao {
	public List<DetalleVenta> listarDetalleVenta();
	
	public List<DetalleVenta> listarDetalleVentaPorNumeroFactura(int idFactura);
	
	public DetalleVenta obtenerDetallePorNumeroFactura(String numeroFactura);
	
	public List<DetalleVenta> listarDetalleVentaPorNumeroFactura(String numeroFactura);
	
	public void agregarDetalleVenta(DetalleVenta detalle);
	
	public DetalleVenta obtenerDetallePorNombre(String nombreVenta);
}
