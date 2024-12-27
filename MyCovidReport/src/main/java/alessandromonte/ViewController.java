package alessandromonte;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class ViewController implements Initializable {
    private CovReportService service;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<?> comboBox;

    @FXML
    private TableView<?> tableView;

    @FXML
    private Label label;

    @FXML
    private ProgressBar progressBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        datePicker.setValue(LocalDate.now());

        LocalDate date = datePicker.getValue();

        service = new CovReportService();
        service.setDateInUrl(date);

        service.start();

        service.setOnSucceeded(wse -> {
            System.out.println(service.getValue());
        });
    }

    @FXML
    public void onDatePicked() {
        LocalDate date = datePicker.getValue().minusDays(1);
        service.setDateInUrl(date);

        System.out.println("B");
        service.restart();
    }
}
