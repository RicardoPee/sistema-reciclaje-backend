package pe.edu.pe.grupo2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.pe.grupo2.entities.Noticias;
import pe.edu.pe.grupo2.entities.Notificaciones;
import pe.edu.pe.grupo2.entities.User;
import pe.edu.pe.grupo2.repositories.IFavoritosRepository;
import pe.edu.pe.grupo2.repositories.INoticiasRepository;
import pe.edu.pe.grupo2.repositories.INotificacionesRepository;
import pe.edu.pe.grupo2.serviceinterfaces.INoticiasService;

import java.time.LocalDate;
import java.util.List;

@Service
public class NoticiasServiceImplements implements INoticiasService {

    @Autowired
    private INoticiasRepository nR;

    @Autowired
    private IFavoritosRepository fR;

    @Autowired
    private INotificacionesRepository notifR;

    @Override
    public List<Noticias> list() {
        return nR.findAll();
    }

    @Override
    @Transactional
    public void insert(Noticias n) {
        nR.save(n);

        // AUTOMATIZACIÓN: Si la noticia tiene un centro asociado,
        // notificar automáticamente a todos los usuarios que lo tienen en favoritos
        if (n.getCentroReciclaje() != null) {
            int idCentro = n.getCentroReciclaje().getIdCentroReciclaje();
            List<User> usuariosFavorito = fR.findUsuariosByCentro(idCentro);

            if (!usuariosFavorito.isEmpty()) {
                String mensajeAuto = "📢 Nueva noticia en tu centro favorito: '" + n.getTitulo() + "' — " + n.getInformacion();
                for (User usuario : usuariosFavorito) {
                    Notificaciones notif = new Notificaciones(
                        mensajeAuto,
                        LocalDate.now(),
                        usuario,
                        n
                    );
                    notifR.save(notif);
                }
            }
        }
    }

    @Override
    public void update(Noticias n) {
        nR.save(n);
    }

    @Override
    public void delete(int id) {
        nR.deleteById(id);
    }

    @Override
    public Noticias listId(int id) {
        return nR.findById(id).orElse(new Noticias());
    }

    @Override
    public List<Noticias> BuscarTitulo(String titulo) {
        return nR.BuscarTitulo(titulo);
    }
}
