package Main;

import mySerializableClass.Diploma;
import mySerializableClass.Emloyee;
import serializationToTextFile.SerialisationToTextFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.EmptyStackException;

public class Application {
    public static void main(String[] args) {
        /*
        Serialization is the conversion of the state of an object into a byte stream; deserialization does the
        opposite. Stated differently, serialization is the conversion of a Java object into a static stream
        (sequence) of bytes which can then be saved to a database or transferred over a network.

        Classes that are eligible for serialization need to implement a special marker interface Serializable.

        Both ObjectInputStream and ObjectOutputStream are high level classes that extend java.io.InputStream
        and java.io.OutputStream respectively. ObjectOutputStream can write primitive types and graphs of objects
        to an OutputStream as a stream of bytes. These streams can subsequently be read using ObjectInputStream.

        //##Inheritance and Composition##

        When a class implements the java.io.Serializable interface, all its sub-classes are serializable as well.
        On the contrary, when an object has a reference to another object, these objects must implement
        the Serializable interface separately, or else a NotSerializableException will be thrown

        //## Serial Version UID ##

        The JVM associates a version (long) number with each serializable class. It is used to verify
        that the saved and loaded objects have the same attributes and thus are compatible on serialization.
        This number can be generated automatically by most IDEs and is based on the class name,
        its attributes and associated access modifiers. Any changes result in a different number
        and can cause an InvalidClassException.If a serializable class doesn't declare a serialVersionUID,
        the JVM will generate one automatically at run-time


         */



        LocalDateTime localDateTime = LocalDateTime.of(2020,Month.JUNE,3,12,00,00,00000);//LocalDateTime.of(2023, Month.JUNE, 1);
        Diploma diploma = new Diploma(12, "Software engineering", localDateTime, 3 );
        Diploma diploma2 = new Diploma(19, "Management", localDateTime, 3 );

        Emloyee emloyee = new Emloyee(13, "Essadeq EL AAMIRI", 22, diploma, 30000f);
        Emloyee emloyee2 = new Emloyee(43, "Marie Lopon", 21, diploma2, 10000f);

        System.out.println(emloyee);
        System.out.println("=".repeat(40));
        //System.out.println(emloyee2);
        //System.out.println("=".repeat(40));

        //To Text File
        SerialisationToTextFile.serialize(emloyee);
        Emloyee emloyeeSer = (Emloyee) SerialisationToTextFile.deserialize();
        System.out.println(emloyeeSer);
        System.out.println("=".repeat(40));

        //To XML File


    }
}
