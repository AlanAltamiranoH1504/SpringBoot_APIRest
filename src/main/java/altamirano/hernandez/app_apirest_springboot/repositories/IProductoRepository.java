package altamirano.hernandez.app_apirest_springboot.repositories;

import altamirano.hernandez.app_apirest_springboot.models.Producto;
import org.springframework.data.repository.CrudRepository;

public interface IProductoRepository extends CrudRepository<Producto, Integer> {
}
