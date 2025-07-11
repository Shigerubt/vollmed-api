package API.Rest.de.la.aplicacion.Voll.med.direccion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DatosDireccion(
        @NotBlank String calle,
        String numero,
        String complemento,
        @NotBlank String barrio,
        @NotBlank String ciudad,
        @NotBlank @Pattern(regexp = "\\d{8}") String codigo_postal,
        @NotBlank String estado) {
    // Constructor is automatically generated by the record ver minuto 8:02
}
