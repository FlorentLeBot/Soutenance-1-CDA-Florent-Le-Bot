package fr.cda.projet;

import java.util.*;

import fr.cda.util.*;

// Classe de definition du site de vente
//
public class Site {
    private ArrayList<Produit> stock;       // Les produits du stock
    private ArrayList<Commande> commandes;  // Les bons de commande

    private ArrayList<Commande> commande;

    // Constructeur
    //
    public Site() {
        this.stock = new ArrayList<Produit>();
        this.commandes = new ArrayList<Commande>();
        this.commande = new ArrayList<Commande>();

        // lecture du fichier data/Produits.txt
        // pour chaque ligne on cree un Produit que l'on ajoute a stock

        initialiserStock("data/Produits.txt");

        //  lecture du fichier data/Commandes.txt
        //  pour chaque ligne on cree une commande ou on ajoute une reference
        //  d'un produit a une commande existante.
        initialiserCommande("data/Commandes.txt");
    }

    // Methode qui retourne sous la forme d'une chaine de caractere
    // tous les produits du stock

    public String listerTousProduits() {
        String res = "";
        for (Produit prod : stock)
            res = res + prod.toString() + "\n";

        return res;
    }

    // Methode qui retourne sous la forme d'une chaine de caractere
    //  toutes les commandes
    //
    public String listerToutesCommandes() {
        String res = "";
        for (Commande commande : commandes)
            res = res + commande.toString() + "\n";

        return res;
    }

    // Methode qui retourne sous la forme d'une chaine de caractere une commande en fonnction de son numero
    public String listerCommande(int numero) {
        String res = "";
        for (Commande c : this.commandes) {
            if (c.getNumero() == numero) {
                commande.add(c);
                res += c.toString();
            }
        }
        return res;
    }

    /**
     * Methode : lire le fichier des produits
     *
     * @param nomFichier
     */

    // Chargement du fichier de stock
    private void initialiserStock(String nomFichier) {
        String[] lignes = Terminal.lireFichierTexte(nomFichier);
        for (String ligne : lignes) {
            System.out.println(ligne);
            String[] champs = ligne.split("[;]", 4);
            String reference = champs[0];
            String nom = champs[1];
            double prix = Double.parseDouble(champs[2]);
            int quantite = Integer.parseInt(champs[3]);
            Produit p = new Produit(reference,
                    nom,
                    prix,
                    quantite
            );
            stock.add(p);
        }
    }

    /**
     * Methode : lecture du fichier commande
     *
     * @param nomFichier
     */
    // Chargement du fichier des commandes
    private void initialiserCommande(String nomFichier) {
        String[] lignes = Terminal.lireFichierTexte(nomFichier);
        for (String ligne : lignes) {
            System.out.println(ligne);
            String[] champs = ligne.split("[;&=]", 5);

            int numero = Integer.parseInt(champs[0]);
            String date = champs[1];
            String client = champs[2];
            String ref = champs[3];
            int quantite = Integer.parseInt(champs[4]);

            Commande c = new Commande(numero,
                    date,
                    client,
                    ref,
                    quantite
            );
            commandes.add(c);
        }
    }


    public ArrayList<Produit> getStock() {
        return stock;
    }

    public void setStock(ArrayList<Produit> stock) {
        this.stock = stock;
    }

    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(ArrayList<Commande> commandes) {
        this.commandes = commandes;
    }
}