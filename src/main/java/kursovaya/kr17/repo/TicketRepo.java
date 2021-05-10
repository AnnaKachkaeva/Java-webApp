package kursovaya.kr17.repo;

import kursovaya.kr17.models.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepo extends CrudRepository<Ticket, Long> {
}
