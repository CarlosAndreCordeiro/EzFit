package model.Hibernate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Aluno;
import model.DAO.AlunoDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AlunoHibernate implements AlunoDao {

    private EntityManager em;
    private SessionFactory sessions;
    private static AlunoHibernate instance = null;

    public static AlunoHibernate getInstance() {

        if (instance == null) {
            instance = new AlunoHibernate();
        }

        return instance;
    }

    @Override
    public boolean logarAluno(String login, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public AlunoHibernate() {

        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void adiciona(Aluno aluno) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.persist(aluno);
            session.flush();
            t.commit();
        } catch (Exception e) {
            System.out.println("Erro ao adicionar o aluno!!");
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Aluno recuperar(int codigo) {
        Session session = this.sessions.openSession();
        try {

            return (Aluno) session.getSession().createQuery("From Aluno Where codigo=" + codigo).getResultList().get(0);
        }catch(Exception e){
            System.out.println("Erro ao recuperar aluno pelo codigo!!");
            return null;
        } finally {
            //Fechamos a sessão
            session.close();
        }
    }

    @Override
    public void alterar(Aluno aluno) {

        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.update(aluno);
            session.flush();
            t.commit();
        } catch (Exception e) {
            System.out.println("Erro ao alterar o aluno!!");
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Aluno aluno) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(aluno);
            t.commit();
        } catch (Exception e) {
            System.out.println("Erro ao deletar o Aluno");
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public List<Aluno> recuperarTodos() {
        Session session = this.sessions.openSession();
        List<Aluno> alunos = new ArrayList();
        try {

            alunos = session.createQuery("FROM Aluno").list();
        } catch (Exception e) {
            System.out.println("Erro ao recuperar a lista de alunos");
        } finally {
            session.close();
        }

        return alunos;

    }

    @Override
    public Aluno recuperarCpf(String cpf) {
        Session session = this.sessions.openSession();
        try {

            return (Aluno) session.getSession().createQuery("From Aluno Where cpf='" + cpf + "'").getResultList().get(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("CPF do aluno não encontrado!!");
            return null;

        } finally {
            //Fechamos a sessão
            session.close();
        }
    }
}
