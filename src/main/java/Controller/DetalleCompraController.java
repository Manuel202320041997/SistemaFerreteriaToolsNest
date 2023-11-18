package Controller;

import java.util.ArrayList;
import java.util.List;

import Dao.DetalleCompraDao;
import DaoImpl.DetalleCompraDaoImpl;
import Model.Compra;
import Model.DetalleCompra;

public class DetalleCompraController {
	private DetalleCompraDao detallecompradao = null;
	private CompraController compracontroller;
	
	public DetalleCompraController() {
		detallecompradao = new DetalleCompraDaoImpl();
		compracontroller = new CompraController();
	}
	
	public List<DetalleCompra> listarDetalleCompra(){
		List<DetalleCompra> listaDetalleCompra = null;
		listaDetalleCompra = detallecompradao.listarDetalleCompra();
		return listaDetalleCompra;
	}
	
	public List<DetalleCompra> listarDetalleCompraPorNumeroCompra(String numeroCompra){
		List<DetalleCompra> listaDetalleCompra = new ArrayList<>();
		
		int idCompra = compracontroller.obtenerIdCompraPorNumeroCompra(numeroCompra);
		
		if(idCompra > 0) {
			listaDetalleCompra = detallecompradao.listarDetalleCompraPorIdCompra(idCompra);
		}
		else {
			System.err.println("ERROR AL LISTAR DETALLE");
		}
		return listaDetalleCompra;
	}
	
	public void registrarDetalleCompra(DetalleCompra detallecompra) {
		DetalleCompra detalle = new DetalleCompra();
		
		detalle.setId_compra(detallecompra.getId_compra());
		detalle.setId_producto(detallecompra.getId_producto());
		detalle.setCantidad(detallecompra.getCantidad());
		detalle.setPrecio_compra(detallecompra.getPrecio_compra());
		
		detallecompradao.agregarDetalleCompra(detallecompra);
	}
}
