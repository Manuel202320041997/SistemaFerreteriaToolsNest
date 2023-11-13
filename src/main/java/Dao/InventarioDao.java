package Dao;

import java.util.List;
import Model.Inventario;

public interface InventarioDao {
    List<Inventario> listarInventario();

    Inventario buscarProductoPorId(int idProducto);
}