/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisiCliente;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *x creare integrita di dati devo usare entity
 * e aggiungere le librerie in dipendenze
 * @author tss
 */

@NamedQueries({
   @NamedQuery(name = "Cliente.all", 
               query = "select c from Cliente c order by c.ragionesociale DESC"),   //creo e salvo la query


   
   @NamedQuery(name = "Cliente.findByName", 
               query = "select c from Cliente c where c.ragionesociale= :ragsoc")   //creo e salvo la query
})

@Entity


public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //servem x creare chiave primaria in autoincrmento identity, fa riferimento a id
    private long id;
    
    
    private String ragionesociale;
    private String indirizzo;

    public Cliente() {
    }

    Cliente(String ragsoc) {
       this.ragionesociale=ragsoc;
    }
    
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRagionesociale() {
        return ragionesociale;
    }

    public void setRagionesociale(String ragionesociale) {
        this.ragionesociale = ragionesociale;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", ragionesociale=" + ragionesociale + ", indirizzo=" + indirizzo + '}';
    }

   
    

  
    
    
    
}
