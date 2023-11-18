package Dao;

import Model.Compra;

public interface CompraDao {	
	
	public int agregarOrdenCompra(Compra compra);
	
	public String obtenerUltimoNumeroCompra();
	
	public void actualizarNumeroCompra(String nuevoNumeroCompra);
	
	public int obtenerIdCompraPorNumeroCompra(String numeroCompra);	
}