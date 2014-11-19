/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.edu.mouralacerda.futeboldahora.dao;


import br.com.edu.mouralacerda.futeboldahora.modelo.Times;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class TimesDao {
    final EntityManagerFactory factory = Persistence.createEntityManagerFactory("conexao");
    final EntityManager em = factory.createEntityManager();    
    
    public void salvar(Times time){
        em.getTransaction().begin();
        em.persist(time);
        em.getTransaction().commit();
    }
    public Times consultarPessoa(Integer id){
        Times time = em.find(Times.class, id);
        return time;
    }
    
    public List<Times> consultarLista(){
        
        TypedQuery<Times> query = em.createQuery("select time from Times time", Times.class);
        List<Times> time = query.getResultList();
        return time;
    }
}
