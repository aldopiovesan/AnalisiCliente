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
public class App3 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        creaCliente3("bennet", em);

        creaProdotti(em);
        
        creaOrdine(em);

        List<Cliente> clienti = em
                .createNamedQuery("Cliente.findByName", Cliente.class)
                .setParameter("ragsoc", "bennet")
                .getResultList();

        if (clienti.isEmpty()) {

            System.out.println("nessun cliente trovato");

        }

        for (Cliente cliente : clienti) {
            System.out.println(cliente);

        }

    }

    private static void creaCliente3(String ragsoc, EntityManager em) {
        Cliente cli = new Cliente(ragsoc);
        cli.setIndirizzo("via roma");

        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();

    }

    public static void creaOrdine(EntityManager em) {

        Cliente cli = em.find(Cliente.class, 1l);

        Ordine o = new Ordine();
        o.setNumero("A001");
        o.setDescrizione("ordine di prova");
        o.setCliente(cli);
        
        Prodotto pCoca= em.find(Prodotto.class, 2l);  //il numero 2 è l'id
        Prodotto pBarbera= em.find(Prodotto.class, 1l); //il numero 1 è l'id
        
        o.addDettaglio(new DettaglioOrdine(10, pCoca, o));
        o.addDettaglio(new DettaglioOrdine(1000, pBarbera, o));
        
        
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();

    }

    private static void creaProdotti(EntityManager em) {
        Prodotto p1 = new Prodotto();
        p1.setNome("cocacola");
        p1.setPrezzo(10);

        Prodotto p2 = new Prodotto();
        p2.setNome("barbera");
        p2.setPrezzo(15);

        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
    }

}
