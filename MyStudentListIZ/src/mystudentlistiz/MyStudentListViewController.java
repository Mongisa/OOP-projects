package mystudentlistiz;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MyStudentListViewController implements Initializable {

    @FXML
    private TextField nameField,surnameField,codeField;

    @FXML
    private Button addButton,delButton;

    @FXML
    TableView<Student> studentTable;

    @FXML
    TableColumn<Student,String> nameClm;

    @FXML
    TableColumn<Student,String> surnameClm;

    @FXML
    TableColumn<Student,String> codeClm;

    private ObservableList<Student> students;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Inizializzazione ObservableList
        students = FXCollections.observableArrayList();
        //Legame tra TableView e ObservableList
        studentTable.setItems(students);

        //Impostare valore colonna, vuole come valore di ritorno un Observable property
        nameClm.setCellValueFactory(s -> new SimpleStringProperty(s.getValue().getName()));
        //surnameClm.setCellValueFactory(s -> new SimpleStringProperty(s.getValue().getSurname()));
        //codeClm.setCellValueFactory(s -> new SimpleStringProperty(s.getValue().getCode()));

        //C'è una via più rapida
        surnameClm.setCellValueFactory(new PropertyValueFactory("surname"));
        codeClm.setCellValueFactory(new PropertyValueFactory("code"));
        //Per funzionare new PropertyValueFactory("nomeAttributo") ci deve essere un metodo getNomeAttributo

        //Binding (non fatto)
        BooleanBinding b1 = nameField.textProperty().isEmpty();
        BooleanBinding b2 = surnameField.textProperty().isEmpty();
        BooleanBinding b3 = codeField.textProperty().isEmpty();

        addButton.disableProperty().bind(b1.or(b2).or(b3));
    }

    @FXML
    public void addStudent(ActionEvent event) {
        String name = nameField.getText();
        String surname = surnameField.getText();
        String code = codeField.getText();

        students.add(new Student(name,surname,code));

        //La tabella si aggiorna automaticamente perché è osservabile

        nameField.clear();
        surnameField.clear();
        codeField.clear();
    }

    @FXML
    public void delStudent(ActionEvent event) {

    }
}