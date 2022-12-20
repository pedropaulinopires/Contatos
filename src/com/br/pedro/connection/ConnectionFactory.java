package com.br.pedro.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("contato");
    
    public static EntityManager getConnection(){
        return emf.createEntityManager();
    }
}
