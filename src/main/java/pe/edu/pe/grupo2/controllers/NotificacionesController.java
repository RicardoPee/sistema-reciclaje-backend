package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.CantidadNotiUsuarioDTO;
import pe.edu.pe.grupo2.dtos.NotificacionesDTO;
import pe.edu.pe.grupo2.dtos.PromedioNotificacionesDTO;
import pe.edu.pe.grupo2.dtos.Top3UsuariosDTO;
import pe.edu.pe.grupo2.entities.Notificaciones;
import pe.edu.pe.grupo2.serviceinterfaces.INotificacionesService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
//@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")
public class NotificacionesController {
    @Autowired
    private INotificacionesService nS;

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public List<NotificacionesDTO> listar() {
        return nS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void insertar(@RequestBody NotificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones nt = m.map(dto, Notificaciones.class);
        nS.insert(nt);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public NotificacionesDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        NotificacionesDTO dto = m.map(nS.listId(id), NotificacionesDTO.class);
        return  dto;
    }

    @PutMapping
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody NotificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones ur = m.map(dto, Notificaciones.class);
        nS.update(ur);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id) {
        nS.delete(id);
    }

    @GetMapping("/promedioNotificacionesPorDiaUsuario")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<PromedioNotificacionesDTO> PromedioNotificacionesPorDiaUsuario(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin, @RequestParam int userId) {
        List<String[]> filaLista = nS.PromedioNotificacionesPorDiaUsuario(fechaInicio, fechaFin, userId);
        List<PromedioNotificacionesDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            PromedioNotificacionesDTO dto = new PromedioNotificacionesDTO();
            dto.setNombres(columna[0]);
            dto.setPromedio_noti(Double.parseDouble(columna[1].toString()));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/top3UsuariosConMasNotificaciones")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<Top3UsuariosDTO> Top3UsuariosConMasNotificaciones(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        List<String[]> filaLista = nS.Top3UsuariosConMasNotificaciones(fechaInicio, fechaFin);
        List<Top3UsuariosDTO> dtoLista = new ArrayList<>();
        for (String[] columna : filaLista) {
            Top3UsuariosDTO dto = new Top3UsuariosDTO();
            dto.setNombres(columna[0]);
            dto.setTotal(Integer.parseInt(columna[1]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }
}