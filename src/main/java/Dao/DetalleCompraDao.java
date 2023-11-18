package Dao;

import java.util.List;

import Model.DetalleCompra;

public interface DetalleCompraDao {
	public List<DetalleCompra> listarDetalleCompra(); 
	
	public List<DetalleCompra> listarDetalleCompraPorIdCompra(int idCompra);
	
	public DetalleCompra obtenerDetallePorNumeroCompra(String numeroCompra);
	
	public void agregarDetalleCompra(DetalleCompra detallecompra);
}
