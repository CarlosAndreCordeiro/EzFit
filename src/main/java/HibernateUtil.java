

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.jandex.Main;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
           
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
    public static void main(String args[]){
        
        HibernateUtil.getSessionFactory();
        
    }
}
