package mySpeedConverter;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

public class MySpeedConverter extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Convertitore");
        Image icon = new Image("mySpeedConverter/icon.png");
        primaryStage.getIcons().add(icon);


        MySpeedConverterView view = new MySpeedConverterView();
        new MySpeedConverterController(view);

        Scene scene = new Scene(view,500,250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
