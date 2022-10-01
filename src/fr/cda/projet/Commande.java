package fr.cda.projet;

import java.util.*;

/**
 * Definition de la classe Commande
 */

public class Commande {
    /**
     * Attributs de la classe Commande
     */
    private int numero;                         // numero de la commande
    private String date;                        // date de la commande (format JJ/MM/AAAA)
    private String client;                      // nom et prenom du client
    private String reference;                   // reference de la commande (format produit=quantite)
    private int quantite;                       // quantite de produit de la commande
    private ArrayList<String> references;       // tableau de toutes les references


    /**
     * Constructeur de la classe Commande
     */

    Commande(int numero, String date, String client, String ref, int q) {
        this.numero = numero;
        this.date = date;
        this.client = client;
        this.reference = ref;
        this.quantite = q;
    }
    Commande(){}

    /**
     * methode toString()
     */

    @Override
    public String toString() {
        return "Commande : " + numero + '\n' +
                "client : " + client + '\n' +
                "date : " + date + '\n' +
                "reference : " + reference + '\n' +
                "quantité : " + quantite;
    }

    // ajouter une reference dans l'ArrayList references
    public void ajouterUneReference(String ref) {
        references.add(ref);
    }


    /*
     * getter et setter
     */

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public ArrayList<String> getReferences() {
        return references;
    }

    public void setReferences(ArrayList<String> references) {
        this.references = references;
    }
}