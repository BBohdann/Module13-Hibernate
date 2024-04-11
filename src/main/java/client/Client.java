package client;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ticket.Ticket;

import java.util.List;

@Data
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    @Size(min = 3)
    private String name;
//
//    @OneToMany(mappedBy = "client")
//    private List<Ticket> tickets;
}