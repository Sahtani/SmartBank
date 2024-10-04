//import com.youcode.smartbank.entities.Request;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import java.util.Date;
//
//public class Main {
//    public static void main(String[] args) {
//        // Création de l'EntityManagerFactory
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("creditApp");
//
//        // Création de l'EntityManager
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            // Démarrer une transaction
//            em.getTransaction().begin();
//
//            // Création d'une nouvelle demande
//            Request request = new Request();
//            request.setProject("Projet de Test");
//            request.setStatus("En attente");
//            request.setAmount(15000.00);
//            request.setDuration(12);
//            request.setMonthlyPayment(1250.00);
//            request.setEmail("example@test.com");
//            request.setPhone("0123456789");
//            request.setTitle("Monsieur");
//            request.setLastName("Dupont");
//            request.setFirstName("Jean");
//            request.setIdNumber("ID123456");
//            request.setDateOfBirth(new Date(90, 1, 1)); // Date de naissance fictive
//            request.setEmploymentStartDate(new Date(120, 1, 1)); // Date de début d'emploi fictive
//            request.setMonthlyIncome(3000.00);
//            request.setHasExistingLoans(false);
//
//            // Persister la demande (ajouter à la base de données)
//            em.persist(request);
//
//            // Valider la transaction
//            em.getTransaction().commit();
//
//            System.out.println("Demande créée avec succès!");
//        } catch (Exception e) {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback(); // Rollback en cas d'erreur
//            }
//            e.printStackTrace();
//        } finally {
//            // Fermer l'EntityManager et l'EntityManagerFactory
//            em.close();
//            emf.close();
//        }
//    }
//}
