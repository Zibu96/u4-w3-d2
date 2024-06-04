package giovannighirardelli;

import giovannighirardelli.dao.EventoDAO;
import giovannighirardelli.entities.Evento;
import giovannighirardelli.entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);

        Evento concerto = new Evento("Campovolo", LocalDate.of(2022, 06, 04), "Ligabue: 30 anni in un giorno", TipoEvento.PUBBLICO, 100000);
        Evento congresso = new Evento("Simposio di fisica quantistica", LocalDate.now(), "Il dottor Cooper presenta, divertiamoci con la teoria delle stringhe", TipoEvento.PRIVATO, 5);
//        ed.save(concerto);
//        ed.save(congresso);
//        try {
//            Evento evFromDb = ed.findById(2);
//            System.out.println(evFromDb.getTitolo());
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        try {
//            ed.findByIdAndDelete(1);
//
//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }


        em.close();
        emf.close();
    }

}
