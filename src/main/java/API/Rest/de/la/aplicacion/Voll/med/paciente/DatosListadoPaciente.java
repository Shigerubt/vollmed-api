package API.Rest.de.la.aplicacion.Voll.med.paciente;

public record DatosListadoPaciente(
    Long id,
    String nombre,
    String email,
    String documento,
    String telefono
) {}

