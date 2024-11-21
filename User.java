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
public class User {
    //Attributes
    private String name;
    private String address;
    private String phone;
    
    //Builders
    public User(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPhone(){
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    private List<User> users = new ArrayList<>();
    private static String filePath ="/Users/diegoornelas/Documents/POO/users.txt";
    private static boolean addUser(List<User> list) {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(filePath, true))) {
            for (User users : list) {
                wr.write(users.getName() + "\t" + users.getAddress() + "\t" + String.valueOf(users.getPhone()));
                wr.newLine();
            }
            return true;
        } catch(IOException e) {
            return false;
        }
    }
    private static boolean updateUser(List<User> list) {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(filePath))) {
            for (User users: list) {
                wr.write(users.getName() + "\t" + users.getAddress() + String.valueOf(users.getPhone()));
                wr.newLine();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    private static boolean deleteUser(List<User> list, String name) {
        boolean found = list.removeIf(users -> users.getName().equalsIgnoreCase(name));
        if (found) {
            return updateUser(list);
        }
    }
    
    
    private static boolean eraseAll(List<User> list) {
        list.clear();
       try (BufferedWriter wr = new BufferedWriter(new FileWriter(filePath))) {
        return true;
        } catch (IOException e) {
        return false;
       }
    }
}
