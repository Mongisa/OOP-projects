/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mytemperatureconverter;

import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author mongisa
 */
public class MyTemperatureConverterView extends VBox {
    public Label titleLabel;
    public Label inputLabel;
    public TextField textField;
    public Label resultLabel;
    public CheckBox checkBox;
    
    public MyTemperatureConverterView() {
        super();
        initComponents();
    }
    
    public void initComponents() {
        this.titleLabel = new Label("Celsius to Fahr");
        this.inputLabel = new Label("Input:");
        this.textField = new TextField();
        this.resultLabel = new Label("Result:");
        this.checkBox = new CheckBox("<--->");
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(inputLabel,textField);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);
        
        this.getChildren().addAll(titleLabel,hbox,resultLabel,checkBox);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);
    }
}
