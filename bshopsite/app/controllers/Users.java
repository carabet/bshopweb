package controllers;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import models.User;
import static play.data.Form.*;

public class Users extends Controller {
	
	/**
	 * Login form java class
	 */
	public static class Login {
		public String username;
		public String password;
		
		public String validate(){
			if (User.authenticate(username, password) == null)
				return "Invalid user or password";
			return null;
		}
	}
	
	/**
	 * 
	 * @return Login Page
	 */
	public static Result login(){
		return ok(login.render(form(Login.class)));
	}

    /**
     * Authenticate posted form
     * @return
     */
	public static Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if(loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session("username", loginForm.get().username);
            return redirect(
                routes.Projects.index()
            );
        }
    }
}
