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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

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

    @FXML
    public void loadAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Selezione file .csv da importare");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV","*.csv"));

        File file = fc.showOpenDialog(new Stage());

        if(file == null) return;

        readCSV(file);
    }

    @FXML
    public void saveAction(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Seleziona dove salvare .csv");
        fc.setInitialFileName("mystudentslist");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV","*.csv"));


        File path = fc.showSaveDialog(new Stage());

        if(path == null) return;

        saveCSV(path);
    }

    public void saveCSV(File path) {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path)))) {
            pw.println("NOME;COGNOME;MATRICOLA");

            for(Student s : students) {
                pw.append(s.getName()).append(';');
                pw.append(s.getSurname()).append(';');
                pw.append(s.getCode());
                pw.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readCSV(File file) {
        try(Scanner s = new Scanner(new BufferedReader(new FileReader(file)))) {
            s.useDelimiter("[;\n]");
            s.useLocale(Locale.ITALY);

            if(s.nextLine() == null) return;

            while(s.hasNext()) {
                String nome = s.next();
                String cognome = s.next();
                String matricola = s.next();

                Student st = new Student(nome,cognome,matricola);
                students.add(st);
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}