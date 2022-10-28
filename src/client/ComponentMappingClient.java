package client;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Address;
import entity.Person;
import util.HibernateUtil;

public class ComponentMappingClient {

    public static void main(String[] args) {
        Session session = HibernateUtil.SessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        try{
            transaction.begin();
            Address address = new Address("4318 East Rosecrans Ave", "Compton", "90221");
            Person person = new Person("Matthew", address);

            session.save(person);
            transaction.commit();
        } catch (Exception e ){
            if(transaction!=null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            if(session!=null){
                session.close();
            }
        }
        System.exit(0);
    }
    
}
