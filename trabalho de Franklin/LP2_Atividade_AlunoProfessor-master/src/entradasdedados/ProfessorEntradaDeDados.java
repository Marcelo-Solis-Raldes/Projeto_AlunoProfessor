/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasdedados;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.AreaModel;
import modelo.ProfessorModel;
import dao.AreaDAO;
import java.util.List;
/**
 *
 * @author PHILCO
 */
public class ProfessorEntradaDeDados {
        
        AreaEntradaDeDados entradaArea = new AreaEntradaDeDados();
        AreaDAO daoArea = new AreaDAO();
        
        @SuppressWarnings("UnusedAssignment")
        public ProfessorModel entradaProfessor() throws SQLException {
         ProfessorModel professor = new ProfessorModel();
         
        List<AreaModel> listaDeArea = daoArea.buscarTodos();
        int id = Integer.parseInt(JOptionPane.showInputDialog("digite o id da area"));
        for (AreaModel area : listaDeArea) {
            
            if(area.getId()==id){
              professor.setArea(area);
            }
   
        }
        
        professor.setNome(JOptionPane.showInputDialog("Nome: "));
        professor.setSexo(JOptionPane.showInputDialog("Sexo: "));
        professor.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
         professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
        professor.setSiape(Integer.parseInt(JOptionPane.showInputDialog("Siape: ")));  
        
         

        return professor;
    }
        
        public String leituraCPF() {
        String cpf = JOptionPane.showInputDialog("Entre com o CPF: ");
        return cpf;
    }
        
        public String remover() throws SQLException {
        String cpf = JOptionPane.showInputDialog("Entre com o Cpf de quem deseja remover: ");
        return cpf;
    }
        
        public ProfessorModel editar(ProfessorModel professor ) throws SQLException {
            
        List<AreaModel> listaDeArea = daoArea.buscarTodos();
        int id = Integer.parseInt(JOptionPane.showInputDialog("digite o novo id da area"));
        for (AreaModel area : listaDeArea) {
            if(area.getId()==id){
                
              professor.setArea(area);
            }
   
        }
            
        professor.setNome(JOptionPane.showInputDialog("digite o nomvo nome do aluno"));
        professor.setSexo(JOptionPane.showInputDialog("digite o Sexo"));
        professor.setCpf(Long.parseLong(JOptionPane.showInputDialog("digite o novo CPF: ")));
        professor.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
        professor.setSiape(Integer.parseInt(JOptionPane.showInputDialog("RA: ")));
        return professor;
    }
}
