package altamirano.hernandez.app_apirest_springboot.controllers;

import altamirano.hernandez.app_apirest_springboot.jwt.AuthRequest;
import altamirano.hernandez.app_apirest_springboot.jwt.AuthResponse;
import altamirano.hernandez.app_apirest_springboot.jwt.JwtTokenUtil;
import altamirano.hernandez.app_apirest_springboot.models.Usuario;
import altamirano.hernandez.app_apirest_springboot.repositories.IUsuarioRepository;
import altamirano.hernandez.app_apirest_springboot.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AccesoController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getCorreo(), authRequest.getPassword()));
            System.out.println(authentication);

            //Creamos token con datos del usuario
            Usuario usuario = iUsuarioRepository.findByEmail(authRequest.getCorreo());
            String accessToken = jwtTokenUtil.generarToken(usuario);

            AuthResponse response = new AuthResponse(authRequest.getCorreo(), accessToken);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
