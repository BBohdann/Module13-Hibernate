package client;

import java.util.Optional;

public interface ClientService {
    Optional<Client> findById(Long clientId);

    boolean createClient(Client client);

    boolean updateClient(Client client);

    void deleteClientById (Long clientId);
}
