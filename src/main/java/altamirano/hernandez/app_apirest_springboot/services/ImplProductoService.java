package altamirano.hernandez.app_apirest_springboot.services;

import altamirano.hernandez.app_apirest_springboot.models.Producto;
import altamirano.hernandez.app_apirest_springboot.repositories.IProductoRepository;
import altamirano.hernandez.app_apirest_springboot.services.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplProductoService implements IProductoService {
    @Autowired
    private IProductoRepository iProductoRepository;

    @Override
    public List<Producto> findAll() {
        List<Producto> productos = (List<Producto>) iProductoRepository.findAll();
        return productos;
    }

    @Override
    public Producto findById(int id) {
        try {
            Producto productoFound = iProductoRepository.findById(id).get();
            return productoFound;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Producto producto) {
        try{
            iProductoRepository.save(producto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try{
            var productoFound = iProductoRepository.findById(id).get();
            if (productoFound != null){
                iProductoRepository.deleteById(productoFound.getId());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
