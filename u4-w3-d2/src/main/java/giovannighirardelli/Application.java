package giovannighirardelli;

import giovannighirardelli.dao.EventoDAO;
import giovannighirardelli.entities.Evento;
import giovannighirardelli.entities.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Come si chiama il tuo evento?");
        String elem1 = scanner.nextLine();
        System.out.println("Che giorno ci sarà? (dd)");
        int int1 = Integer.parseInt(scanner.nextLine());
        System.out.println("E in che mese? (mm)");
        int int2 = Integer.parseInt(scanner.nextLine());
        System.out.println("E invece l'anno? (yyyy)");
        int int3 = Integer.parseInt(scanner.nextLine());
        System.out.println("Descrivi un po' il tuo evento");
        String elem2 = scanner.nextLine();
        System.out.println("L'evento sarà pubblico o privato?");
        TipoEvento tipoEvento = TipoEvento.valueOf(scanner.nextLine());
        System.out.println("Quanta gente vorresti che venisse?");
        int numPep = Integer.parseInt(scanner.nextLine());

        Evento creaEv = new Evento(elem1, LocalDate.of(int3, int2, int1), elem2, tipoEvento, numPep);

        ed.save(creaEv);

        scanner.close();


        em.close();
        emf.close();
    }

}
