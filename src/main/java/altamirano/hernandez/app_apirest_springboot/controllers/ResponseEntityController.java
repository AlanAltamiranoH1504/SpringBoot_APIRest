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
@RequestMapping("/json")
public class ResponseEntityController {
    @GetMapping("/response-entity")
    public ResponseEntity<?> pruebaResponse(){
        Map<String, Object> json = new HashMap<>();
        json.put("msg", "Funcionando controlador de tipo response entity");

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @GetMapping("/get")
    public ResponseEntity<?> metodoGet(){
        Map<String, Object> json = new HashMap<>();
        json.put("msg", "Metodo GET funcionando");

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @PostMapping("/post")
    public ResponseEntity<?> metodoPost(){
        Map<String, Object> json = new HashMap<>();
        json.put("json", "Metodo POST funcionando");

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @PutMapping("/put")
    public ResponseEntity<?> metodoPut(){
        Map<String, Object> json = new HashMap<>();
        json.put("msg", "Metodo PUT funcionando");

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> metodoDelete(){
        Map<String, Object> json = new HashMap<>();
        json.put("msg", "Metodo DELETE funcionando");

        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @PostMapping("/cuerpo")
    public ResponseEntity<?> requestBodyEjemplo(@Valid @RequestBody Ejemplo ejemplo, BindingResult bindingResult){
        Map<String, Object> json = new HashMap<>();
        if (bindingResult.hasErrors()){
            Map<String, Object> errores = new HashMap<>();
            bindingResult.getFieldErrors().forEach(error -> {
                errores.put(error.getField(), error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errores);
        }else{
            json.put("msg", "Recibiendo request body");
            json.put("body", ejemplo);
            return ResponseEntity.status(HttpStatus.OK).body(json);
        }
    }
}
