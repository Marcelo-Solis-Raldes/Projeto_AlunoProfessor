/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entradasdedados;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.AlunoModel;

public class AlunoEntradaDeDados {
    

        
      @SuppressWarnings("UnusedAssignment")  
    public AlunoModel entradaAluno() throws SQLException {
        
        AlunoModel aluno = new AlunoModel();
        aluno.setNome(JOptionPane.showInputDialog("Nome: "));
        aluno.setSexo(JOptionPane.showInputDialog("Sexo: "));
        aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog("CPF: ")));
        aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
        aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("RA: ")));        
        return aluno;
    }

    public String leituraCPF() {
        String cpf = JOptionPane.showInputDialog("Entre com o CPF: ");
        return cpf;
    }
    
    public String remover() throws SQLException {
        String cpf = JOptionPane.showInputDialog("Entre com o CPFde quem deseja remover: ");
        return cpf;
    }
    public AlunoModel editar(AlunoModel aluno) throws SQLException {
       
       aluno.setNome(JOptionPane.showInputDialog("digite o nomvo nome do aluno"));
       aluno.setSexo(JOptionPane.showInputDialog("digite o Sexo"));
       aluno.setCpf(Long.parseLong(JOptionPane.showInputDialog("digite o novo CPF: ")));
       aluno.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Idade: ")));
       aluno.setRa(Integer.parseInt(JOptionPane.showInputDialog("RA: ")));
       
       return aluno;
    }
}