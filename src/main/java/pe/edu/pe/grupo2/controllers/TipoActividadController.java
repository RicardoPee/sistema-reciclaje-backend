package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.TipoActividadDTO;
import pe.edu.pe.grupo2.entities.TipoActividad;
import pe.edu.pe.grupo2.serviceinterfaces.ITipoActividadService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipodeactividades")
//@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")
public class TipoActividadController {
    @Autowired
    private ITipoActividadService tS;

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public List<TipoActividadDTO> listar() {
        return tS.list().stream().map(x -> {
            ModelMapper t = new ModelMapper();
            return t.map(x, TipoActividadDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    //   @PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public void insertar(@RequestBody TipoActividadDTO dto) {
        ModelMapper t = new ModelMapper();
        TipoActividad ta = t.map(dto, TipoActividad.class);
        tS.insert(ta);
    }

    @GetMapping("/{id}")
    public TipoActividadDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        TipoActividadDTO dto = m.map(tS.listId(id),TipoActividadDTO.class);
        return dto;
    }

    @PutMapping
    public void update(@RequestBody TipoActividadDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoActividad tc = m.map(dto, TipoActividad.class);
        tS.update(tc);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        tS.delete(id);
    }

    //@GetMapping("/buscarPorInvitacion")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    //public List<TipoActividadDTO> buscarPorInvitacion(@RequestParam("texto") String texto) {
    //    return tS.findByInvitacionContaining(texto).stream().map(x -> {
    //        ModelMapper t = new ModelMapper();
    //        return t.map(x, TipoActividadDTO.class);
    //    }).collect(Collectors.toList());
    //}

    //@GetMapping("/contarInvitacionesNoVacias")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    //public int contarInvitacionesNoVacias() {
    //    return tS.countNonEmptyInvitations();
    //}
}
