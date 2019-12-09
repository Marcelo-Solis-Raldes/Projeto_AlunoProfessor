
package entradasdedados;

import dao.AlunoDAO;
import dao.CursoDao;
import dao.ProfessorDao;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AlunoModel;
import modelo.CursoModel;
import modelo.ProfessorModel;

/**
 *
 * @author PHILCO
 */
public class CursoEntradaDeDados {
    ProfessorEntradaDeDados entradaProfessor = new ProfessorEntradaDeDados();
        ProfessorDao daoProfessor = new ProfessorDao();
    public CursoModel entradaCurso(){
        CursoModel curso = new CursoModel();
        curso.setDescricao(JOptionPane.showInputDialog("Digite a Descrição"));
        curso.setTitulo(JOptionPane.showInputDialog("digite o titulo"));
        curso.setLocal(JOptionPane.showInputDialog("digite o local do curso"));
        curso.setQuantidadeDeVagas(Integer.parseInt(JOptionPane.showInputDialog("quantidadeDeVagas: ")));
        return curso;
    }

    public CursoModel novaEntradaCurso(CursoModel curso){
        curso.setDescricao(JOptionPane.showInputDialog("Entre com a nova descrição do curso: "));
        
        return curso;
    }
    
    public CursoModel editar(CursoModel curso){
        curso.setDescricao(JOptionPane.showInputDialog("Entre com a nova descrição da Área: "));
        
        return curso;
    }
    
    public int informarID(String acao){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID de quem deseja "+acao+": "));
        
        return id;
    }
    public int informarIdDoCurso(String acao){
        int id = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID do curso que deseja "+acao+": "));
        
        return id;
    }
    
    public CursoModel IncluirProfessor(CursoModel curso){
        CursoDao daoCurso = new CursoDao();
         curso = daoCurso.buscarPorId(Integer.parseInt(JOptionPane.showInputDialog("Digite o Id do curso")));
         ProfessorModel professor = daoProfessor.buscarPorCpf(Long.parseLong(JOptionPane.showInputDialog("digite o cpf do professor")));
         curso.setProfessor(professor);
         daoCurso.salvarOuAtualizar(curso);
        
        return curso;
    }
    public CursoModel InserirAluno(CursoModel curso){
        AlunoDAO daoAluno = new AlunoDAO();
        CursoDao daoCurso = new CursoDao();
        curso = daoCurso.buscarPorId(Integer.parseInt(JOptionPane.showInputDialog("digite o nome do curso")));
        AlunoModel aluno = daoAluno.buscarPorCpf(Long.parseLong(JOptionPane.showInputDialog("digite o cpf do Aluno!!")));
        List<AlunoModel> lista = curso.getListaDeAlunos();
        lista.add(aluno);
        curso.setListaDeAlunos(lista);
        daoCurso.salvarOuAtualizar(curso);
        curso.setUltimoAlunoInserido(aluno);
        return curso;
    }
}
