package testfinal;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author diegoornelas
 */
public class Library {
    //Attributes
    private List<Book> books;
    private List<User> users;
    private List<Loans> loans;
    
    //Builders
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.loans = new ArrayList<>();
    }
    
    public void addBook(Book book) {
        this.books.add(book);
    }
    
    public void deleteBook(Book book) {
        this.books.remove(book);
    }
    
    public void addUser(User user) {
        this.users.add(user);
    }
    
    public void deleteUser(User user) {
        this.users.remove(user);
    }
    
    public void addLoans(Loans loans) {
        this.loans.add(loans);
    }
    
    public void deleteLoans(Loans loans) {
        this.loans.remove(loans);
    }
}
