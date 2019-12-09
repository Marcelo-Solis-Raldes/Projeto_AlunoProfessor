/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AlunoModel;

/**
 *
 * @author Frank
 */
public class AlunoDAO extends Conexao {

    public void salvarOuAtualizar(AlunoModel aluno){
        
        try {
            iniciar();
            getSessao().saveOrUpdate(aluno);
            fechar();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        }

    }

    public AlunoModel buscarPorCpf(long cpf)  {
        List<AlunoModel> lista = new ArrayList();
         try {
            iniciar();
            lista = getSessao().createQuery("from AlunoModel where cpf="+cpf).list();
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
    
    public AlunoModel buscarPorId(int id) {
        try {
            iniciar();
            AlunoModel aluno = (AlunoModel) getSessao().get(AlunoModel.class, id);
            fechar();
            return aluno;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return null;
    }
    
   public List<AlunoModel> buscarTodos() {
        List<AlunoModel> listaDeAluno = new ArrayList<>();
        try {
            iniciar();
            listaDeAluno = getSessao().createQuery("from AlunoModel").list();
            fechar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar: " + e.getMessage());
        }
        return listaDeAluno;
    }
   
        public void editar(AlunoModel aluno){
        
        try {
            iniciar();
            getSessao().saveOrUpdate(aluno);
            fechar();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e.getMessage());
        }

    }
    public void remover(AlunoModel aluno) {
        try {
            iniciar();
            getSessao().delete(aluno);
            fechar();
            JOptionPane.showMessageDialog(null, "Removido com sucesso !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage());
        }
    }

}
