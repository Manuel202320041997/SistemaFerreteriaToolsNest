package Controller;

import java.util.ArrayList;
import java.util.List;

import DaoImpl.ProductoDaoImpl;
import Model.Producto;
import Model.Usuario;

public class ProductoController {
	private ProductoDaoImpl productoDaoImpl = null;
	//private CategoriaController categoriaController = new CategoriaController();
	    
	    public ProductoController(){
	        productoDaoImpl = new ProductoDaoImpl();
	    }
	    
	    public List<Producto> listarProducto(){
    	 	List<Producto> listaCompleta = productoDaoImpl.listarProducto();
    	    List<Producto> listaFiltrada = new ArrayList<>();

    	    for (Producto producto : listaCompleta) {
    	        if (producto.getEstado()) { // Filtra solo los productos con estado true
    	            listaFiltrada.add(producto);
    	        }
    	    }
    	    return listaFiltrada;
	    }
	    
	    public void agregarProducto(Producto producto){
	      	 try {
	      	        // Crear un objeto Alumno con los valores numéricos
	      	     Producto productoObj = new Producto();
	   		   	productoObj.setDescripcion(producto.getDescripcion());
	   		   	productoObj.setStock(producto.getStock());
	   		   	productoObj.setPrecio_compra(producto.getPrecio_compra());
	   		   	productoObj.setPrecio_venta(producto.getPrecio_venta());
	   		   	
	   		   //	productoObj.setId_categoria(producto.getId_categoria());

	     
	      	        productoDaoImpl.registrarProducto(productoObj);
	      	    } catch (Exception e) {
	      	        e.printStackTrace(); // Manejo de excepciones, puedes personalizarlo según tus necesidades
	      	    }
	      }
	    
	    public Producto obtenerProductoPorId(int idProducto) {
	 	   List<Producto> productos = listarProducto(); // Obtener la lista filtrada

	 	    // Buscar el producto por ID en la lista filtrada
	 	    for (Producto producto : productos) {
	 	        if (producto.getId() == idProducto && producto.getEstado()) {
	 	            return producto;
	 	        }
	 	    }

	 	    return null; 
	    }
	    
	    public void actualizarStock(int idProducto, int nuevoStock, int anteriorStock) {
	 	   try {
	 		int stockSuma = nuevoStock + anteriorStock;   
	 		productoDaoImpl.actualizarStock(idProducto, stockSuma);
	 	   } catch (Exception e) {
	 		e.printStackTrace();
	 	   }
	    }
	    
	    public void eliminarProducto(int idProducto) {
	 	   productoDaoImpl.eliminarProducto(idProducto);
	    }
	    
	    public Producto obtenerStockyPrecioPorNombre(String nombreProducto){
			Producto producto = productoDaoImpl.obtenerStockyPrecioPorNombre(nombreProducto);

			if(producto != null){
				int stock = producto.getStock();
				double precio_venta = producto.getPrecio_venta();
				double precio_compra = producto.getPrecio_compra();
				

				producto.setStock(stock);
				producto.setPrecio_venta(precio_venta);
				producto.setPrecio_compra(precio_compra);
				
				return producto;
			}

			else{
				return null;
			}
	   }	    
	    
	   public int obtenerIdProductoPorNombre(String nombreProducto){
			return productoDaoImpl.obtenerIdProductoPorNombre(nombreProducto);
	   }
	   
	   public String obtenerNombreProductoPorId(int idProducto) {
		    Producto producto = obtenerProductoPorId(idProducto);
		    
		    if (producto != null) {
		        return producto.getDescripcion();
		    } else {
		        return "No encontrado";
		    }
		}
	   
	   /*FUNCIONES PARA ACTUALIZACION DE PRECIOS*/
	   public void actualizarPrecioCompraPorcentaje(double numeroActualizar, int marca) {
		   productoDaoImpl.actualizarPrecioCompraPorcentaje(numeroActualizar, marca);
	   }
	   
	   public void actualizarPrecioCompraSoles(double numeroActualizar, int marca) {
		   productoDaoImpl.actualizarPrecioCompraSoles(numeroActualizar, marca);
	   }
	   
	   public void actualizarPrecioVentaPorcentaje(double numeroActualizar, int marca) {
		   productoDaoImpl.actualizarPrecioVentaPorcentaje(numeroActualizar, marca);		   
	   }
	   
	   public void actualizarPrecioVentaSoles(double numeroActualizar, int marca) {
		   productoDaoImpl.actualizarPrecioVentaSoles(numeroActualizar, marca);
	   }
}	
