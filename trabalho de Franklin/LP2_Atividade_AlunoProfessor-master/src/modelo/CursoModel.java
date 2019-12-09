/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 *
 * @author PHILCO
 */
@Entity
@Table(name = "curso")
public class CursoModel implements Serializable{


     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     
     @Column(length = 40, nullable = false)
     private String titulo;
     
     @Column(length = 40, nullable = false)
     private String descricao;
     
     @Column(length = 40, nullable = false)
     private String local;
     
     @Column(length = 40, nullable = false)
     private int quantidadeDeVagas;
   
    @ManyToOne
     @JoinColumn(name = "professor_idpessoa")
     private ProfessorModel professor; 
    
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(name = "curso_aluno",
     joinColumns = @JoinColumn(name = "idCurso"),
     inverseJoinColumns = @JoinColumn(name = "idAluno"))
    
    private List<AlunoModel> listaDeAlunos ;

    @Transient
    private AlunoModel ultimoAlunoInserido;

    public AlunoModel getUltimoAlunoInserido() {
        return ultimoAlunoInserido;
    }

    public void setUltimoAlunoInserido(AlunoModel ultimoAlunoInserido) {
        this.ultimoAlunoInserido = ultimoAlunoInserido;
    }
    
    public ProfessorModel getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorModel professor) {
        this.professor = professor;
    }
    
    
        
    public List<AlunoModel> getListaDeAlunos() {
        return listaDeAlunos;
    }

    public void setListaDeAlunos(List<AlunoModel> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getQuantidadeDeVagas() {
        return quantidadeDeVagas;
    }

    public void setQuantidadeDeVagas(int quantidadeDeVagas) {
        this.quantidadeDeVagas = quantidadeDeVagas;
    }
    
}
