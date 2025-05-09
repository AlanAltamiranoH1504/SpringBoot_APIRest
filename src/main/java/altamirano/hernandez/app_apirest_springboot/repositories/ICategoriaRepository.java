package altamirano.hernandez.app_apirest_springboot.repositories;

import altamirano.hernandez.app_apirest_springboot.models.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface ICategoriaRepository extends CrudRepository<Categoria, Integer> {
}
