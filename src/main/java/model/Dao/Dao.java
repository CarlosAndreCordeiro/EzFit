/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Dao;

import java.util.List;

/**
 *
  * @author $Carlos Cordeiro <carloscordeiroconsultor@gmail.com>
 */
import java.util.List;

interface DaoGenerico<T> {
    
    public void adiciona (T t);
    public T recuperar (int codigo);
    public void alterar (T t);
    public void deletar (T t);
    public List recuperarTodos();
    
    
}