/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bshopapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author sasha
 */
public class Bshopapplication extends Application {

    //private Object stage;

    public boolean validate(String text) {
        return true;
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("loginScreen.fxml"));
        Scene scene = new Scene(root);


        stage.setScene(scene);
        stage.show();




    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
