package pe.edu.pe.grupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.CentroReciclaje;
import pe.edu.pe.grupo2.repositories.ICentroReciclajeRepository;
import pe.edu.pe.grupo2.serviceinterfaces.ICentroReciclajeService;

import java.util.List;

@Service
public class CentroReciclajeServiceImplement implements ICentroReciclajeService {

    @Autowired
    private ICentroReciclajeRepository cR;

    @Override
    public void insert(CentroReciclaje centroReciclaje) { cR.save(centroReciclaje); }

    @Override
    public List<CentroReciclaje> list() { return cR.findAll();}

    @Override
    public CentroReciclaje listId(int id){return cR.findById(id).orElse(new CentroReciclaje());}

    @Override
    public void delete(int idCentroReciclaje) { cR.deleteById(idCentroReciclaje); }

    @Override
    public void update(CentroReciclaje centroReciclaje) { cR.save(centroReciclaje); }


    @Override
    public List<String[]> centroFavoritos() { return cR.centroFavoritos(); }

    @Override
    public List<String[]> centroUsuarios() { return cR.centroUsuarios(); }
}

