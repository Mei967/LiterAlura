package aluracursos.literalura.model;

import aluracursos.literalura.dto.AutorDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    private String nombre;

    @JsonProperty("birth_year")
    private Integer fechaDeNacimiento;

    @JsonProperty("death_year")
    private Integer fechaDeMuerte;

    // Constructor vacío (requerido por JPA)
    public Autor() {}

    // ✅ Constructor desde AutorDTO (necesario para .map(Autor::new))
    public Autor(AutorDTO dto) {
        this.nombre = dto.nombre();
        this.fechaDeNacimiento = dto.fechaDeNacimiento();
        this.fechaDeMuerte = dto.fechaDeMuerte();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Integer fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public Integer getFechaDeMuerte() {
        return fechaDeMuerte;
    }

    public void setFechaDeMuerte(Integer fechaDeMuerte) {
        this.fechaDeMuerte = fechaDeMuerte;
    }

    @Override
    public String toString() {
        return "Autor: " + nombre +
                " (Nacimiento: " + fechaDeNacimiento +
                ", Muerte: " + (fechaDeMuerte != null ? fechaDeMuerte : "N/A") + ")";
    }
}
