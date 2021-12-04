package net.pro.workers;

import net.pro.models.Client;
import net.pro.models.Produit;
import net.pro.utils.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class MetierClientImp implements IMetier<Client> {
        /*
    Créer une classe MetierClientImpl qui implémente l’interface IMetier. Cette classe
    contient un attribut qui représente une liste de clients et un attribut qui contient le nom
    de fichier pour sauvegarder les clients.
     */

    private List<Client> clients;
    private final String FOLDER = "data";
    private final String FILE = "clients.dat";

    public MetierClientImp() {
        this.clients = this.getAll() == null ? new ArrayList<>() : this.getAll();
    }

    public List<Client> getClients() {
        return clients;
    }

    @Override
    public boolean add(Client o) {
        if (this.clients.contains(o)) return false;
        this.clients.add(o);
        return true;
    }


    @Override
    public List<Client> getAll() {
        List<Client> clients = null;
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
            clients = (List<Client>) objectInputStream.readObject();


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
        return clients;
    }

    @Override
    public Client findByNom(String nom) {
        for (Client p: clients) {
            if (p.getNom().equals(nom)) return p;
        }
        return null;
    }

    @Override
    public boolean delete(String nom) {
        Client pp = findByNom(nom);
        if(pp == null) return false;
        this.clients.remove(pp);
        return true;
    }

    @Override
    public void saveAll() {
        Utils.saveObjToFile(this.clients, this.FOLDER, this.FILE);
    }
}
