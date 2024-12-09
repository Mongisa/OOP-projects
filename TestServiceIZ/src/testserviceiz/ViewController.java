package testserviceiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ProgressIndicator progInd;

    @FXML
    private Label label;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MyService service = new MyService();

        //Legame tra indicatore di progresso del servizio e quello di interfaccia
        progInd.progressProperty().bind(service.progressProperty());

        progInd.visibleProperty().bind(service.runningProperty());

        label.textProperty().bind(service.valueProperty());
        //service.getValue(); //MORTE DIDATTICA! HA SENSO SOLO QUANDO IL SERVIZIO HA COMPLETATO IL TASK

        service.setOnSucceeded(e -> {
            System.out.println(service.getValue());
            label.textProperty().unbind();
            label.setText("Completato");
        });

        service.start();
    }
}
