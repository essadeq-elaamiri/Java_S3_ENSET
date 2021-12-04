package net.pro.workers;

import net.pro.models.Produit;
import net.pro.utils.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MetierProduitImp implements IMetier<Produit>{
     /*
    Créer une classe MetierProduitImpl qui implémente l’interface IMetier. Cette classe
    contient un attribut qui représente une liste de produits et un attribut qui contient le
    nom de fichier pour sauvegarder les produits.
    */
    private List<Produit> produits;
    private final String FOLDER = "data";
    private final String FILE = "produits.dat";

    public MetierProduitImp() {

        this.produits = this.getAll() == null ? new ArrayList<>() : this.getAll();
    }


    public List<Produit> getProduits() {
        return produits;
    }

    @Override
    public boolean add(Produit o) {
        if (this.produits.contains(o)) return false;
        this.produits.add(o);
        return true;
    }

    @Override
    public List<Produit> getAll() {
        List<Produit> produits = null;
        File folder = new File(this.FOLDER);
        File file = null;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try{

            if (!folder.exists()){
                return null;
            }
            file = new File(folder.getName()+"/"+this.FILE);
            if(!file.exists())
                return null;
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            produits = (List<Produit>) objectInputStream.readObject();


        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            try{
                fileInputStream.close();
                objectInputStream.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }


        return produits;
    }

    @Override
    public Produit findByNom(String nom) {
        for (Produit p: produits) {
            if (p.getNom().equals(nom)) return p;
        }
        return null;
    }

    @Override
    public boolean delete(String nom) {
        Produit pp = findByNom(nom);
        if(pp == null) return false;
        this.produits.remove(pp);
        return true;
    }

    @Override
    public void saveAll() {
        Utils.saveObjToFile(this.produits, this.FOLDER, this.FILE);
    }
}
