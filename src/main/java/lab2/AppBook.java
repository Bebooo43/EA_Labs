package lab2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import lab2.utils.HibernateUtils;

import java.util.*;

public class AppBook {


    public static final SessionFactory sessionFactory;

    static {
        sessionFactory = HibernateUtils.getSessionFactory(Arrays.asList(Book.class));
    }

    public static void main(String[] args) {

        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;

        // 1
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            Book b1 = new Book("title1", "isbn1", "author1", 100.0, new GregorianCalendar(2020, Calendar.JULY, 10).getTime());
            Book b2 = new Book("title2", "isbn2", "author2", 200.0, new GregorianCalendar(2021, Calendar.JULY, 20).getTime());
            Book b3 = new Book("title3", "isbn3", "author3", 300.0, new GregorianCalendar(2022, Calendar.JULY, 22).getTime());
            session.persist(b1);
            session.persist(b2);
            session.persist(b3);

            tx.commit();
        }catch (HibernateException ex){
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

        //2
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            List<Book> booksList = session.createQuery("from Book", Book.class).list();
            for (Book b: booksList) {
                System.out.println(b);
            }

            tx.commit();
        }catch (HibernateException ex){
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

        //3
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // get book1
            Book b1 = session.get(Book.class, 1);
            b1.setTitle("titleMod");
            b1.setPrice(1000.0);
            // update book1
            session.saveOrUpdate(b1);

            //delete book2
            Book b2 = session.get(Book.class, 2);
            session.delete(b2);
            tx.commit();

        }catch (HibernateException ex){
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

        //4
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            List<Book> booksList = session.createQuery("from Book", Book.class).list();
            for (Book b: booksList) {
                System.out.println(b);
            }
            tx.commit();
        }catch (HibernateException ex){
            if (tx != null) {
                tx.rollback();
            }
            ex.printStackTrace();
        }finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
