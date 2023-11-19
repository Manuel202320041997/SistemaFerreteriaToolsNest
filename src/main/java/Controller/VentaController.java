package Controller;

import DaoImpl.VentaDaoImpl;
import DaoImpl.DetalleVentaDaoImpl;
import Model.Venta;
import Model.DetalleVenta;

public class VentaController {
	
	
	private VentaDaoImpl ventaDao = null;
	private DetalleVentaDaoImpl detalleVentaDaoImpl = null; 
	
	public VentaController(){
		ventaDao = new VentaDaoImpl();
		detalleVentaDaoImpl = new DetalleVentaDaoImpl(); 
	}
	
	public String generarNumeroFactura() {
		String ultimoNumeroVenta = obtenerUltimoNumeroFactura();
		
		if(ultimoNumeroVenta != null) {
			char letraActual = ultimoNumeroVenta.charAt(0);;
			int numeroActual = Integer.parseInt(ultimoNumeroVenta.substring(1));
			
			if(numeroActual < 999999) {
				numeroActual++;
			}
			
			else {
				numeroActual = 1;
				letraActual = (char) (letraActual + 1); // aumenta la letra en uno: A, B, C, D, E
			}
			String numeroVenta = letraActual + String.format("%06d", numeroActual);
			
			return numeroVenta;
			
		}
		else {
			return null;
		}
		
	}
	
	public int registrarVenta(String numeroVenta, int idCliente, double totalVenta, int idModoPago, int idEmpleado) {
		
		Venta venta = new Venta();
		venta.setNumero_venta(numeroVenta);
		venta.setId_cliente(idCliente);
		venta.setTotal(totalVenta);
		venta.setId_modo_pago(idModoPago);
		venta.setId_empleado(idEmpleado);
		
		
		int idVenta = ventaDao.agregarVenta(venta);
		return idVenta;
	}
	
	public void registrarDetalleVenta(int idVenta, int id_producto, int cantidad, double precio_venta) {
		DetalleVenta detalle = new DetalleVenta(idVenta, id_producto, cantidad, precio_venta);

		
		detalle.setId_venta(idVenta);
		detalle.setId_producto(id_producto);
		detalle.setCantidad(cantidad);
		detalle.setPrecio_venta(precio_venta);
		
		detalleVentaDaoImpl.agregarDetalleVenta(detalle);
	}
	
	private String obtenerUltimoNumeroFactura() {
	    return ventaDao.obtenerUltimoNumeroFactura();
	}

	private void actualizarNumeroFactura(String nuevoNumeroFactura) {
	    ventaDao.actualizarNumeroFactura(nuevoNumeroFactura);
	}


public int obtenerIdFacturaPorNumeroFactura(String numeroFactura) {
		return ventaDao.obtenerIdFacturaPorNumeroFactura(numeroFactura);
	}
	
	
	
}