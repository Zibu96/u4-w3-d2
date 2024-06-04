package giovannighirardelli.dao;

import giovannighirardelli.entities.Evento;
import giovannighirardelli.exeptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {


    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("L'evento " + evento.getTitolo() + " è stato aggiunto con successo");
    }

    public Evento findById(long eventoId) {
        Evento evento = em.find(Evento.class, eventoId);
        if (evento == null) throw new NotFoundException(eventoId);
        return evento;
    }

    public void findByIdAndDelete(long eventoId) {
        Evento found = this.findById(eventoId);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getTitolo() + "è stato eliminato DEFINITIVAMENTE");

    }
}
