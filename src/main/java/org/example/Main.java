package org.example;

import client.ClientCrudService;
import client.ClientService;
import planet.PlanetCrudService;
import planet.PlanetService;
import storage.flyway.DatabaseInit;
import ticket.Ticket;
import ticket.TicketCrudService;
import ticket.TicketService;
import java.time.LocalDate;

public class Main {
    public static ClientService clientService = new ClientCrudService();
    public static PlanetService planetService = new PlanetCrudService();
    public static TicketService ticketService = new TicketCrudService();

    public static void main(String[] args) {
        new DatabaseInit().initDb();
        ticketProcess();
    }

    public static void ticketProcess (){
        //Create ticket
        Ticket ticket = new Ticket();
        ticket.setCreatedAt(LocalDate.now());
        ticket.setFromPlanet(planetService.findById("P1").get());
        ticket.setToPlanet(planetService.findById("P2").get());
        ticket.setClient(clientService.findById(3L).get());

        ticketService.createTicket(ticket);

        //Update ticket
        ticket.setCreatedAt(LocalDate.now());
        ticket.setFromPlanet(planetService.findById("P3").get());
        ticket.setToPlanet(planetService.findById("P4").get());
        ticket.setClient(clientService.findById(8L).get());
        ticketService.updateTicket(ticket);

        //Find
        System.out.println("Ticket by ID = " + ticketService.findById(ticket.getId()));

        //Delete ticket
        ticketService.deleteById(ticket.getId());
    }
}