package altamirano.hernandez.app_apirest_springboot.controllers;

import altamirano.hernandez.app_apirest_springboot.models.Ejemplo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/prueba")
    ResponseEntity<?> prueba(){
        Map<String, Object> json = new HashMap<>();
        json.put("msg", "Controlador de API funcionando correctamente");

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @PostMapping("/prueba")
    ResponseEntity<?> pruebaPOST(){
        Map<String, Object> json = new HashMap<>();
        json.put("msg", "Controlador de API funcionando correctamente POST");

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @PutMapping("/prueba")
    ResponseEntity<?> pruebaPUT(){
        Map<String, Object> json = new HashMap<>();
        json.put("msg", "Controlador de API funcionando correctamente PUT");

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @DeleteMapping("/prueba")
    ResponseEntity<?> pruebaDELETE(){
        Map<String, Object> json = new HashMap<>();
        json.put("msg", "Controlador de API funcionando correctamente DELETE");

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @GetMapping("/parametro/{id}")
    ResponseEntity<?> parametro(@PathVariable int id){
        Map<String, Object> json = new HashMap<>();
        json.put("msg", "Ruta con parametro funcionando");
        json.put("id", id);
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @PostMapping("/cuerpo")
    ResponseEntity<?> cuerpo(@Valid @RequestBody Ejemplo ejemplo, BindingResult bindingResult){
        Map<String, Object> json = new HashMap<>();
        if (bindingResult.hasErrors()){
            Map<String, Object> errores = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error ->{
                errores.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errores);
        }else{
            json.put("msg", "request body recibido correctamente");
            json.put("ejemplo", ejemplo);
            return ResponseEntity.ok().body(json);
        }
    }
}
