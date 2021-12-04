package net.pro.workers;

import java.util.List;

public interface IMetier<T> {
    /*
    Créer une Interface générique IMetier qui va déclarer les méthodes pour gérer nos
    entités Produit et Client. Cette interface a un type générique T et contient les méthodes
    suivantes :
    o public T add(T o) : qui permet d’ajouter un objet à la liste.
    o public List<T> getAll() : qui charge la liste des objets à partir d’un fichier et
    les retournent sous forme d’une liste.
    o public T findByNom(String nom) : qui retourne un objet par nom.
    o public void delete(String nom) : qui supprime un objet par nom.
    o Public void saveAll() : qui permet de sauvegarder tous les objets dans le fichier.
     */
    public boolean add(T o);
    public List<T> getAll();
    public T findByNom(String nom);
    public boolean delete(String nom);
    public void saveAll();

}
