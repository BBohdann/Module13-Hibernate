package ticket;

import client.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import planet.Planet;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at" , nullable = false,updatable = false)
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "client_id" , referencedColumnName = "id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "from_planet_id", referencedColumnName = "id")
    private Planet fromPlanet;

    @ManyToOne
    @JoinColumn(name = "to_planet_id", referencedColumnName = "id")
    private Planet toPlanet;
}
