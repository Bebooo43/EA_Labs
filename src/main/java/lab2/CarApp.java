package lab2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import lab2.utils.HibernateUtils;

import java.util.Arrays;

public class CarApp {

    public static final SessionFactory sessionFactory;

    static {
        sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Car.class));
    }

    public static void main(String[] args) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Car car = new Car("toyota", 2020, 18000.0);

        try {
            session.persist(car);
            tx.commit();
            Car c = session.get(Car.class, 1L);
            System.out.println(c);
        }catch (HibernateException ex){
            tx.rollback();
            ex.printStackTrace();
        }finally {
            session.close();
        }

        sessionFactory.close();
    }
}
