package pe.edu.pe.grupo2.serviceinterfaces;

import pe.edu.pe.grupo2.entities.Noticias;

import java.util.List;

public interface INoticiasService {

    public List<Noticias> list();
    public void insert(Noticias n);
    public void update(Noticias n);
    public void delete(int id);
    public Noticias listId(int id);
    public List<Noticias> BuscarTitulo(String titulo);
}
