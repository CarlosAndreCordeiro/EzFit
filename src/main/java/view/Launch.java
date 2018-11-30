/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import model.Aluno;
import model.hibernate.AlunoHibernate;

/**
 *
 * @author $Carlos Cordeiro <carloscordeiroconsultor@gmail.com>
 */
public class Launch {
    
    public static void main (String args[]){
        
        AlunoHibernate ah = new AlunoHibernate();
        
        Aluno a = new Aluno("objetivo", 19, 40, null, "cpf2", "nome", "endereco", "M", "DATA", "email", "senha"  );
        
        ah.adiciona(a);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    

}
