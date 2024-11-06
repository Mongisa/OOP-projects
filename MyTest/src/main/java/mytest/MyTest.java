package mytest;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mongisa
 */
public class MyTest extends Application {

    @Override
    public void start(Stage primaryStage) {

        Label lbl = new Label();
        lbl.setText("Label");

        TextField tfd = new TextField();

        Button btn = new Button();
        btn.setText("Click me!");
        /*btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                lbl.setText(tfd.getText());

                System.out.println("evento: " + event);
            }
        });*/

        //lambda expression
        btn.setOnAction(event -> {
            //lbl.setText(tfd.getText());

            System.out.println("evento: " + event);
        });

        //binding
        lbl.textProperty().bind(tfd.textProperty());

        VBox root = new VBox();
        root.getChildren().addAll(lbl,tfd,btn);

        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(30));
        root.setSpacing(10);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("My First Application");
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
