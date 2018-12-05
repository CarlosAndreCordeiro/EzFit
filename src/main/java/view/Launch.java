/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.Aluno;
import model.Exercicio;
import model.Treino;
import model.Hibernate.AlunoHibernate;
import model.Hibernate.ExercicioHibernate;
import model.Hibernate.ProfessorHibernate;
import model.Hibernate.TreinoHibernate;
import model.Professor;

/**
 *
 * @author $Carlos Cordeiro <carloscordeiroconsultor@gmail.com>
 */
public class Launch {
    
    public static void main (String args[]){
        
        Random gerador = new Random();
               
      
        List<Treino> treinos = new ArrayList<>();
        List<Exercicio> exercicios = new ArrayList<>();

        ExercicioHibernate eh = new ExercicioHibernate();
        TreinoHibernate th = new TreinoHibernate();
        AlunoHibernate ah = new AlunoHibernate();
        ProfessorHibernate ph = new ProfessorHibernate();
        
        Exercicio e = new Exercicio( "quebra peito"+ gerador.nextInt(1000), "descricao");
        Exercicio e2 = new Exercicio( "quebra custela"+ gerador.nextInt(1000), "descricao");
        eh.adiciona(e2);
        eh.adiciona(e);
        
        exercicios.add(e);
        exercicios.add(e2);
        
        
        Professor p = new Professor("cref", "cpf111", "nome", "endereco", "sexo", "mento", "email", "s");
        
        ph.adiciona(p);
        p=ph.recuperarCpf("cpf111");
        
        Aluno a = new Aluno("objetivo", 0, 0, null, "cpf222", "nome","endereco", "sexo", "ento"," email", "senha");
        ah.adiciona(a);
        a = ah.recuperarCpf("cpf222");
       
        
        Treino t = new Treino("treino1", "descricao", 0, p, "sid", exercicios, a);
        Treino t2 = new Treino("treino2", "descricao", 0, p, "sid", exercicios, a);
        
        th.adiciona(t);
        th.adiciona(t2);
        
        treinos.add(t);
        treinos.add(t2);
        
        a=ah.recuperarCpf("cpf222");
        a.setTreinos(treinos);
        ah.alterar(a);
             
        
           
           
        
        
     
        
    }
    
    

}
