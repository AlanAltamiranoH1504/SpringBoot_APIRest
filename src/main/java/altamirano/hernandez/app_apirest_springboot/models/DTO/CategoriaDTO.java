package altamirano.hernandez.app_apirest_springboot.models.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoriaDTO {
    @NotNull(message = "El ID no puede estar vacio")
    private int id;

    //Constructores
    public CategoriaDTO() {}
    public CategoriaDTO(int id) {
        this.id = id;
    }

    //GET y SET
    public int getId() {
        return id;
    }

    public void setId( int id) {
        this.id = id;
    }
}
