/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisiCliente;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tss
 */
public class App {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
        creaCliente("bennet", em);
        
        List<Cliente> clienti = em
                
                 .createNamedQuery("Cliente.all", Cliente.class)
                
                 .getResultList();
        
        for (Cliente cliente : clienti) {
            System.out.println(cliente);
            
        }
        
        
        
        
    }

    private static void creaCliente(String ragsoc, EntityManager em) {
      Cliente cli = new Cliente(ragsoc);
      cli.setIndirizzo("via roma");
      
      em.getTransaction().begin();
      em.persist(cli);
      em.getTransaction().commit();
      
    }
    
}
