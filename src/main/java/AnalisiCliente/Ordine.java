/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisiCliente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tss
 */
@Entity
public class Ordine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    
    @Column(nullable= false)
    private String numero;

    @Temporal(TemporalType.DATE)
    private Date il;

    private String descrizione;
    private boolean evaso;

    @ManyToOne(optional = false, cascade=CascadeType.PERSIST)  //significa che un cliente puo avere piu ordini tanti a uno 
    @JoinColumn(nullable=false)  
    private Cliente cliente;
    
    
    @OneToMany(mappedBy= "ordine", 
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval=true)
    private List<DettaglioOrdine> dettagli= new ArrayList<>();
    
    
    
    public Ordine(){
        this.il = new Date();
    }
    
    
    
    
    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getIl() {
        return il;
    }

    public void setIl(Date il) {
        this.il = il;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public boolean isEvaso() {
        return evaso;
    }

    public void setEvaso(boolean evaso) {
        this.evaso = evaso;
    }

    public List<DettaglioOrdine> getDettagli() {
        return dettagli;
    }

    public void setDettagli(List<DettaglioOrdine> dettagli) {
        this.dettagli = dettagli;
    }




    public void addDettaglio(DettaglioOrdine dett){
      dett.setOrdine(this);
      dettagli.add(dett);

}
    
    
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Ordine other = (Ordine) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
