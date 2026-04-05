package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.ActividadDTO;
import pe.edu.pe.grupo2.dtos.ActividadesPorCentroDTO;
import pe.edu.pe.grupo2.dtos.ActividadesPorUsuarioDTO;
import pe.edu.pe.grupo2.dtos.RankingDistritoDTO;
import pe.edu.pe.grupo2.entities.Actividad;
import pe.edu.pe.grupo2.serviceinterfaces.IActividadService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actividad")
//@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")
public class ActividadController {

    @Autowired
    private IActividadService aS;

    @GetMapping
    public List<ActividadDTO> listar() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            ActividadDTO dto = m.map(x, ActividadDTO.class);
            // Mapear campos nuevos que ModelMapper no resuelve automáticamente
            dto.setEstado(x.getEstado());
            dto.setCodigoReserva(x.getCodigoReserva());
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<ActividadDTO> insertar(@RequestBody ActividadDTO dto) {
        ModelMapper m = new ModelMapper();
        Actividad ac = m.map(dto, Actividad.class);
        aS.insert(ac);
        // Devolver el DTO con el código generado
        ActividadDTO respuesta = m.map(ac, ActividadDTO.class);
        respuesta.setEstado(ac.getEstado());
        respuesta.setCodigoReserva(ac.getCodigoReserva());
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ActividadDTO listarId(@PathVariable("id") Integer id) {
        Actividad x = aS.listId(id);
        ModelMapper m = new ModelMapper();
        ActividadDTO dto = m.map(x, ActividadDTO.class);
        dto.setEstado(x.getEstado());
        dto.setCodigoReserva(x.getCodigoReserva());
        return dto;
    }

    @PutMapping
    public void update(@RequestBody ActividadDTO dto) {
        ModelMapper m = new ModelMapper();
        Actividad ac = m.map(dto, Actividad.class);
        ac.setEstado(dto.getEstado());
        ac.setCodigoReserva(dto.getCodigoReserva());
        aS.update(ac);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        aS.delete(id);
    }

    /** NUEVO: Endpoint para que EMPLEADO/ADMI apruebe una actividad pendiente */
    @PutMapping("/{id}/aprobar")
    public ResponseEntity<String> aprobar(@PathVariable("id") Integer id) {
        try {
            aS.aprobar(id);
            return ResponseEntity.ok("Actividad aprobada correctamente. Puntos acreditados al usuario.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    /** NUEVO: Endpoint para que EMPLEADO/ADMI rechace una actividad pendiente */
    @PutMapping("/{id}/rechazar")
    public ResponseEntity<String> rechazar(@PathVariable("id") Integer id) {
        try {
            aS.rechazar(id);
            return ResponseEntity.ok("Actividad rechazada.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/ActividadesPorCentro")
    public List<ActividadesPorCentroDTO> actividadesPorCentro() {
        List<String[]> lista = aS.ActividadesporCentro();
        List<ActividadesPorCentroDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            ActividadesPorCentroDTO dto = new ActividadesPorCentroDTO();
            dto.setNombre_centro(columna[0]);
            dto.setNumero_actividades(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/ActividadesPorUsuario")
    public List<ActividadesPorUsuarioDTO> actividadesPorUsuario() {
        List<String[]> lista = aS.ActividadesporUsuario();
        List<ActividadesPorUsuarioDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            ActividadesPorUsuarioDTO dto = new ActividadesPorUsuarioDTO();
            dto.setUsername(columna[0]);
            dto.setNumeroactividades(Integer.parseInt(columna[1]));
            dto.setTotal_puntos(Integer.parseInt(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    /** NUEVO: Top 10 recicladores de la semana en un distrito */
    @GetMapping("/ranking/distrito")
    public List<RankingDistritoDTO> rankingPorDistrito(@RequestParam String distrito) {
        List<String[]> lista = aS.rankingPorDistrito(distrito);
        List<RankingDistritoDTO> listaDTO = new ArrayList<>();
        int posicion = 1;
        for (String[] columna : lista) {
            RankingDistritoDTO dto = new RankingDistritoDTO();
            dto.setUsername(columna[0]);
            dto.setNombres(columna[1]);
            dto.setApellidos(columna[2]);
            dto.setTotalActividades(Integer.parseInt(columna[3]));
            dto.setTotalPuntos(Integer.parseInt(columna[4]));
            dto.setPosicion(posicion++);
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}