
package dao;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AreaModel;

/**
 *
 * @author Frank
 */
public class AreaDAO extends Conexao {

    public void salvarOuAtualizar(AreaModel area) {
        try {
            iniciar();
            getSessao().saveOrUpdate(area);
            fechar();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        }
    }
    
    public AreaModel buscarPorId(int id) {
        try {
            iniciar();
            AreaModel area = (AreaModel) getSessao().get(AreaModel.class, id);
            fechar();
            return area;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return null;
    }
    
    public List<AreaModel> buscarTodos() {
        List<AreaModel> listaDeArea = new ArrayList<>();
        try {
            iniciar();
            listaDeArea = getSessao().createQuery("from AreaModel").list();
            fechar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return listaDeArea;
    }
    
    public void remover(AreaModel area) {
        try {
            iniciar();
            getSessao().delete(area);
            fechar();
            JOptionPane.showMessageDialog(null, "Removido com sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage());
        }
    }

}
