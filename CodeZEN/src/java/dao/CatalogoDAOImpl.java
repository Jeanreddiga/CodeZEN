/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.util.List;
import model.Catalogo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author jcreddiga
 */
public class CatalogoDAOImpl implements CatalogoDAO {

      private static final SessionFactory sessionFactory = buildSessionFactory();
         
      public static SessionFactory buildSessionFactory(){
          try {
            return new Configuration().configure().buildSessionFactory(null);
          } catch (Throwable ex) {
             throw new ExceptionInInitializerError(ex);
          }
      }
         
      public static SessionFactory getSessionFactory() {
            return sessionFactory;
      }
      
    @Override
    public void adicionarCatalogo(Catalogo catalogo) {
        Transaction trns = null;
              Session session = getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(catalogo);
            session.getTransaction().commit();
        } catch (RuntimeException e) {            
            if (trns != null) trns.rollback();            
        } finally {
            session.flush();
            session.close();
        }
    }

    @Override
    public List<Catalogo> listarCatalogos() {
           return getSessionFactory().openSession().createCriteria(Catalogo.class).list();       
    }
    
}
