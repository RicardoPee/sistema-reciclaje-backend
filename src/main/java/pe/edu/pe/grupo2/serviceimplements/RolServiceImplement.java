package pe.edu.pe.grupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.Rol;
import pe.edu.pe.grupo2.repositories.IRolRepository;
import pe.edu.pe.grupo2.serviceinterfaces.IRolService;

import java.time.LocalDate;
import java.util.List;

@Service
public class RolServiceImplement implements IRolService {

    @Autowired
    private IRolRepository rR;

    @Override
    public void insert(Rol rol) { rR.save(rol); }

    @Override
    public List<Rol> list() { return rR.findAll();}

    @Override
    public Rol listId(int id){return rR.findById(id).orElse(new Rol());}

    @Override
    public void delete(int idRol) { rR.deleteById(idRol); }

    @Override
    public void update(Rol rol) { rR.save(rol); }

    @Override
    public List<String[]> cantidadUsuariosPorRol() {
        return rR.cantidadUsuariosPorRol();
    }
}
