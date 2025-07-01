package API.Rest.de.la.aplicacion.Voll.med.medico;

public record DatosListadoMedico(
    Long id,
    String nombre,
    String email,
    String documento,
    String telefono,
    Especialidad especialidad
) {}
