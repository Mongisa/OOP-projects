package mySpeedConverter;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

//Il controller deve avere un riferimento alla view
public class MySpeedConverterController {
    private MySpeedConverterView view;

    public MySpeedConverterController(MySpeedConverterView view) {
        this.view = view;
        initBindings();
    }

    private void initBindings() {
        //È possibile impostare il binding in maniera tale
        //che solo quando usiamo risultato l'espressione
        //viene valutata

        //COMPORTAMENTI
        //Usiamo lo string converter per convertire da stringa a double
        //È una classe astratta che consente di convertire una stringa
        //in un qualsiasi tipo osservabile
        DoubleProperty input = new SimpleDoubleProperty();
        StringConverter sc = new DoubleStringConverter();

        Bindings.bindBidirectional(view.input.textProperty(), input, sc);

        NumberBinding result = input.divide(1.852);

        //È un binding numerico, per mostrarlo dovrebbe essere di tipo stringa
        view.display.textProperty().bind(result.asString("%.2f"));
    }
}
