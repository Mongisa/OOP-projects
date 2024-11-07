package application.hTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class Controller {
    @FXML
    private Label myLabel;
    @FXML
    private TextField myTextField;
    @FXML
    private Button myButton;

    int age;

    public void submit(ActionEvent event) {
        try {
            age = Integer.parseInt(myTextField.getText());

            if(age >= 18) {
                myLabel.setText("You are now signed up");
                myLabel.setFont(Font.font(16));
            } else {
                myLabel.setText("You must be 18+");
                myLabel.setFont(Font.font(16));
            }
        } catch (NumberFormatException e) {
            //System.out.println("Enter only numbers pls");
            myLabel.setText("Enter only numbers pls");
            myLabel.setFont(Font.font("Verdana", 16));
        } catch (Exception e) {
            myLabel.setText("Error");
        }
    }
}
