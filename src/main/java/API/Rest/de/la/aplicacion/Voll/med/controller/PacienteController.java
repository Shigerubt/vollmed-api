package API.Rest.de.la.aplicacion.Voll.med.controller;

import API.Rest.de.la.aplicacion.Voll.med.direccion.Direccion;
import API.Rest.de.la.aplicacion.Voll.med.paciente.DatosActualizarPaciente;
import API.Rest.de.la.aplicacion.Voll.med.paciente.DatosListadoPaciente;
import API.Rest.de.la.aplicacion.Voll.med.paciente.DatosRegistroPaciente;
import API.Rest.de.la.aplicacion.Voll.med.paciente.Paciente;
import API.Rest.de.la.aplicacion.Voll.med.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void registrar(@RequestBody DatosRegistroPaciente datos) {
        repository.save(new Paciente(datos));
    }

    @GetMapping
    public Page<DatosListadoPaciente> listado(Pageable pageable) {
        Page<Paciente> pagina = repository.findAllByActivoTrue(pageable);
        return pagina.map(p -> new DatosListadoPaciente(p.getId(), p.getNombre(), p.getEmail(), p.getDocumento(), p.getTelefono()));
    }

    @PutMapping
    @Transactional
    public void actualizar(@RequestBody DatosActualizarPaciente datos) {
        Paciente paciente = repository.getReferenceById(datos.id());
        paciente.actualizarDatos(datos.nombre(), datos.telefono(), new Direccion(datos.direccion()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminar(@PathVariable Long id) {
        Paciente paciente = repository.getReferenceById(id);
        paciente.inactivar();
    }
}
