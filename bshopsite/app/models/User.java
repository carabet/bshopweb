package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.annotation.EnumValue;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity 
@Table(name="user")
public class User extends Model{
	
	public enum UserType {
		@EnumValue("C")
		Customer,
		@EnumValue("E")
		Employee,
		@EnumValue("A")
		Admin,
	}
	
	@Id
	@Constraints.Required
	@Formats.NonEmpty
	public String username;
	
	@Enumerated(value=EnumType.STRING)
	public UserType usertype=UserType.Customer;
	
	@Constraints.Required
	public String password;
	
	@Constraints.Required
	public String email;
	
	@Constraints.Required
	public String name;
	
	public String phone;
	
    public static Model.Finder<String,User> find = new Model.Finder<String,User>(String.class, User.class);
    
    public User(String username, String password, String email, String name){
    	this.username = username;
    	this.password = password;
    	this.email = email;
    	this.name = name;
    }
    
    /**
     * Retrieve all users.
     */
    public static List<User> findAll() {
        return find.all();
    }

    /**
     * Retrieve a User by username.
     */
    public static User findByUsername(String username) {
        return find.where().eq("username", username).findUnique();
    }
    
    /**
     * Authenticate a User.
     */
    public static User authenticate(String username, String password) {
        return find.where()
            .eq("username", username)
            .eq("password", password)
            .findUnique();
    }
    
    // --
    
    public String toString() {
        return "User(" + username + ")";
    }

}

    