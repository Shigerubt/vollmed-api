package API.Rest.de.la.aplicacion.Voll.med.medico;

import API.Rest.de.la.aplicacion.Voll.med.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(
    @NotNull Long id,
    @NotBlank String nombre,
    @NotBlank String telefono,
    @NotNull @Valid DatosDireccion direccion
) {}

