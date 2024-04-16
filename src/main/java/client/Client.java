package client;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;
import ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = "tickets")
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    @Size(min = 3)
    private String name;

    @OneToMany(mappedBy = "client" , cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();
}