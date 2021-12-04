package net.pro.controller;

import net.pro.model.Contact;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class ContactController {
    HashMap<Integer, Contact> contacts= null;

    public ContactController() {
        this.contacts = this.retrieveContactsFromSystem();
    }

    public HashMap<Integer, Contact> getContacts() {
        return contacts;
    }

    public void validateContact(Contact contact) throws Exception{
        if (contact == null) {
            throw new Exception("Validation Problem: Null Contact!");
        }
        if(!contact.getEmail().matches("[a-zA-Z1-9\\-.]+@[g|hot]mail\\.com")){
            throw new Exception("Validation Problem: Invalid Email! ("+contact.getEmail()+")");
        }
        if(!contact.getPhone().matches("\\+212\\-6[0-9]{3}\\-[0-9]{3}\\-[0-9]{2}")){
            throw new Exception("Validation Problem: Invalid PhoneNumber! ("+contact.getPhone()+")");
        }
        if(contact.getFallName().isEmpty() || contact.getFallName().equals(" ") ){
            throw new Exception("Validation Problem: Invalid FallName! ("+contact.getFallName()+")");
        }

    }

    public Contact findContact(int id){
        if(contacts.containsKey(id)){
            return contacts.get(id);
        }
        return null;
    }

    public void addContact(Contact ...contacts) throws Exception{
        for (Contact contact: contacts) {
            if(findContact(contact.getIdConact()) == null){
                validateContact(contact);
                this.contacts.put(contact.getIdConact(), contact);
            }
            else{
                throw new Exception("Adding Contact Problem: Contact {"+contact.getIdConact()+"-"+contact.getFallName()+"} already exists in list!");
            }

        }

    }

    public Contact findContact(String searchWord) throws Exception{
        //return the first occurrence of a search word
        /*
         the search word must start with what we search for! ex: phone:222, name:EESDS, email:dgdg
         */
        if (!searchWord.matches("(phone|name|email):\\w+")){
            throw new Exception("Invalid search word !");
        }
        // what we search for
        String reason = searchWord.substring(0, searchWord.indexOf(":"));
        searchWord = searchWord.substring(searchWord.indexOf(":")+1);


        for(Contact contact: this.contacts.values()){
            if(reason.equals("name") ){
                if(contact.getFallName().contains(searchWord)){
                    return contact;
                }
            }
            else if(reason.equals("email")){
                if(contact.getEmail().contains(searchWord)){
                    return contact;
                }
            }
            else if(reason.equals("phone")){
                if(contact.getPhone().contains(searchWord)){
                    return contact;
                }
            }
        }
        return null;
    }

    public boolean removeContact(int id){
        Contact contact = findContact(id);
        if(contact != null){
            this.contacts.remove(id);
            //TODO remove file also
            final String folderName = "DossierContact";
            File file;
            //file to be removed
            String fileName = ""+contact.getIdConact()+"_"+contact.getFallName().replace(" ", "_").trim()+".txt";
            file = new File(folderName);
            if(file.exists() && file.isDirectory()){
                //find our file
                File fileToRemove = new File(folderName+"/"+fileName);
                if(fileToRemove.exists() && fileToRemove.isFile()){
                    return fileToRemove.delete();
                }

            }

            return true;

        }
        return false;
    }

    public boolean editContactPhoneNumber(int id, String newNumber) throws Exception{
        if(findContact(id) == null) return false;
        findContact(id).setPhone(newNumber);
        validateContact(findContact(id));
        return true;
    }

    public void showContact(Contact contact){
        System.out.println(contact);
    }
    public void showAllContacts(){
        Iterator iterator = this.contacts.keySet().iterator();
        while (iterator.hasNext()){
            showContact(this.contacts.get(iterator.next()));
        }
    }
    private HashMap<Integer, Contact> retrieveContactsFromSystem() /*throws Exception*/{
        // retrieve Contacts and return Map
        //TODO: getfiles, loop throw them, extract the object cast it to Contact than add it the the hashMap
        // get files
        final String folderName = "DossierContact";
        File file;
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        HashMap<Integer,Contact> contacts = new HashMap<>();
        Contact helperContact;

        file = new File(folderName);
        if(!file.exists() || !file.isDirectory()){
            //throw new Exception("Folder "+folderName+" does not exist!");
            return null;
        }

        for(File  f: file.listFiles()){
            if(f.isFile() && f.getName().matches("\\d+(_\\w+)+.txt")){
                //System.out.println("if block => "+f.getName());
                try{
                    fileInputStream = new FileInputStream(f.getPath());
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    helperContact = (Contact) objectInputStream.readObject();
                    validateContact(helperContact);
                    contacts.put(helperContact.getIdConact(), helperContact);

                }catch (FileNotFoundException e){
                    System.out.println(e.getMessage());
                }
                catch (ClassNotFoundException e){
                    System.out.println(e.getMessage());
                }
                catch (IOException e){
                    System.out.println(e.getMessage());
                }catch (Exception e){
                    System.out.println(e);
                }finally {

                    try {
                        objectInputStream.close();
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return contacts;

    }

    public void saveContactsToSystem(){
        // save HashMap on files
        // TODO: create a file for each contact

        if(this.contacts.isEmpty()) {
            return;
        }

        String fileName;
        File file;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        Iterator iterator = contacts.keySet().iterator();
        while (iterator.hasNext()){
            // build contact file name
            Contact contact = contacts.get(iterator.next());

            //file name form :: id_fall_name.txt
            // DossierContact/id_fall_name.txt

            fileName = ""+contact.getIdConact()+"_"+contact.getFallName().replace(" ", "_").trim()+".txt";
            //create folder if not exist
            file = new File("DossierContact");
            if(!file.exists()){
                file.mkdir();
            }

            // create files
            file = new File(file.getName()+"/"+fileName);
            fileName = file.getPath();
            if (!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // serialize objects
            try{
                fileOutputStream = new FileOutputStream(fileName);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(contact);
            }
            catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
            finally {

                try {
                    objectOutputStream.close();
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
