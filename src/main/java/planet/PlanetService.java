package planet;

import client.Client;

import java.util.Optional;

public interface PlanetService {
    Optional<Planet> findById(String  planetId);

    boolean createPlanet(Planet planet);

    boolean updatePlanet(Planet planet);

    void deletePlanetById (String  planetId);
}
