package pe.edu.pe.grupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.grupo2.entities.Favoritos;
import pe.edu.pe.grupo2.repositories.IFavoritosRepository;
import pe.edu.pe.grupo2.serviceinterfaces.IFavoritosService;

import java.util.List;

@Service
public class IFavoritosServiceImplement implements IFavoritosService {

    @Autowired
    private IFavoritosRepository fR;

    @Override
    public void insert(Favoritos favoritos) { fR.save(favoritos); }

    @Override
    public List<Favoritos> list() {return fR.findAll();}

    @Override
    public Favoritos listId(int id) {return fR.findById(id).orElse(new Favoritos()); }

    @Override
    public void delete(int idFavoritos) {fR.deleteById(idFavoritos);}

    @Override
    public void update(Favoritos favoritos) { fR.save(favoritos); }

}
