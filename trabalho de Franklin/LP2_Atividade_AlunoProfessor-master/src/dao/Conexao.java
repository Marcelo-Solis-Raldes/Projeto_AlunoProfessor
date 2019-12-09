/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.NewHibernateUtil;

/**
 *
 * @author Frank
 */
public class Conexao {
    private Session sessao;
    private Transaction transaction;
    
    public Conexao(){
        this.sessao = NewHibernateUtil.getSessionFactory().openSession();
        this.transaction = this.sessao.beginTransaction();
    }
    
    public void iniciar(){
        if(!this.sessao.isOpen()){
            this.sessao = NewHibernateUtil.getSessionFactory().openSession();
        }
        if(!this.transaction.isActive()){
            this.transaction = this.sessao.beginTransaction();
        }
    }
    
    public void fechar(){
        this.sessao.getTransaction().commit();
        this.sessao.close();
    }
    
    public void encerrar(){
        NewHibernateUtil.getSessionFactory().close();
    }

    public Session getSessao() {
        return sessao;
    }

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    
    
}
