// File: Main.java
package ie.atu.serialization;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Create a book
        Book book = new Book("Java Fundamentals", "John Doe", 29.99);
        System.out.println("Original Book: " + book);
        
        // Serialize
        try (FileOutputStream fileOut = new FileOutputStream("resources/book.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(book);
            System.out.println("Book has been serialized");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Deserialize
        try (FileInputStream fileIn = new FileInputStream("resources/book.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Book deserializedBook = (Book) in.readObject();
            System.out.println("Book has been deserialized");
            System.out.println("Deserialized Book: " + deserializedBook);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}