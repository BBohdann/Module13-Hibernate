package planet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @Column(name = "id", nullable = false)
    @Pattern(regexp = "^[A-Z0-9]*$")
    private String id;

    @Column(name = "name" , length = 500 ,nullable = false)
    private String name;

//    @OneToMany(mappedBy = "fromPlanet")
//    private List<Ticket> fromTickets;
//
//    @OneToMany(mappedBy = "toPlanet")
//    private List<Ticket> toTickets;
}
