/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19_02_lp2_alunoprofessor;

import entradasdedados.AlunoEntradaDeDados;
import dao.AlunoDAO;
import dao.AreaDAO;
import dao.CursoDao;
//import dao.CursoDao;
import dao.ProfessorDao;
import entradasdedados.AreaEntradaDeDados;
import entradasdedados.CursoEntradaDeDados;
import entradasdedados.ProfessorEntradaDeDados;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AlunoModel;
import modelo.AreaModel;
import modelo.CursoModel;
import modelo.ProfessorModel;

/**
 *
 * @author Frank
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("IncompatibleEquals")
    public static void main(String[] args) throws SQLException {
        AlunoEntradaDeDados entradaAluno = new AlunoEntradaDeDados();
        ProfessorEntradaDeDados entradaProfessor = new ProfessorEntradaDeDados();
        CursoEntradaDeDados entradaCurso = new CursoEntradaDeDados();
        AreaEntradaDeDados entradaArea = new AreaEntradaDeDados();
        ProfessorDao daoProfessor = new ProfessorDao();
        AlunoDAO daoAluno = new AlunoDAO();
        CursoDao daoCurso = new CursoDao();
        AreaDAO daoArea = new AreaDAO();
        AlunoModel alunoModel = new AlunoModel();
        ProfessorModel professorModel = new ProfessorModel();
        AreaModel areaModel = new AreaModel();
        CursoModel cursoModel = new CursoModel();
        String menu = "0- Sair\n1 - Aluno\n2 - Professor\n3 - Area\n4 - Curso\n5 - Inscrição!!!!";
        String menuAluno = "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Por CPF\n4 - Exibir Todos\n5 - Editar\n6 - Remover";
        String menuProfessor = "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Por CPF\n4 - Exibir Todos\n5 - Editar\n6 - Remover\n7 - Exibir professor com curso";
        String menuArea = "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Todos\n4 - Editar\n5 - Remover\n6 - Exibir Por ID";
        String menuCurso = "0- Sair\n1- Voltar\n2 - Salvar\n3 - Exibir Todos\n4 - Editar\n5 - Remover\n6 - Exibir Por ID";
        String menuInscricao = "0- Sair\n1- Voltar\n2 - incluir Professor\n3 - Inserir Aluno\n4 - mostrar Curso com Professor"
                + "\n5 - Mostrar lista de curso com professor\n6 - Mostrar o Aluno no Curso"
                + "\n7 - lista de Aluno";
        String cpf = null;
        String opt = "";
        do {
            opt = JOptionPane.showInputDialog(menu);
            switch (opt) {
                case "0":
                    break;
                case "1":
                    opt = JOptionPane.showInputDialog(menuAluno);
                    switch (opt) {
                        case "1":
                            
                            break;
                        case "2":
                            daoAluno.salvarOuAtualizar(entradaAluno.entradaAluno());
                            break;
                        case "3":
                            cpf = entradaAluno.leituraCPF();
                           AlunoModel alunoLista = daoAluno.buscarPorCpf(Long.parseLong(cpf));
                           if(alunoLista != null){
                           
                               JOptionPane.showMessageDialog(null, "Nome: " + alunoLista.getNome() + "\nSexo: " + alunoLista.getSexo()
                               +"\nCpf: "+alunoLista.getCpf()+"\nIdade: "+alunoLista.getIdade()+"\nRa: "+alunoLista.getRa());
                           }else{
                               JOptionPane.showMessageDialog(null, "Não foi encontrado o cpf!!!!!!");
                           }
                           
                            break;
                        case "4":
                            String lista = "\t\t\tAlunos\n";
                            List<AlunoModel> listaDeAluno = daoAluno.buscarTodos();
              
                            for(AlunoModel aluno : listaDeAluno){
                                String ler = "Nome: " + aluno.getNome()+"\nSexo: "+aluno.getSexo()
                                +"\nCpf: "+aluno.getCpf()+ "\nIdade: "+aluno.getIdade()+"\nRa: "+aluno.getRa()+"\n"+
                                "\n\t\t\t******************************\n";
                                 
                               lista += ler;
                            }
                           JOptionPane.showMessageDialog(null, lista);
                            break;
                        case "5":
                            cpf = JOptionPane.showInputDialog("digite o cpf");
                            AlunoModel aluno = daoAluno.buscarPorCpf(Long.parseLong(cpf));
                            if(aluno!=null){
                                daoAluno.salvarOuAtualizar(entradaAluno.editar(aluno));
                            }else{
                                JOptionPane.showMessageDialog(null, "Não foi encontrado o cpf!!!!!!");
                            }

                            break;
                        case "6":
                            cpf = entradaAluno.remover();
                            AlunoModel alunoRemover = daoAluno.buscarPorCpf(Long.parseLong(cpf));
                            if(alunoRemover == null){

                                JOptionPane.showMessageDialog(null, "Não foi encontrada  cpf !!!!!!"); 
                            }else{
                                daoAluno.remover(alunoRemover);
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                case "2":
                    opt = JOptionPane.showInputDialog(menuProfessor);
                    switch (opt) {
                        case "1":
                            
                            break;
                        case "2":
                           daoProfessor.salvarOuAtualizar(entradaProfessor.entradaProfessor());
                            break;
                        case "3":
                            cpf = entradaProfessor.leituraCPF();
                            ProfessorModel professorLista = daoProfessor.buscarPorCpf(Long.parseLong(cpf));
                            if(professorLista!=null){
                                JOptionPane.showMessageDialog(null, "Nome: "+professorLista.getNome()+
                               "\nSexo: "+professorLista.getSexo()+"\nCpf: "+professorLista.getCpf()+ 
                                "\nIdade: "+professorLista.getIdade()+
                                "\nSiape: "+professorLista.getSiape()+"\nArea: " + professorLista.getArea().getDescricao()); 
                            }else{
                                JOptionPane.showMessageDialog(null, "Não foi encontrado o cpf!!!!!!");
                            }
                            
                            break;
                        case "4":   
                             String lista = "\t\t\tProfessores\n";
                            List<ProfessorModel> listaDeProrfessor = daoProfessor.buscarTodos();
              
                            for(ProfessorModel professor : listaDeProrfessor){
                                String ler = "\nNome: " + professor.getNome()+"\nSexo: "+professor.getSexo()
                                +"\nCpf: "+professor.getCpf()+ "\nIdade: "+professor.getIdade()+"\nSiape: "+professor.getSiape()+
                                "\nArea: \n"+professor.getArea().getDescricao()+"\n\t\t\t******************************\n";
                               lista += ler;
                            }
                           JOptionPane.showMessageDialog(null, lista);
                            break;
                        case "5":
                            cpf = JOptionPane.showInputDialog("digite o cpf");
                            ProfessorModel professor = daoProfessor.buscarPorCpf(Long.parseLong(cpf));
                            if(professor!=null){
                                daoProfessor.salvarOuAtualizar(entradaProfessor.editar(professor));
                            }else{
                                JOptionPane.showMessageDialog(null, "Não foi encontrado o cpf!!!!!!");
                            }
                            break;
                        case "6":
                            cpf = entradaProfessor.remover();
                            ProfessorModel removerProfessor = daoProfessor.buscarPorCpf(Long.parseLong(cpf));
                            if(removerProfessor == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada  cpf !!!!!!");
                            }else{
                                daoProfessor.remover(removerProfessor);
                            }
                            break;
                        case "7":
                            CursoModel listaCurso = daoCurso.buscarPorId(entradaCurso.informarID("buscar"));
                            cpf = entradaProfessor.leituraCPF();
                            ProfessorModel listaProfessor = daoProfessor.buscarPorCpf(Long.parseLong(cpf));
                            if(listaProfessor!=null || listaCurso != null){
                                JOptionPane.showMessageDialog(null, "Nome: "+listaProfessor.getNome()+
                               "\nSexo: "+listaProfessor.getSexo()+"\nCpf: "+listaProfessor.getCpf()+ 
                                "\nIdade: "+listaProfessor.getIdade()+
                                "\nSiape: "+listaProfessor.getSiape()+"\nArea: " + listaProfessor.getArea().getDescricao()+
                                 "\nCurso: "+listaCurso.getDescricao()); 
                            }else{
                                JOptionPane.showMessageDialog(null, "Não foi encontrado o cpf!!!!!!");
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                case "3":
                    opt = JOptionPane.showInputDialog(menuArea);
                    switch (opt) {
                        case "0":
                            break;
                        case "1":
                            break;
                        case "2":
                            daoArea.salvarOuAtualizar(entradaArea.entradaArea());
                            break;
                        case "3":
                            String lista = "\t\t\tAreas\n";
                            List<AreaModel> listaDeArea = daoArea.buscarTodos();
                            for (AreaModel area : listaDeArea) {
                                String ler = "\nId: "+area.getId()+"\nDescrição da Area: \n" + area.getDescricao()+"\n\t\t\t******************************\n";
                               lista += ler;
                            }
                            JOptionPane.showMessageDialog(null, lista);
                            break;
                        case "4":
                            areaModel = daoArea.buscarPorId(entradaArea.informarID("Editar"));
                            if(areaModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                daoArea.salvarOuAtualizar(entradaArea.novaEntradaArea(areaModel));
                            }
                            break;
                        case "5":
                            areaModel = daoArea.buscarPorId(entradaArea.informarID("Remover"));
                            if(areaModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                daoArea.remover(areaModel);
                            }
                            break;
                        case "6":
                            areaModel = daoArea.buscarPorId(entradaArea.informarID("Buscar"));
                            if(areaModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                JOptionPane.showMessageDialog(null, "Descrição da Area: " + areaModel.getDescricao());
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                case "4":
                    opt = JOptionPane.showInputDialog(menuCurso);
                    switch (opt) {
                        case "0":
                            break;
                        case "1":
                            break;
                        case "2":
                            daoCurso.salvarOuAtualizar(entradaCurso.entradaCurso());
                            break;
                        case "3":
                             String lista = "\t\t\t*****Cursos*****\n";
                            List<CursoModel> listaDeCurso = daoCurso.buscarTodos();
                            for (CursoModel cursolist : listaDeCurso) {
                                String ler = "\nId: "+cursolist.getId()+"\nDescrição da Area: " + cursolist.getDescricao()+
                                "\nTitulo: "+cursolist.getTitulo()+"\nLocal: "+cursolist.getLocal()+
                                "\nQuantidade de Vagas: "+cursolist.getQuantidadeDeVagas()+"\n\t\t\t******************************\n";
                                lista +=ler;
                            }
                            JOptionPane.showMessageDialog(null, lista);
                            break;
                        case "4":
                            cursoModel = daoCurso.buscarPorId(entradaCurso.informarID("Editar"));
                            if(cursoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                               daoCurso.salvarOuAtualizar(entradaCurso.editar(cursoModel));
                            }
                            break;
                        case "5":
                            cursoModel = daoCurso.buscarPorId(entradaCurso.informarID("Remover"));
                            if(cursoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrada area com a ID informado");
                            }else{
                                daoCurso.remover(cursoModel);
                            }
                            break;
                        case "6":
                            cursoModel = daoCurso.buscarPorId(entradaCurso.informarID("Buscar"));
                            if(cursoModel == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrado Curso com a ID informado");
                            }else{
                                JOptionPane.showMessageDialog(null, "Descrição do Curso: " + cursoModel.getDescricao());
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                case "5":
                    opt = JOptionPane.showInputDialog(menuInscricao);
                    switch (opt) {
                        case "0":
                            break;
                        case "1":
                            break;
                        case "2":
                            CursoModel curso = new CursoModel();
                            curso = entradaCurso.IncluirProfessor(curso);
                            JOptionPane.showMessageDialog(null, "Id do curso: "+curso.getId()+"\nDescriçao do Curso: "+curso.getDescricao()+
                            "\nTitulo: "+curso.getTitulo()+"\nLocal: "+curso.getLocal()+"\nNome Do Professor: "+curso.getProfessor().getNome());
                            break;
                        case "3":
                            CursoModel cursoAluno = new CursoModel();
                            cursoAluno = entradaCurso.InserirAluno(cursoAluno);
                            JOptionPane.showMessageDialog(null, "Id do curso: "+cursoAluno.getId()+"\nCurso: "+cursoAluno.getDescricao()+
                            "\nTitulo: "+cursoAluno.getTitulo()+"\nLocal: "+cursoAluno.getLocal()+"\nAluno: "+cursoAluno.getUltimoAlunoInserido());
                        case "4":
                             cursoModel = daoCurso.buscarPorId(entradaCurso.informarIdDoCurso("buscar"));
                             if(cursoModel==null ){
                                 JOptionPane.showMessageDialog(null, "Não foi encontrado Curso com a ID informado");
                             }else{
                                 JOptionPane.showMessageDialog(null, "Id: "+cursoModel.getId()+"\nDescrição do Curso: " + cursoModel.getDescricao()+
                                 "\nProfessor: "+cursoModel.getProfessor().getNome()
                                 +"\nArea: "+cursoModel.getProfessor().getArea().getDescricao());
                             }
                            break;
                        case "5":
                            List<CursoModel> cursoList = daoCurso.buscarTodos();
                            String lista = "\t\t\tLista de Curso Com Professores\n";
                            for(CursoModel cur: cursoList){
                                 String exibir = " "+
                                "\n Id: "+cur.getId()+"\nCurso: " + cur.getDescricao()+
                                 "\nProfessor: "+cur.getProfessor().getNome()
                                 +"\nArea: "+cur.getProfessor().getArea().getDescricao()+
                                   "\n//////////////////////+++++++++++++++++//////////////\n";
                                 lista += exibir;
                             }
                             JOptionPane.showMessageDialog(null, lista);
                            break;
                        case "6":
                            cursoModel = daoCurso.buscarPorId(entradaCurso.informarIdDoCurso("buscar"));
                             if(cursoModel==null ){
                                 JOptionPane.showMessageDialog(null, "Não foi encontrado Curso com a ID informado");
                             }else{
                                 JOptionPane.showMessageDialog(null, "Id: "+cursoModel.getId()+"\nDescrição do Curso: " + cursoModel.getDescricao()+
                                 "\nTitulo: "+cursoModel.getTitulo()+"\nLocal: "+cursoModel.getLocal()+
                                 "\nAluno: "+cursoModel.getListaDeAlunos().toString());
                                  
                             }
                            break;
                        case "7":
                            CursoModel c = daoCurso.buscarPorId(entradaCurso.informarIdDoCurso("buscar"));
                            String list = "\t\t\tLista de Aluno Com curso";
                            if(c == null){
                                JOptionPane.showMessageDialog(null, "Não foi encontrado Curso com a ID informado");
                            }else{
                                String ler = "\nId: "+c.getId()+"\nDescrição: "+c.getDescricao()+
                                "\nTitulo: "+c.getTitulo()+"\nLocal: "+c.getLocal()+"\n\n"+
                                "\t\t\tAlunos: \n"+c.getListaDeAlunos();
                                list+=ler;
                            }
                            JOptionPane.showMessageDialog(null, list);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        } while (!opt.equals("0"));
        daoAluno.encerrar();
        daoProfessor.encerrar();
    }

}
