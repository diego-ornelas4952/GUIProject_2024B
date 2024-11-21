package testfinal;
import java.time.LocalDate;
/**
 *
 * @author diegoornelas
 */
public class Loans {
    //Attributes
    private User user;
    private Book book;
    private LocalDate loanDate;
    private LocalDate returnDate;
    
    //Builders
    public Loans(User user, Book book, LocalDate loanDate, LocalDate returnDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public Book getBook() {
        return book;
    }
    
    public void setBook(Book book) {
        this.book = book;
    }
    
    public LocalDate getloanDate() {
        return loanDate;
    }
    
    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }
    
    public LocalDate getReturnDate() {
        return returnDate;
    }
    
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
