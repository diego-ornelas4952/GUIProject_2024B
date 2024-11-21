package testfinal;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author diegoornelas
 */
public class Book {
    //Atributtes
    private String title;
    private String author;
    private String genre;
    private String editorial;
    private int yearPublic;
    
    //Contructors
    public Book(String title, String author, String genre, String editorial, int yearPublic) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.editorial = editorial;
        this.yearPublic = yearPublic;
    }
    
    //Methods
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getEditorial() {
        return editorial;
    }
    
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    public int getDate() {
        return yearPublic;
    }
    
    public void setDate(int yearPublic) {
        this.yearPublic = yearPublic;
    }
    
    private List<Book> book = new ArrayList<>(); // ArrayList named books with elements of the Books class
    private static String filePath = "/Users/diegoornelas/Documents/POO/books.txt";
    // Method to add a book in the txt file
    private static boolean addBook(List<Book> list) {
        try(BufferedWriter wr = new BufferedWriter(new FileWriter(filePath, true))) {
            for(Book book : list) {    // Iterate through the list to save the info of the book
                wr.write(book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getGenre() + "\t" + String.valueOf(book.getDate()));
                wr.newLine();
            }
            return true;
        } catch(IOException e) {
            return false;            
        }
    } // End of saveBook
    // Method to overwrite the info in the txt file
    private static boolean updateBook(List<Book> list) {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(filePath))) {
            for (Book book : list) {
                wr.write(book.getTitle() + "\t" + book.getAuthor() + "\t" + book.getGenre() + "\t" + String.valueOf(book.getDate()));
                wr.newLine();
            }
            return true;
        } catch (IOException e) {
            return false;
        }       
    }
    // Method to edit a specific attribute of the book
    private static boolean editBook(List<Book> list, String title, String attr, String newValue) { 
        boolean found = false;
    
        for (Book book : list) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                found = true;
                switch (attr.toLowerCase()) {
                    case "title":
                        book.setTitle(newValue);
                    break;
                    case "author":
                        book.setAuthor(newValue);
                    break;
                    case "genre":
                        book.setGenre(newValue);
                    break;
                    case "date":
                        try {
                            book.setDate(Integer.parseInt(newValue)); 
                        } catch (NumberFormatException e) {
                            return false; // Handle the exception msj in the front
                        }
                    break;
                    default:
                        return false; // Invalid attribute
                }
                return updateBook(list); // Update the file after editing
            }
        }
        return false; // Book not founded        
    } // End of editBook
    // Method to delete a book by title
    private static boolean deleteBook(List<Book> list, String title) {
        boolean found = list.removeIf(book -> book.getTitle().equalsIgnoreCase(title));

        if (found) {
            // Update the file after deletion
            updateBook(list);
        }
        return found; // If the book is not founded returns false
    }
    // Method to erase all the book
    private static boolean eraseAll(List<Book> list) {
        list.clear(); // Clears the list

        try (BufferedWriter wr = new BufferedWriter(new FileWriter(filePath))) {
            // Overwrites the file with empty content
            return true;
        } 
        catch (IOException e) {
            return false; 
        }
    }
}