package Controller;

import java.util.List;
import Dao.InventarioDao;
import DaoImpl.InventarioDaoImpl;
import Model.Inventario;

public class InventarioController {
    private InventarioDaoImpl inventarioDaoImpl = null;

    public InventarioController() {
        inventarioDaoImpl = new InventarioDaoImpl();
    }

    public List<Inventario> listaInventario() {
        List<Inventario> listaInventario = null;
        listaInventario = inventarioDaoImpl.listarInventario();
        return listaInventario;
    }

}