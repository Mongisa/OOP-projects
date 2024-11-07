package application.kBinding;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ///BINDING EXAMPLE
        ///IntegerProperty x = new SimpleIntegerProperty(3);
        ///IntegerProperty y = new SimpleIntegerProperty();
        ///y.bind(x.multiply(10));
        ///System.out.println("x: " + x.getValue());
        ///System.out.println("y: " + y.getValue());
        ///x.setValue(10);
        ///System.out.println("x: " + x.getValue());
        ///System.out.println("y: " + y.getValue());

        primaryStage.setTitle("Binding example");

        //Input and labels
        TextField userInput = new TextField();
        userInput.setMaxWidth(200);
        Label firstLabel = new Label("Welcome to the site ");
        Label secondLabel = new Label();

        HBox bottomText = new HBox(firstLabel, secondLabel);
        bottomText.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(10, userInput, bottomText);
        vBox.setAlignment(Pos.CENTER);

        secondLabel.textProperty().bind(userInput.textProperty());

        Scene scene = new Scene(vBox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
