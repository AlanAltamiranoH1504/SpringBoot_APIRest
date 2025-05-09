package altamirano.hernandez.app_apirest_springboot.services;

import altamirano.hernandez.app_apirest_springboot.models.Categoria;
import altamirano.hernandez.app_apirest_springboot.repositories.ICategoriaRepository;
import altamirano.hernandez.app_apirest_springboot.services.interfaces.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplCategoriaService implements ICategoriaService {
    @Autowired
    private ICategoriaRepository iCategoriaRepository;

    @Override
    public List<Categoria> findAll() {
        List<Categoria> categorias = (List<Categoria>) iCategoriaRepository.findAll();
        return categorias;
    }

    @Override
    public Optional<Categoria> findById(int id) {
        try{
            return iCategoriaRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Categoria categoria) {
        try{
            iCategoriaRepository.save(categoria);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            Categoria deletedCategoria = iCategoriaRepository.findById(id).get();
            if (deletedCategoria != null){
                iCategoriaRepository.deleteById(deletedCategoria.getId());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
