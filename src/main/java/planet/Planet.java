package planet;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;
import ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@ToString(exclude = {"fromTickets", "toTickets"})
@Table(name = "planet")
public class Planet {

    @Id
    @Column(name = "id", nullable = false)
    @Pattern(regexp = "^[A-Z0-9]*$")
    private String id;

    @Column(name = "name" , length = 500 ,nullable = false)
    private String name;

    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.ALL)
    private List<Ticket> fromTickets = new ArrayList<>();

    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.ALL)
    private List<Ticket> toTickets = new ArrayList<>();
}
