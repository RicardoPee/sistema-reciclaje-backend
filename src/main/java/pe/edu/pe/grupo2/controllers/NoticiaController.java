package pe.edu.pe.grupo2.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.grupo2.dtos.NoticiasDTO;
import pe.edu.pe.grupo2.entities.Noticias;
import pe.edu.pe.grupo2.serviceinterfaces.INoticiasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/noticias")
//@CrossOrigin(origins = "https://proud-radiance-production.up.railway.app")
public class NoticiaController {
    @Autowired
    private INoticiasService nR;

    @GetMapping
    public List<NoticiasDTO> listar() {
        return nR.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            NoticiasDTO dto = m.map(x, NoticiasDTO.class);
            dto.setCentroReciclaje(x.getCentroReciclaje()); // mapeo manual
            return dto;
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody NoticiasDTO dto) {
        ModelMapper m = new ModelMapper();
        Noticias noticia = m.map(dto, Noticias.class);
        noticia.setCentroReciclaje(dto.getCentroReciclaje()); // mapeo manual
        nR.insert(noticia);

        // Indicar cuántas notificaciones se enviaron (en la respuesta)
        if (dto.getCentroReciclaje() != null) {
            return ResponseEntity.ok("Noticia publicada. Notificaciones enviadas automáticamente a clientes del centro.");
        }
        return ResponseEntity.ok("Noticia publicada correctamente.");
    }

    @GetMapping("/{id}")
    public NoticiasDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        Noticias x = nR.listId(id);
        NoticiasDTO dto = m.map(x, NoticiasDTO.class);
        dto.setCentroReciclaje(x.getCentroReciclaje());
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody NoticiasDTO dto) {
        ModelMapper m = new ModelMapper();
        Noticias noticia = m.map(dto, Noticias.class);
        noticia.setCentroReciclaje(dto.getCentroReciclaje());
        nR.update(noticia);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        nR.delete(id);
    }

    @GetMapping("/busqueda de Noticia")
    public List<NoticiasDTO> buscar(@RequestParam String titulo) {
        return nR.BuscarTitulo(titulo).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NoticiasDTO.class);
        }).collect(Collectors.toList());
    }
}
