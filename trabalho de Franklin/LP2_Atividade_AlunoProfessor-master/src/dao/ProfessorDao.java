
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ProfessorModel;
import modelo.AreaModel;
/**
 *
 * @author PHILCO
 */
public class ProfessorDao extends Conexao{
    
    public void salvarOuAtualizar(ProfessorModel professor){
        try{
            iniciar();
            getSessao().saveOrUpdate(professor);
            fechar();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
        } catch (Exception e){
            JOptionPane.showInternalMessageDialog(null, "Erro ao salvar: "+ e.getMessage());
        }
    }
    
     public ProfessorModel buscarPorCpf(long cpf)  {
         List<ProfessorModel> lista = new ArrayList();
         try {
            iniciar();
            lista = getSessao().createQuery("from ProfessorModel where cpf="+cpf).list();
            fechar();
            if(lista.isEmpty()){
                return null;
            }
            return lista.get(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return null;
    }
    
     public ProfessorModel buscarPorId(int id) {
        try {
            iniciar();
            ProfessorModel professor = (ProfessorModel) getSessao().get(ProfessorModel.class, id);
            fechar();
            return professor;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return null;
    } 
     
     public List<ProfessorModel> buscarTodos() {
        List<ProfessorModel> listaDeProfessor = new ArrayList<>();
        try {
            iniciar();
            listaDeProfessor = getSessao().createQuery("from ProfessorModel").list();
            fechar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return listaDeProfessor;
    }
     
     public void remover(ProfessorModel professor) {
        try {
            iniciar();
            getSessao().delete(professor);
            fechar();
            JOptionPane.showMessageDialog(null, "Removido com sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage());
        }
    }
}
