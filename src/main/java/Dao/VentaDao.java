package Dao;

import Model.Venta;

public interface VentaDao {
    int agregarVenta(Venta venta);

    // No es posible tener métodos private en una interfaz, así que he eliminado los métodos privados
    // Puedes implementarlos en la clase que implementa la interfaz si es necesario.

    String obtenerUltimoNumeroFactura();

    void actualizarNumeroFactura(String nuevoNumero);

    int obtenerIdFacturaPorNumeroFactura(String numeroFactura);
}