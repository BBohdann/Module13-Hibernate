package client;

import org.hibernate.Session;
import org.hibernate.Transaction;
import storage.hibernate.HibernateUtils;

import java.util.Optional;

public class ClientCrudService implements ClientService {

    @Override
    public Optional<Client> findById(Long clientId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Client client = session.get(Client.class, clientId);
            return Optional.ofNullable(client);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean createClient(Client client) {
        boolean flag = false;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
               session.persist(client);
               transaction.commit();
               flag = true;
            } catch (Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
            }
            return flag;
        }
    }

    @Override
    public boolean updateClient(Client client) {
        if (findById(client.getId()).isEmpty()) {
            return false;
        }
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(client);
                transaction.commit();
                return true;
            }catch (Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public void deleteClientById(Long clientId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Client client = findById(clientId).orElse(null);
                session.remove(client);
                transaction.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
            }
        }
    }
}
