import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override

    public void start(Stage primaryStage) {

        primaryStage.setTitle("Site Here");
        GridPane grid = new GridPane();

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        // Top menu:

        Label yearLabel = new Label("Anul: ");

        ChoiceBox<String> yearBox = new ChoiceBox<>();
        yearBox.getItems().add("I");
        yearBox.setValue("I");

        Label groupLabel = new Label("Grupa: ");

        ChoiceBox<String> groupBox = new ChoiceBox<>();
        groupBox.getItems().addAll("E2");
        groupBox.setValue("E2");

        Label semesterLabel = new Label("Semestrul: ");

        ComboBox<String> semesterBox = new ComboBox<>();
        semesterBox.getItems().addAll("Semestrul 1", "Semestrul 2");
        semesterBox.getSelectionModel().selectFirst();

        Courses courses = new Courses();
        int objectsStartingRow = 4;
        Hyperlink hyperlink = new Hyperlink();
        hyperlink.setWrapText(true);
        populateObjects(grid, objectsStartingRow + 1, courses.getYearOneSemesterOne());

        grid.add(yearLabel, 0, 0);
        grid.add(yearBox, 1, 0);
        grid.add(groupLabel, 2, 0);
        grid.add(groupBox, 3, 0);
        grid.add(semesterLabel, 4, 0);
        grid.add(semesterBox, 5, 0);


        // Semester selection:
        semesterBox.setOnAction(e -> {
            grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) >= 4);
            switchSemester(semesterBox, grid);
        });

        //Default semester:

        Scene selection = new Scene(grid, 1000, 500);
        primaryStage.setScene(selection);
        primaryStage.show();
    }

    private void switchSemester(ComboBox<String> semesterBox, GridPane grid) {
        Courses courses = new Courses();
        int objectsStartingRow = 4;
        Hyperlink hyperlink = new Hyperlink();
        hyperlink.setWrapText(true);

        if (semesterBox.getValue().equals("Semestrul 1")) {
            populateObjects(grid, objectsStartingRow + 1, courses.getYearOneSemesterOne());

        } else if (semesterBox.getValue().equals("Semestrul 2")) {
            populateObjects(grid, objectsStartingRow + 1, courses.getYearOneSemesterTwo());
        }
    }

    private void populateObjects(GridPane grid, int objectsStartingRow, HashMap<String, Hyperlink> yearOneSemesterOne) {
        Hyperlink hyperlink;
        for (String key : yearOneSemesterOne.keySet()) {
            grid.add(new Text(key), 0, objectsStartingRow);

            hyperlink = yearOneSemesterOne.get(key);
            grid.add(hyperlink, 5, objectsStartingRow++);
            Hyperlink finalHyperlink = hyperlink;
            hyperlink.setOnAction(t -> getHostServices().showDocument(finalHyperlink.getText()));
        }
    }


}















