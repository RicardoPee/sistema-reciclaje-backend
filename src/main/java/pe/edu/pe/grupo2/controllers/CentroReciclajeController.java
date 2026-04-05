package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.ActividadCentroDTO;
import pe.edu.pe.grupo2.dtos.CenterFavoriteDTO;
import pe.edu.pe.grupo2.dtos.CenterUsersDTO;
import pe.edu.pe.grupo2.dtos.CentroReciclajeDTO;
import pe.edu.pe.grupo2.entities.CentroReciclaje;
import pe.edu.pe.grupo2.serviceinterfaces.ICentroReciclajeService;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/centroreciclaje")
//@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")
public class CentroReciclajeController {

    @Autowired
    private ICentroReciclajeService cS;

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public List<CentroReciclajeDTO> listarCentroReciclaje() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CentroReciclajeDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody CentroReciclajeDTO dto) {
        ModelMapper m = new ModelMapper();
        CentroReciclaje d = m.map(dto, CentroReciclaje.class);
        cS.insert(d);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id) {
        cS.delete(id);
    }

    @PutMapping
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody CentroReciclajeDTO dto) {
        ModelMapper m = new ModelMapper();
        CentroReciclaje d = m.map(dto, CentroReciclaje.class);
        cS.update(d);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public CentroReciclajeDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        CentroReciclajeDTO dto = m.map(cS.listId(id), CentroReciclajeDTO.class);
        return dto;
    }


    @GetMapping("/mas-usuarios")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<CenterUsersDTO> centroMasUsuarios() {
        List<String[]> lista = cS.centroUsuarios();
        List<CenterUsersDTO> listaDTO = new ArrayList<>();
        for (String[] columna:lista) {
            CenterUsersDTO dto = new CenterUsersDTO();
            dto.setDireccion(columna[0]);
            dto.setUsername(columna[1]);
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/mas_popular")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<CenterFavoriteDTO> centroMasFavoritos() {
        List<String[]> lista = cS.centroFavoritos();
        List<CenterFavoriteDTO> listaDTO = new ArrayList<>();
        for (String[] columna:lista) {
            CenterFavoriteDTO dto = new CenterFavoriteDTO();
            dto.setDireccion(columna[0]);
            dto.setCantidadFavoritos(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
