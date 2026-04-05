package pe.edu.pe.grupo2.serviceinterfaces;

import pe.edu.pe.grupo2.entities.Favoritos;

import java.util.List;

public interface IFavoritosService {
    public void insert(Favoritos favoritos);
    public List<Favoritos> list();
    public Favoritos listId(int idFavoritos);
    public void delete(int idFavoritos);
    public void update(Favoritos favoritos);

}
