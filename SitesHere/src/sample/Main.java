package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Objects;


public class Main extends Application {

    Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override

    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Site Here");
        GridPane grid = new GridPane();

        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        // Top menu:

        ChoiceBox<String> groupBox = new ChoiceBox<>();
        groupBox.getItems().addAll("E2");
        groupBox.setValue("E2");
        Label groupLabel = new Label("Grupa: ");

        ChoiceBox<String> yearBox = new ChoiceBox<>();
        yearBox.getItems().add("I");
        yearBox.setValue("I");
        Label yearLabel = new Label("Anul: ");

        ChoiceBox<String> semesterBox = new ChoiceBox<>();
        semesterBox.getItems().addAll("Semestrul 1", "Semestrul 2");
        semesterBox.setValue("Semestrul 2");
        Label semesterLabel = new Label("Semestrul: ");


        grid.add(yearLabel, 0, 0);
        grid.add(yearBox, 1, 0);
        grid.add(groupLabel, 2, 0);
        grid.add(groupBox, 3, 0);
        grid.add(semesterLabel, 4, 0);
        grid.add(semesterBox, 5, 0);


        // Semester selection:

        semesterBox.setOnAction(e -> switchSemester(semesterBox, grid));

        //Default semester:

        Scene selection = new Scene(grid, 1000, 500);
        window.setScene(selection);
        window.show();
    }



    public void switchSemester(ChoiceBox<String> semesterBox, GridPane grid){
        String semester = semesterBox.getValue();
        Label courses[] = new Label[8];
        Hyperlink[] sites = new Hyperlink[8];
        String semester2 = "Semestrul 2";
        System.out.println(semester + semester2);

        String defaultCourses;
        String[] defaultCourse;
        String defaultSites;
        String[] defaultSite;


        for(int i=0;i<=8;i++) {
            grid.clearConstraints(courses[i]);
            grid.clearConstraints(sites[i]);
        }

        

        // Determine the semester:

        if(Objects.equals(semester, semester2)){
            defaultCourses = "Advanced Programming: .DBMS Practice: .Web Technologies: .Software Engineering: ";
            defaultCourse = defaultCourses.split("\\."); // courses names

            defaultSites = "https://profs.info.uaic.ro/~acf/java/?fbclid=IwAR0Q_9it_krfVdgcYivBkDC28mDEQ3LODDvuD0E3b3rEaHaBLqU0E--jU0M^" +
                    "https://profs.info.uaic.ro/~bd/wiki/index.php/PLSQL_0?fbclid=IwAR1l0fRWYMVM9KWun2wQRFCAi_lBw0SGak2VkajHP0NyIKaWKHtBc3DsAPY^" +
                    "https://profs.info.uaic.ro/~busaco/teach/courses/web/?fbclid=IwAR3CgV05yfpnLfdvI1st-slgTQAt_7Mt418axOhcbVjkk-ZOsB25r2Rz3J0^" +
                    "https://profs.info.uaic.ro/~adiftene/Scoala/2019/PE/index.htm?fbclid=IwAR1n60yheQBz0O9zWo5pbE2PLYKq3sFPq6_F9WFgl24ZvrWgV-jQaeyxdOM^";
            defaultSite = defaultSites.split("\\^"); // courses links

            }

        else {
            defaultCourses = "LFAC: .Graph Algorithms: .Data Bases: .Computer Networks: ";
            defaultCourse = defaultCourses.split("\\."); //courses names

            defaultSites = "https://profs.info.uaic.ro/~otto/lfac.html?fbclid=IwAR3ZY-t52BUxdJJhr8Ua0gkvSa6ThKZYVZM6XmRle72rUMl1bJJkdhV1H-Y^" +
                    "https://profs.info.uaic.ro/~olariu/curent/AG/AG.html?fbclid=IwAR0l9amS_ZZituJAIocLT3Vn4Z5DGP_rA5CNhSlKC7JZF5fngjWOGn-69jA^" +
                    "https://profs.info.uaic.ro/~bd/wiki/index.php/Pagina_principal%C4%83?fbclid=IwAR3YhaEwfpdUp74H4mfUEm3PzStktNg7R-SH8vf37rlq2h9dtTRWY_P3LwU^" +
                    "https://profs.info.uaic.ro/~computernetworks/?fbclid=IwAR3W1Vyv463NCfYLZpnCECkhqs0T36wdF4oduJgywvxjEFa8TRhR9eoWQrA^";
            defaultSite = defaultSites.split("\\^"); //courses links

            }


        // Go through all courses:

        for(int i=0;i<=defaultSite.length;i++){
            courses[i] = new Label(defaultCourse[i]); // convert course name to label
            sites[i] = new Hyperlink(defaultSite[i]); // convert course link to hyperlink
            grid.setConstraints(courses[i], 0, i+4, 3, 1); // add course name
            grid.setConstraints(sites[i], 3, i+4, 7, 1); // add link name

            grid.getChildren().addAll(courses[i], sites[i]);
        }

    }


}















