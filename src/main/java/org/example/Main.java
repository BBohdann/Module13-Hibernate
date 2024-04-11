package org.example;

import client.Client;
import client.ClientCrudService;
import client.ClientService;
import planet.Planet;
import planet.PlanetCrudService;
import planet.PlanetService;
import storage.flyway.DatabaseInit;

public class Main {
    public static ClientService clientService = new ClientCrudService();
    public static PlanetService planetService = new PlanetCrudService();


    public static void main(String[] args) {
        new DatabaseInit().initDb();
        clientProcess();

        planetProcess();
    }

    private static void planetProcess() {
        Planet planet = new Planet();
        planet.setId("EARTH");
        planet.setName("C137");

        //Create planet
        planetService.createPlanet(planet);

        //Update planet
        planet.setId(planet.getId());
        planet.setName("My own planet");

        //Find
        planetService.findById(planet.getId());

        //Delete planet
        planetService.deletePlanetById(planet.getId());

        //Find
        System.out.println("Planet by id = " + planetService.findById(planet.getId()).orElse(null));
    }

    private static void clientProcess() {
        Client client = new Client();
        client.setName("Taras");

        //Create client
        clientService.createClient(client);

        //Update client
        client.setId(client.getId());
        client.setName("Rick Marcun");
        clientService.updateClient(client);

        //Find client
        System.out.println("Client by ID = " + clientService.findById(client.getId()).orElse(null));

        //Delete client
        clientService.deleteClientById(client.getId());

        //Find client
        System.out.println("Client by ID = " + clientService.findById(client.getId()).orElse(null));
    }
}