package API.Rest.de.la.aplicacion.Voll.med.controller;

import API.Rest.de.la.aplicacion.Voll.med.medico.DatosActualizarMedico;
import API.Rest.de.la.aplicacion.Voll.med.medico.DatosListadoMedico;
import API.Rest.de.la.aplicacion.Voll.med.medico.DatosRegistroMedico;
import API.Rest.de.la.aplicacion.Voll.med.medico.Medico;
import API.Rest.de.la.aplicacion.Voll.med.medico.MedicoRepository;
import API.Rest.de.la.aplicacion.Voll.med.direccion.Direccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

//minuto 341
    @Autowired
    private MedicoRepository repository;

    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroMedico datos) {

        repository.save(new Medico(datos));
    }

    @GetMapping
    public Page<DatosListadoMedico> listado(Pageable pageable) {
        Page<Medico> pagina = repository.findAllByActivoTrueOrderByNombreAsc(Pageable.ofSize(10).withPage(pageable.getPageNumber()));
        return pagina.map(m -> new DatosListadoMedico(m.getId(), m.getNombre(), m.getEmail(), m.getDocumento(), m.getTelefono(), m.getEspecialidad()));
    }

    @PutMapping
    @Transactional
    public void actualizar(@RequestBody @Valid DatosActualizarMedico datos) {
        Medico medico = repository.getReferenceById(datos.id());
        medico.actualizarDatos(datos.nombre(), datos.telefono(), new Direccion(datos.direccion()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminar(@PathVariable Long id) {
        Medico medico = repository.getReferenceById(id);
        medico.inactivar();
    }

}
