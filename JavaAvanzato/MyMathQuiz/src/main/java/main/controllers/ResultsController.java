package main.controllers;

import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import main.models.NumericQuestionAttempt;
import main.models.Quiz;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultsController implements Initializable {
    private Quiz quiz;

    private FileChooser fileChooser;

    @FXML
    private Button exportBtn;

    @FXML
    private Label promptLbl;

    @FXML
    private TableView<NumericQuestionAttempt> table;
    @FXML
    private TableColumn<NumericQuestionAttempt, String>
            attemptColumn;
    @FXML
    private TableColumn<NumericQuestionAttempt, String>
            resultColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Platform.runLater(() -> {
            table.setItems(quiz.getQuiz());
            attemptColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().toString()));
            resultColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getResult()));

            promptLbl.setText(
                    "Gentile "+quiz.getPlayerName()+" "+quiz.getPlayerSurname()+
                    ", grazie per aver completato il quiz. Esporta i tuoi risultati su file"
            );

            fileChooser = new FileChooser();
            fileChooser.setTitle("Save txt file");
            fileChooser.setInitialFileName("results.txt");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("txt File", "*.txt"));
        });
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @FXML
    void onExport() {
        File fileOut = fileChooser.showSaveDialog(exportBtn.getScene().getWindow());
        try {
            quiz.exportTXT(fileOut);
        } catch(IOException e) {
            showAlert("Errore durante l'export del risultato");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errore");
        alert.setHeaderText("Errore");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
