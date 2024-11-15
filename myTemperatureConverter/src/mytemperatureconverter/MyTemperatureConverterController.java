/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mytemperatureconverter;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

/**
 *
 * @author mongisa
 */
public class MyTemperatureConverterController {
    private MyTemperatureConverterView view;
    
    public MyTemperatureConverterController(MyTemperatureConverterView view) {
        this.view = view;
        initBindings();
    }
    
    public void initBindings() {
        view.titleLabel.textProperty().bind(
                Bindings.when(view.checkBox.selectedProperty())
                        .then("Fahr to Celsius")
                        .otherwise("Celsius to Fahr"));
        
        DoubleProperty input = new SimpleDoubleProperty();
        StringConverter sc = new DoubleStringConverter();
        
        Bindings.bindBidirectional(view.textField.textProperty(), input, sc);

        NumberBinding result1 = input.subtract(32).multiply(5.0/9.0);
        NumberBinding result2 = input.multiply(9.0/5.0).add(32);
        
        StringBinding str = Bindings.when(view.checkBox.selectedProperty())
                        .then(result1.asString("Result: %.2f"))
                        .otherwise(result2.asString("Result: %.2f"));

        //È un binding numerico, per mostrarlo dovrebbe essere di tipo stringa
        view.resultLabel.textProperty().bind(str);
    }
    
}
