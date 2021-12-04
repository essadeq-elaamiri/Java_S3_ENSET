package serializationToTextFile;

import java.io.*;

public class SerialisationToTextFile {

    private static final String FILE_PATH = "object.txt";



    public static boolean serialize(Object object){
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try{
            fileOutputStream = new FileOutputStream(FILE_PATH);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            return true;
        }catch (IOException e){
            try{
                objectOutputStream.flush();
                objectOutputStream.close();
                fileOutputStream.close();
            }
            catch (IOException ioe){
                return false;
            }
            return false;
        }
    }

    public static Object deserialize(){
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        Object object = null;
        try{
            fileInputStream = new FileInputStream(FILE_PATH);
            objectInputStream = new ObjectInputStream(fileInputStream);
            object = objectInputStream.readObject();
            return object;
        }catch (IOException e){
            try{

                objectInputStream.close();
                fileInputStream.close();
            }
            catch (IOException ioe){
                return null;
            }
            return null;
        }
        catch (ClassNotFoundException cnfe){
            try{

                objectInputStream.close();
                fileInputStream.close();
            }
            catch (IOException ioe){
                return null;
            }
            return null;
        }
    }

}
