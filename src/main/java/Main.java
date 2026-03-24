import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseConfig");
        EntityManager em = emf.createEntityManager();

        try{
            SetUp.setUpData(em);
            Queries.runQueries(em);
        } finally {
        em.close();

        }
    }
}
