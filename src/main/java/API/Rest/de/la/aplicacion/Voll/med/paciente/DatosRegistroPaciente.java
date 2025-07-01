package API.Rest.de.la.aplicacion.Voll.med.paciente;

import API.Rest.de.la.aplicacion.Voll.med.direccion.DatosDireccion;

public record DatosRegistroPaciente(String nombre, String email, @jakarta.validation.constraints.NotBlank @jakarta.validation.constraints.Pattern(regexp = "\\d{7,9}") String documento, String telefono, DatosDireccion datosDireccion) {}
