package altamirano.hernandez.app_apirest_springboot.services;

import altamirano.hernandez.app_apirest_springboot.models.Categoria;
import altamirano.hernandez.app_apirest_springboot.repositories.ICategoriaRepository;
import altamirano.hernandez.app_apirest_springboot.services.interfaces.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Categoria findById(int id) {
        try{
            Categoria foundCategoria = iCategoriaRepository.findById(id).get();
            return foundCategoria;
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
    public void delete(Categoria categoria) {
        try {
            Categoria deletedCategoria = iCategoriaRepository.findById(categoria.getId()).get();
            if (deletedCategoria != null){
                iCategoriaRepository.deleteById(deletedCategoria.getId());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
