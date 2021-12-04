package net.pro.metier;

import java.util.Objects;

public class Commande {
    private String reference;
    private String date;
    private String etat;
    //private Client client;

    public Commande(String reference, String date, String etat/*, Client client*/) {
        this.reference = reference;
        this.date = date;
        this.etat = etat;
       // this.client = client;
    }

    @Override
    public String toString() {
        return "{" +
                "reference='" + reference + '\'' +
                ", date='" + date + '\'' +
                ", etat='" + etat + '\'' +
                /*", client=" + this.client.toString()*/ +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commande commande = (Commande) o;
        return Objects.equals(reference, commande.reference) && Objects.equals(date, commande.date) && Objects.equals(etat, commande.etat) /*&& this.client.equals(((Commande) o).client)*/;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
    /*
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

     */
}
