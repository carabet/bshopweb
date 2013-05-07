package models;

import models.User;
import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;

public class ModelTest extends WithApplication {
    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }
    
    @Test
    public void createAndRetrieveUser() {
        new User("adam", "password", "adam@gmail.com", "Adam ben adam").save();
        User adam = User.find.where().eq("email", "adam@gmail.com").findUnique();
        assertNotNull(adam);
        assertEquals("adam", adam.name);
    }
}