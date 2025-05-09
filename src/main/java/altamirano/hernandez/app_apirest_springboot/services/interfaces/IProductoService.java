package altamirano.hernandez.app_apirest_springboot.services.interfaces;

import altamirano.hernandez.app_apirest_springboot.models.Producto;

import java.util.List;

public interface IProductoService {
    public abstract List<Producto> findAll();
    public abstract Producto findById(int id);
    public abstract void save(Producto producto);
    public abstract void deleteById(int id);
}
