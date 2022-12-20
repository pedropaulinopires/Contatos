package com.br.pedro.model.bean.dao;

import com.br.pedro.connection.ConnectionFactory;
import com.br.pedro.model.bean.Login;
import java.util.List;
import javax.persistence.EntityManager;

public class LoginDAO {
    
    public static Login inserirLogin(Login l){
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return l;
    }
    
    public static Login removerLogin(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Login l = null;
        try {
            l = em.find(Login.class, id);
            em.getTransaction().begin();
            em.remove(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return l;
    }
    
    public static Login atualizarLogin(Login l){
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            em.merge(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return l;
    }
    
    public static Login listarLogin(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Login l = null;
        try {
            l = em.find(Login.class, id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return l;
    }
    
     public static List<Login> listarTodosLogin(){
        EntityManager em = new ConnectionFactory().getConnection();
        List<Login> l = null;
        try {
            l = em.createQuery("from Login ").getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return l;
    }
}
