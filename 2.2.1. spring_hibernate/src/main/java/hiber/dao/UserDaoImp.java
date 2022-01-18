package hiber.dao;


import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   public User getUserofCar(String model, int series) {
      Long id = getIdofCar(model,series);
      return sessionFactory.getCurrentSession().createQuery("from User where id=" + id, User.class).getSingleResult();

   }

   public Long getIdofCar(String model, int series) {
      return (Long) sessionFactory.getCurrentSession().createQuery("select id from Car where " +
              "model='" + model + "' and series=" + series).getSingleResult();
   }
}
