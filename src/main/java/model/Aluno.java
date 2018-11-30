/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author $Carlos Cordeiro <carloscordeiroconsultor@gmail.com>
 */
public class Aluno extends Pessoa {

    
    @Column(length = 50)
    private String objetivo;
    @Column 
    private double altura;
    @Column()
    private double peso;  
    @OneToMany (mappedBy = "aluno", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Treino> treinos;
   
    
    @Deprecated
    public Aluno(){
    }



    public Aluno(String objetivo, double altura, double peso, List<Treino> treinos, String cpf, String nome, String endereco, String sexo, String dataNascimento, String email, String senha) {
        super(cpf, nome, endereco, sexo, dataNascimento, email, senha);
        this.objetivo = objetivo;
        this.altura = altura;
        this.peso = peso;
        this.treinos = treinos;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.objetivo);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.altura) ^ (Double.doubleToLongBits(this.altura) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.treinos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        if (Double.doubleToLongBits(this.altura) != Double.doubleToLongBits(other.altura)) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.objetivo, other.objetivo)) {
            return false;
        }
        if (!Objects.equals(this.treinos, other.treinos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aluno{" + "objetivo=" + objetivo + ", altura=" + altura + ", peso=" + peso + ", treinos=" + treinos + '}';
    }
    
    
    
}
