/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisiCliente;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author tss
 */
@Entity
public class DettaglioOrdine implements Serializable {

    public DettaglioOrdine(int quantita, Prodotto prodotto, Ordine ordine) {
        this.quantita = quantita;
        this.prodotto = prodotto;
        this.ordine = ordine;
    }

    public DettaglioOrdine() {
    }
    
    
    
    
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantita;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Prodotto prodotto;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Ordine ordine;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantità() {
        return quantita;
    }

    public void setQuantità(int quantità) {
        this.quantita = quantità;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final DettaglioOrdine other = (DettaglioOrdine) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DettaglioOrdine{" + "id=" + id + ", quantita=" + quantita + ", prodotto=" + prodotto.getNome() + ", ordine=" + ordine.getNumero() + '}';
    }

}
