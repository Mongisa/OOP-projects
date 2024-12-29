package alessandromonte;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

public class ViewController implements Initializable {
    private CovReportService service;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private TableView<CovReportEntry> tableView;

    @FXML
    private TableColumn<CovReportEntry, String> regClm,provClm,casiClm;

    @FXML
    private Label label;

    @FXML
    private ProgressBar progressBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LocalDate date = LocalDate.now().minusDays(1);
        datePicker.setValue(date);

        service = new CovReportService();
        service.setDateInUrl(date);

        progressBar.progressProperty().bind(service.progressProperty());

        service.setOnSucceeded(wse -> {
            label.setText("Caricamento completato");
            if(service.getValue() == null) {
                tableView.setItems(FXCollections.emptyObservableList());
                tableView.refresh();

                return;
            };

            tableView.setItems(service.getValue());
            regClm.setCellValueFactory(new PropertyValueFactory<>("denominazioneRegione"));
            provClm.setCellValueFactory(new PropertyValueFactory<>("denominazioneProvincia"));
            casiClm.setCellValueFactory(new PropertyValueFactory<>("totaleCasi"));
            tableView.refresh();

            Set<String> regions = service.getValue().stream().map(CovReportEntry::getDenominazioneRegione).collect(Collectors.toSet());
            comboBox.setItems(FXCollections.observableArrayList(regions));
        });

        datePicker.setOnAction(this::onModify);
        comboBox.setOnAction(this::onModify);

        service.start();
    }

    @FXML
    public void onModify(ActionEvent event) {
        LocalDate date = datePicker.getValue().minusDays(1);
        service.setDateInUrl(date);

        String denominazioneRegione = comboBox.getSelectionModel().getSelectedItem();
        service.setDenominazioneRegione(denominazioneRegione);

        label.setText("Caricamento in corso");
        service.restart();
    }
}
