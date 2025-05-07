package altamirano.hernandez.app_apirest_springboot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
