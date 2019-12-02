package ansaltechblogapp.repositories;

import ansaltechblogapp.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class UserRepository {
    @PersistenceUnit(unitName = "ansaltechblog")
    EntityManagerFactory emf;

    public User registerUser(User user) {
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        try{
            et.begin();
            em.persist(user);
            et.commit();
            return user;
        }catch (Exception e){
            e.printStackTrace();
            et.rollback();
            return null;
        }
    }

    public User checkUser(User user) {

        try{
            EntityManager em=emf.createEntityManager();
            // Here uname and passwd are Named Parameters which can be set
            // Dynamically........ The symbol ':' is used to indicate named parameters
            // in a query
            TypedQuery<User> tq = em.createQuery("SELECT u FROM User u WHERE u.username=:uname" +
                    " and u.password=:passwd", User.class);
            tq.setParameter("uname",user.getUsername());
            tq.setParameter("passwd",user.getPassword());
            User registeredUser = tq.getSingleResult();
            return registeredUser;

        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
