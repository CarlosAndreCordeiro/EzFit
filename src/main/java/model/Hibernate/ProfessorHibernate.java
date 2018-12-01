/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.Hibernate;

import java.util.ArrayList;
import java.util.List;
import model.DAO.ProfessorDao;
import model.Professor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author $Carlos Cordeiro <carloscordeiroconsultor@gmail.com>
 */


public class ProfessorHibernate implements ProfessorDao {

    private final SessionFactory sessions;
    private static ProfessorHibernate instance = null;

    public static ProfessorHibernate getInstance() {
        if (instance == null) {
            instance = new ProfessorHibernate();
        }
        return instance;
    }

    @Override
    public boolean logarProfessor(String login, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ProfessorHibernate() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void adiciona(Professor professor) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.persist(professor);
            session.flush();
            t.commit();
        } catch (Exception e) {
            System.out.println("Erro ao alterar Professor");
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Professor recuperar(int codigo) {
        Session session = this.sessions.openSession();
        try {
            return (Professor) session.getSession().createQuery("From Professor Where codigo=" + codigo).getResultList().get(0);
        } finally {
            //Fechamos a sessão
            session.close();
        }
    }

    @Override
    public void alterar(Professor professor) {

        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.update(professor);
            t.commit();
        } catch (Exception e) {
            System.out.println("Erro ao Alterar Professor");
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Professor professor) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(professor);
            t.commit();
        } catch (Exception e) {
            System.out.println("Erro ao deletar Professor");
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public List<Professor> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Professor> professores = new ArrayList();
        try {

            professores = (List) session.createQuery("FROM Professor").list();
        } catch (Exception e) {
            System.out.println("deu Erro ao consultar lista de professores");
        } finally {
            session.close();
        }
        return professores;

    }

    @Override
    public Professor recuperarCpf(String cpf) {
        Session session = this.sessions.openSession();
        try {

            return (Professor) session.getSession().createQuery("From Professor Where cpf='" + cpf + "'").getResultList().get(0);
        } catch (Exception e) {

            System.out.println("CPF não encontrado!!");
            return null;

        } finally {
            //Fechamos a sessão
            session.close();

        }
    }
}
