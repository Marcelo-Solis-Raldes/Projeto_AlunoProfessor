/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Marcelo 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "idpessoa")
public class AlunoModel extends PessoaModel implements Serializable{
    private int ra;

   @ManyToMany(mappedBy="listaDeAlunos", fetch = FetchType.LAZY)
   @Cascade(CascadeType.ALL)
    private List<CursoModel> listaDeCurso;
    
    public AlunoModel(String nome, int idade, long cpf, String sexo) {
        super(nome, idade, cpf, sexo);
    }

    public List<CursoModel> getListaDeCurso() {
        return listaDeCurso;
    }

    public void setListaDeCurso(List<CursoModel> listaDeCurso) {
        this.listaDeCurso = listaDeCurso;
    }
     
    public AlunoModel(){
        
    }

    @Override
    public String toString() {
        return "\nId: "+this.getIdpessoa()+"\nNome: "+this.getNome()+"\nSexo: "+this.getSexo()+
                "\nCpf: "+this.getCpf()+"\nRa: "+this.getRa()+"\n";
    }
    
    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }
    
}
