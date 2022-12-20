/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.pedro.model.bean.dao;

import com.br.pedro.connection.ConnectionFactory;
import com.br.pedro.model.bean.Contato;
import com.br.pedro.model.bean.Login;
import java.util.List;
import javax.persistence.EntityManager;

public class ContatoDAO {

    public static Contato inserirContato(Contato c) {
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return c;
    }

    public static Contato removerContato(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Contato c = null;
        try {
            c = em.find(Contato.class, id);
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return c;
    }

    public static Contato atualizarContato(Contato c) {
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return c;
    }

    public static Contato listarContato(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();
        Contato c = null;
        try {
            c = em.find(Contato.class, id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return c;
    }

    public static List<Contato> listarTodosContato() {
        EntityManager em = new ConnectionFactory().getConnection();
        List<Contato> c = null;
        try {
            c = em.createQuery("from Contato ").getResultList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return c;
    }

}
