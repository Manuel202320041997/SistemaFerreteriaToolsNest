package Controller;

import DaoImpl.VentaDaoImpl;
import DaoImpl.DetalleVentaDaoImpl;
import Model.Venta;
import Model.DetalleVenta;

public class VentaController {
	
	
	private VentaDaoImpl ventaDaoImpl = null;
	private DetalleVentaDaoImpl detalleVentaDaoImpl = null; 
	
	public VentaController(){
		ventaDaoImpl = new VentaDaoImpl();
		detalleVentaDaoImpl = new DetalleVentaDaoImpl(); 
	}
	
	public String generarNumeroFactura() {
		char letraActual = 'A';
		int numeroActual = 1;
		
		 // Combina la letra actual con el número actual
        String numeroVenta = letraActual + String.format("%05d", numeroActual);

        // Aumenta el número actual y, si es necesario, cambia la letra
        if (numeroActual < 99999) {
            numeroActual++;
        } else {
            numeroActual = 1;
          
            letraActual = (char) (letraActual + 1);
        }

        return numeroVenta;
	}
	
	public int registrarVenta(String numeroVenta, int idCliente, double totalVenta) {
		
		Venta venta = new Venta();
		venta.setNumero_venta(numeroVenta);
		venta.setId_cliente(idCliente);
		venta.setTotal(totalVenta);
		
		int idVenta = ventaDaoImpl.agregarVenta(venta);
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
}