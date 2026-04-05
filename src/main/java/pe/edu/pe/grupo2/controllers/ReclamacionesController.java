package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.MostClaimedRewardDTO;
import pe.edu.pe.grupo2.dtos.ReclamacionesDTO;
import pe.edu.pe.grupo2.dtos.RecompensasDTO;
import pe.edu.pe.grupo2.entities.Reclamaciones;
import pe.edu.pe.grupo2.serviceinterfaces.IReclamacionesService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reclamaciones")
public class ReclamacionesController {
    @Autowired
    private
    IReclamacionesService rs;

    @PostMapping
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody ReclamacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Reclamaciones r = m.map(dto, Reclamaciones.class);
        rs.insert(r);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public ReclamacionesDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        ReclamacionesDTO dto = m.map(rs.listId(id),ReclamacionesDTO.class);
        return dto;
    }

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public List<ReclamacionesDTO> listar() {
        return rs.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,ReclamacionesDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id) {
        rs.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody ReclamacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Reclamaciones r = m.map(dto, Reclamaciones.class);
        rs.update(r);
    }

     @GetMapping("/mas_reclamada")
    public List<MostClaimedRewardDTO> cantidad() {
        List<String[]> lista = rs.cantidadReclamaciones();
        List<MostClaimedRewardDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            MostClaimedRewardDTO dto = new MostClaimedRewardDTO();
            dto.setRecompensa(columna[0]);
            dto.setCantidadreclamos(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
