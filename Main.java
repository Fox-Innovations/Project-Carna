import javafx.application.Application;

import java.io.IOException;
import java.time.LocalDate;
import Information.AdmissionInfo;
import Information.PatientInfo;
import GUI.PrimaryWindow;

public class Main {

    public static void main(String[] args) {

        LocalDate d1 = LocalDate.of(1998, 6, 3);
        LocalDate d2 = LocalDate.now();
        AdmissionInfo admission = new AdmissionInfo(d2, "Too Much Coom", "Long", "Dick");
        PatientInfo patient = new PatientInfo("Betheny", "Smith", 29, d1, admission);
        try {
            PatientInfo.writeJSONFile(patient);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Application.launch(PrimaryWindow.class);

    }

}