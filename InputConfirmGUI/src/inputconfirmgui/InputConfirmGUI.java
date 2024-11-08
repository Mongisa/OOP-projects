/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package inputconfirmgui;

import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 *
 * @author mongisa
 */
public class InputConfirmGUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Label myLabel1 = new Label("input:");
        TextField myTextField1 = new TextField("");
        
        GridPane grid = new GridPane();
        
        Label myLabel2 = new Label("confirm input:");
        TextField myTextField2 = new TextField("");
        
        Button myButton = new Button("OK");
        BooleanBinding bb1 = myTextField1.textProperty().isNotEqualTo(myTextField2.textProperty());
        BooleanBinding bb2 = myTextField1.textProperty().isEmpty();
        
        myButton.disableProperty().bind(bb1.or(bb2));

        GridPane.setConstraints(myLabel1, 0, 0);
        GridPane.setConstraints(myTextField1, 1, 0);
        GridPane.setConstraints(myLabel2, 0, 1);
        GridPane.setConstraints(myTextField2, 1, 1);
        GridPane.setConstraints(myButton, 1, 3);
        
        myLabel1.setPadding(new Insets(10));
        myLabel2.setPadding(new Insets(10));
        
        grid.getChildren().addAll(myLabel1,myTextField1,myLabel2,myTextField2,myButton);
        
        grid.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(grid, 300, 250);
        
        myButton.setOnAction(e -> {
            System.out.println("Test intelligenza superato!");
        });
        
        primaryStage.setTitle("MyInputConfirm");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
