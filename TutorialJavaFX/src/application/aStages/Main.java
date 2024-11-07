package application.aStages;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Group root = new Group();
        Scene scene = new Scene(root, Color.MAGENTA);

        Image icon = new Image("application/bScenes/logo.png");
        stage.getIcons().add(icon);
        stage.setTitle("Stage Demo Program");

        stage.setWidth(420);
        stage.setHeight(420);
        stage.setResizable(false);

        //Dove appare la finestra
        //stage.setX(50);
        //stage.setY(50);

        //stage.setFullScreen(true);
        //stage.setFullScreenExitHint("NON PUOI USCIRE A MENO CHE NON PREMI q");
        //stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));


        stage.setScene(scene);
        stage.show();
    }
}
