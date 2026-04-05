package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.FavoritosDTO;
import pe.edu.pe.grupo2.entities.Favoritos;
import pe.edu.pe.grupo2.serviceinterfaces.IFavoritosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/favoritos")
public class FavoritosController {

    @Autowired
    private IFavoritosService fS;

    @PostMapping
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody FavoritosDTO dto) {
        ModelMapper m = new ModelMapper();
        Favoritos f = m.map(dto, Favoritos.class);
        fS.insert(f);
    }

    @GetMapping("/{id}")
    //@PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public FavoritosDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m=new ModelMapper();
        FavoritosDTO dto = m.map(fS.listId(id),FavoritosDTO.class);
        return dto;
    }

    @GetMapping
    //@PreAuthorize("hasAnyAuthority('USUARIO','ADMINISTRADOR')")
    public List<FavoritosDTO> listar() {
        return fS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,FavoritosDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id) {
        fS.delete(id);
    }

    @PutMapping
    //@PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void update(@RequestBody FavoritosDTO dto) {
        ModelMapper m = new ModelMapper();
        Favoritos f = m.map(dto, Favoritos.class);
        fS.update(f);
    }


}
