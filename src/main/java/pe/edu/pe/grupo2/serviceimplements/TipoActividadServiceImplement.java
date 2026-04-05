package pe.edu.pe.grupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.TipoActividad;
import pe.edu.pe.grupo2.repositories.ITipoActividadRepository;
import pe.edu.pe.grupo2.serviceinterfaces.ITipoActividadService;

import java.util.List;

@Service
public class TipoActividadServiceImplement implements ITipoActividadService {
    @Autowired
    private ITipoActividadRepository tR;

    @Override
    public List<TipoActividad> list() {
        return tR.findAll();
    }

    @Override
    public TipoActividad listId(int id) {return tR.findById(id).orElse(new TipoActividad());}

    @Override
    public void update(TipoActividad tipoactividad) {
        tR.save(tipoactividad);
    }
    @Override
    public void delete(int id) {
        tR.deleteById(id);
    }
    @Override
    public void insert(TipoActividad tipoactividad) {
        tR.save(tipoactividad);
    }







}
