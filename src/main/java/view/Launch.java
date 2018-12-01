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
        
        Exercicio e = new Exercicio( "quebra cu"+ gerador.nextInt(1000), "descricao");
        
       exercicios.add(e);
        eh.adiciona(e);      
       
          
           
        
        
        
        
        Aluno a = new Aluno("objetivo", 0, 0,treinos , "cpf" + gerador.nextInt(1000)," nome", "endereco", "sexo", "00"," email", "senha");
             ah.adiciona(a); 
        Professor p = new Professor("cref", "cpf" + gerador.nextInt(1000), "nome", "endereco", "sexo", "22/02/2018", "email", "senha");
           ph.adiciona(p);    
        Treino t = new Treino("nome do treino", "descricaodo treino", 10, p, "intensidade", exercicios, a);
         th.adiciona(t);   
        
        
      
        
        
     
        
    }
    
    

}
