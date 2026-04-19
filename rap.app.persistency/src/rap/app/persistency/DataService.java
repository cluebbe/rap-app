package rap.app.persistency;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.eclipse.persistence.jpa.PersistenceProvider;
import rap.app.persistency.model.User;

public class DataService {

    private static final String PERSISTENCE_UNIT = "rap.app";
    private final EntityManagerFactory emf;

    public DataService() {
        Map<String, Object> props = new HashMap<>();
        props.put("eclipselink.classloader", DataService.class.getClassLoader());
        emf = new PersistenceProvider().createEntityManagerFactory(PERSISTENCE_UNIT, props);
        seed();
    }

    private void seed() {
        EntityManager em = emf.createEntityManager();
        try {
            long count = em.createQuery("SELECT COUNT(u) FROM User u", Long.class).getSingleResult();
            if (count == 0) {
                em.getTransaction().begin();
                em.persist(new User("admin", "secret", "admin"));
                em.persist(new User("user", "secret", "user"));
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }

    public List<User> fetchUsers() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u", User.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
