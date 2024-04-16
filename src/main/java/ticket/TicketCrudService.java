package ticket;

import org.hibernate.Session;
import org.hibernate.Transaction;
import planet.Planet;
import storage.hibernate.HibernateUtils;

import java.util.Optional;

public class TicketCrudService implements TicketService{

    @Override
    public boolean createTicket(Ticket ticket) {
        if (!isValidTicket(ticket)) return false;
        try(Session session = openSesion()){
            Transaction transaction = session.beginTransaction();
            try{
                session.persist(ticket);
                transaction.commit();
            }catch (Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateTicket(Ticket ticket) {
        if (!isValidTicket(ticket)) return false;
        try (Session session = openSesion()){
            Transaction transaction = session.beginTransaction();
            try{
                session.merge(ticket);
                transaction.commit();
            }catch (Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
                return false;
            }
        }
        return true;
    }

    @Override
    public Optional<Ticket> findById(Long ticketId) {
        try (Session session = openSesion()){
            return Optional.ofNullable(session.get(Ticket.class, ticketId));
        }catch (Exception ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteById(Long ticketId) {
        try (Session session = openSesion()) {
            Transaction transaction = session.beginTransaction();
            try {
                Optional<Ticket> ticket = findById(ticketId);
                session.remove(ticket.get());
                transaction.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
                return false;
            }
        }
        return true;
    }


    public Session openSesion(){
        return HibernateUtils.getInstance().getSessionFactory().openSession();
    }

    private static boolean isValidTicket(Ticket ticket) {
        if(ticket.getClient() == null || ticket.getFromPlanet() == null || ticket.getToPlanet() == null){
            System.out.println("Some of ticket columns is null!");
            return false;
        }
        return true;
    }
}
