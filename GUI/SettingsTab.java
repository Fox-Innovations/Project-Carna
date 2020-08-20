package GUI;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import Information.AdmissionInfo;
import Information.PatientInfo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class SettingsTab {

    private Tab settingsTab;
    private GridPane settings;
    private InformationTabBar parent;

    public SettingsTab(InformationTabBar tabBar) {

        parent = tabBar;

        settings = new GridPane();

        settingsTab = new Tab("Settings", settings);

        settings.setAlignment(Pos.CENTER);
        settings.setHgap(10);
        settings.setVgap(10);

        //#TODO make it so you can change just a few things at once instead of having to change all to avoid null pointers
        Text patientSettings = new Text("Patient Settings");
        settings.add(patientSettings, 0, 0, 2, 1);
        // Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse( ##DATE## );
        Label patientFirstName = new Label("Patient First Name");
        Label patientLastName = new Label("Patient Last Name");
        Label patientAge = new Label("Patient Age");
        Label patientDateOfBirth = new Label("Patient Date Of Birth {dd/MM/yyyy}");
        TextField newPatientFirstName = new TextField();
        TextField newPatientLastName = new TextField();
        TextField newPatientAge = new TextField();
        TextField newPatientDateOfBirth = new TextField();
        settings.add(patientFirstName, 0, 1);
        settings.add(patientLastName, 0, 2);
        settings.add(patientAge, 0, 3);
        settings.add(patientDateOfBirth, 0, 4);
        settings.add(newPatientFirstName, 1, 1);
        settings.add(newPatientLastName, 1, 2);
        settings.add(newPatientAge, 1, 3);
        settings.add(newPatientDateOfBirth, 1, 4);

        Text admissionsettings = new Text("Admission Settings");
        settings.add(admissionsettings, 0, 5, 2, 1);
        Label dateOfAdmission = new Label("Date of Admission {dd/MM/yyyy}");
        Label doctorsFirstName = new Label("Doctor's First Name");
        Label doctorsLastName = new Label("Doctor's Last Name");
        Label patientDiagnosis = new Label("Patient Diagnosis");
        TextField newDateOfAdmission = new TextField();
        TextField newDoctorsFirstName = new TextField();
        TextField newDoctorsLastName = new TextField();
        TextField newPatientDiagnosis = new TextField();
        settings.add(dateOfAdmission, 0, 6);
        settings.add(doctorsFirstName, 0, 7);
        settings.add(doctorsLastName, 0, 8);
        settings.add(patientDiagnosis, 0, 9);
        settings.add(newDateOfAdmission, 1, 6);
        settings.add(newDoctorsFirstName, 1, 7);
        settings.add(newDoctorsLastName, 1, 8);
        settings.add(newPatientDiagnosis, 1, 9);

        Button saveButton = new Button("Save Settings");
        saveButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                // set all values gleaned from text inputs here

                try {

                    LocalDate dateOfAdmission = new Date(new SimpleDateFormat("dd/MM/yyyy").parse(newDateOfAdmission.getText()).getTime()).toLocalDate();
                    LocalDate dateOfBirth = new Date(new SimpleDateFormat("dd/MM/yyyy").parse(newPatientDateOfBirth.getText()).getTime()).toLocalDate();

                    AdmissionInfo admission = new AdmissionInfo(
                            dateOfAdmission,
                            newPatientDiagnosis.getText(), newDoctorsFirstName.getText(), newDoctorsLastName.getText());

                    PatientInfo patientInfo = new PatientInfo(newPatientFirstName.getText(),
                            newPatientLastName.getText(), Integer.parseInt(newPatientAge.getText()),
                            dateOfBirth, admission);

                    PatientInfo.writeJSONFile(patientInfo);
                    

                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                } catch (ParseException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                parent.refresh();
            }
        });
        settings.add(saveButton, 1, 11);
    }

    public Tab getSettingsTab(){
        return settingsTab;
    }

    
    
}