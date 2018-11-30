/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.hibernate;

import model.Dao.TreinoDao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import model.Treino;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author $Carlos Cordeiro <carloscordeiroconsultor@gmail.com>
 */

public class TreinoHibernate implements TreinoDao {

    private EntityManager em;
    private SessionFactory sessions;
    private static TreinoHibernate instance = null;

    public static TreinoHibernate getInstance() {

        if (instance == null) {
            instance = new TreinoHibernate();
        }

        return instance;
    }

    private TreinoHibernate() {

        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void adiciona(Treino treino) {

        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.persist(treino);
            t.commit();
        } catch (Exception e) {
            System.out.println("erro ao adicionar Treino");
            t.rollback();

        } finally {
            session.close();
        }

    }

    @Override
    public Treino recuperar(int codigo) {
        Session session = this.sessions.openSession();
        try {

            return (Treino) session.getSession().createQuery("From Treino Where codigo=" + codigo).getResultList().get(0);

        } finally {
            //Fechamos a sessão
            session.close();
        }
    }

    @Override
    public void alterar(Treino treino) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.update(treino);
            t.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Treino treino) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(treino);
            t.commit();
        } catch (Exception e) {
            System.out.println("erro ao deletar Treino");
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Treino> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Treino> treinos = new ArrayList();

        try {
            treinos = session.createQuery("FROM Treino").list();
        } catch (Exception e) {
            System.out.println("Erro ao Recuperar Treinos");

        } finally {
            session.close();
        }

        return treinos;
    }

    @Override
    public Treino recuperarNome(String nome) {
        Session session = this.sessions.openSession();
        try {

            return (Treino) session.getSession().createQuery("From Treino Where nome='" + nome+ "'").getResultList().get(0);
        } catch (Exception e) {

            System.out.println("Nome do treino não encontrado!!");
            return null;

        } finally {
            //Fechamos a sessão
            session.close();
        }
    }
}
