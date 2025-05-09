package altamirano.hernandez.app_apirest_springboot.repositories;

import altamirano.hernandez.app_apirest_springboot.models.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {
}
