package ticket;

import java.util.Optional;

public interface TicketService {
    boolean createTicket(Ticket ticket);
    boolean updateTicket(Ticket ticket);
    Optional<Ticket> findById(Long ticketId);
    boolean deleteById(Long ticketId);
}
