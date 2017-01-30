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
public class App2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        creaCliente2("bennet", em);

        List<Cliente> clienti = em
                .createNamedQuery("Cliente.findByName", Cliente.class)
                .setParameter("ragsoc", "carrefour")
                .getResultList();

        if (clienti.isEmpty()) {
            
            System.out.println("nessun cliente trovato");
            
        }   

            for (Cliente cliente : clienti) {
                System.out.println(cliente);

            }

        
    }

    private static void creaCliente2(String ragsoc, EntityManager em) {
        Cliente cli = new Cliente(ragsoc);
        cli.setIndirizzo("via roma");

        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();

    }

}
