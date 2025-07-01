package API.Rest.de.la.aplicacion.Voll.med.paciente;

import API.Rest.de.la.aplicacion.Voll.med.direccion.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarPaciente(
    @NotNull Long id,
    @NotBlank String nombre,
    @NotBlank String telefono,
    @NotNull @Valid DatosDireccion direccion
) {}

