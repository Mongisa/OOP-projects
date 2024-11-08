package mySpeedConverter;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class MySpeedConverterView extends HBox {
    //Identifichiamo come set di attributi i nodi modificabili
    public TextField input;
    public Label display;

    public MySpeedConverterView() {
        super();
        initComponents();
    }

    private void initComponents() {
        //INTERFACCIA
        input = new TextField();

        //limitare larghezza textField
        this.input.setPrefColumnCount(5);

        this.display = new Label();
        Label symbol = new Label();

        symbol.setText("km/h ➡ kts");
        symbol.setFont(Font.font("Sans",18));

        this.getChildren().addAll(this.input,symbol,this.display);

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(30));
        this.setSpacing(15);
    }
}
