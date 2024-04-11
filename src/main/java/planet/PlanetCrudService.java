package planet;

import client.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import storage.hibernate.HibernateUtils;

import java.util.Optional;

public class PlanetCrudService implements PlanetService{

    @Override
    public Optional<Planet> findById(String planetId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Planet planet = session.get(Planet.class, planetId);
            return Optional.ofNullable(planet);
            } catch (Exception ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public boolean createPlanet(Planet planet) {
        boolean flag = false;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.persist(planet);
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
    public boolean updatePlanet(Planet planet) {
        if (findById(planet.getId()).isEmpty()) {
            return false;
        }
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.merge(planet);
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
    public void deletePlanetById(String planetId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                Planet planet = findById(planetId).orElse(null);
                session.remove(planet);
                transaction.commit();
            } catch (Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
            }
        }
    }
}
