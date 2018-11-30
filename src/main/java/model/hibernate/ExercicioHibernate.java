/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.hibernate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import model.Dao.ExercicioDao;
import model.Exercicio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



/**
 *
 * @author $Carlos Cordeiro <carloscordeiroconsultor@gmail.com>
 */

public class ExercicioHibernate implements ExercicioDao {

    private EntityManager em;
    private SessionFactory sessions;
    private static ExercicioHibernate instance = null;

    public static ExercicioHibernate getInstance() {

        if (instance == null) {
            instance = new ExercicioHibernate();
        }
        return instance;
    }

     private ExercicioHibernate() {

        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }
     
    @Override
    public void adiciona(Exercicio exercicio) {
    Session session = this.sessions.openSession();
    Transaction t = session.beginTransaction();
        try{
            session.persist(exercicio);
            session.flush();
            t.commit();
        }catch (Exception e){
            System.out.println("deu Erro ao Adicionar exercicio ");
            t.rollback();
        } finally{
            session.close();
        }
    }

    @Override
    public Exercicio recuperar(int codigo) {
    Session session = this.sessions.openSession();
        try {
            return (Exercicio) session.getSession().createQuery(
                    "From Exercicio Where codigo=" + codigo).getResultList().get(0);

        } finally {
            //Fechamos a sessão
            session.close();
        }    
    }

    @Override
    public void alterar(Exercicio exercicio) {
             Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.update(exercicio);
            t.commit();
        } catch (Exception e ) {
            System.out.println("deu merda ao alterar exercicio");
            t.rollback();

        } finally {
            session.close();
        }    
    }

    @Override
    public void deletar(Exercicio exercicio) {
         Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(exercicio);
            t.commit();
        } catch (Exception e ) {
            System.out.println("Deu erro ao deletar exercicio");
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public List recuperarTodos() {
     Session session = this.sessions.openSession();
        List<Exercicio> exercicios = new ArrayList();
        try {

            exercicios = session.createQuery("FROM Exercicio").list();
        } catch (Exception e) {
            System.out.println("deu Erro ao consultar lista de Exercícios");
        } finally {
            session.close();
        }
        return exercicios;

     }

    @Override
    public Exercicio recuperarNome(String nome) {
        Session session = this.sessions.openSession();
        try {

            return (Exercicio) session.getSession().createQuery("From Exercicio Where nome='" + nome+ "'").getResultList().get(0);
        } catch (Exception e) {

            System.out.println("CPF não encontrado!!");
            return null;

        } finally {
            //Fechamos a sessão
            session.close();
        }
    }
}



