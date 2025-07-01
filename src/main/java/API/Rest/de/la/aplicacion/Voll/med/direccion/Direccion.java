package API.Rest.de.la.aplicacion.Voll.med.direccion;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Direccion {
    private String calle;
    private String numero;
    private String ciudad;
    private String complemento;
    private String barrio;
    private String estado;
    private String codigo_postal;

    public Direccion(DatosDireccion datosDireccion) {
        this.calle = datosDireccion.calle();
        this.numero = datosDireccion.numero();
        this.ciudad = datosDireccion.ciudad();
        this.complemento = datosDireccion.complemento();
        this.barrio = datosDireccion.barrio();
        this.estado = datosDireccion.estado();
        this.codigo_postal = datosDireccion.codigo_postal();
    }
}
