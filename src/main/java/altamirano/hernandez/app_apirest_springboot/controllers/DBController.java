package altamirano.hernandez.app_apirest_springboot.controllers;

import altamirano.hernandez.app_apirest_springboot.models.Categoria;
import altamirano.hernandez.app_apirest_springboot.models.DTO.CategoriaDTO;
import altamirano.hernandez.app_apirest_springboot.models.Producto;
import altamirano.hernandez.app_apirest_springboot.services.interfaces.ICategoriaService;
import altamirano.hernandez.app_apirest_springboot.services.interfaces.IProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/db")
public class DBController {
    /**
     * CATEGORIAS
     */
    @Autowired
    private ICategoriaService iCategoriaService;

    @GetMapping("/list-categorias")
    public ResponseEntity<?> findAllCategorias(){
        Map<String, Object> json = new HashMap<>();
        try {
            List<Categoria> categoriasList = iCategoriaService.findAll();
            json.put("categorias", categoriasList);

            return ResponseEntity.status(HttpStatus.OK).body(json);
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        Map<String, Object> json = new HashMap<>();
        try {
            Optional<Categoria> categoria = iCategoriaService.findById(id);
            if (categoria.isPresent()) {
                json.put("categoria", categoria.get());
                return ResponseEntity.status(HttpStatus.OK).body(json);
            } else {
                json.put("msg", "Categoria no encontrada");
                return ResponseEntity.status(404).body(json);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/save-categoria")
    public ResponseEntity<?> saveCategoria(@Valid @RequestBody Categoria categoria, BindingResult bindingResult){
        Map<String, Object> json = new HashMap<>();
        if (bindingResult.hasErrors()){
            Map<String, Object> errores = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errores.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errores);
        }else{
            iCategoriaService.save(categoria);
            json.put("msg", "Categoria creada");
            return ResponseEntity.status(HttpStatus.CREATED).body(json);
        }
    }

    @PutMapping("/edit-categoria")
    public ResponseEntity<?> editCategoria(@Valid @RequestBody Categoria categoria, BindingResult bindingResult){
        Map<String, Object> json = new HashMap<>();
        if (bindingResult.hasErrors()){
            Map<String, Object> errores = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errores.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errores);
        }else{
            iCategoriaService.save(categoria);
            json.put("msg", "Categoria actualizada");
            return ResponseEntity.status(HttpStatus.OK).body(json);
        }
    }

    @DeleteMapping("/delete-categoria")
    public ResponseEntity<?> deleteCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO, BindingResult bindingResult){
        Map<String, Object> json = new HashMap<>();
        if (bindingResult.hasErrors()){
            Map<String, Object> errores = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errores.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errores);
        } else{
            iCategoriaService.deleteById(categoriaDTO.getId());
            json.put("msg", "Categoria eliminada");
            return ResponseEntity.status(HttpStatus.OK).body(json);
        }
    }


    /**
     * PRODUCTOS
     */
    @Autowired
    private IProductoService iProductoService;
    @GetMapping("/findAll-productos")
    public ResponseEntity<?> findAllProductos(){
        Map<String, Object> json = new HashMap<>();
        try{
            List<Producto> productos = iProductoService.findAll();
            json.put("productos", productos);
            return ResponseEntity.status(HttpStatus.OK).body(json);
        } catch (Exception e) {
            json.put("error", e.getMessage());
            return ResponseEntity.status(500).body(json);
        }
    }

}
