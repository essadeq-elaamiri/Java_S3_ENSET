package net.pro.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Utils {
    public static void saveObjToFile(Object obj, String folderName, String fileName){
        //TODO create the folder if not exist
        //TODO create the file if not exist
        //write the entire list to file
        File folder = new File(folderName);
        File file = null;
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try{

            if (!folder.exists()){
                folder.mkdir();
            }
            file = new File(folder.getName()+"/"+fileName);
            if(!file.exists())
                file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(obj);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            try{
                fileOutputStream.close();
                objectOutputStream.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

}

