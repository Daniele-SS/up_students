package br.senai.sp.jandira.daniele.up_students;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import br.senai.sp.jandira.daniele.up_students.ui.CadastroUI;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new CadastroUI().getLayout(), 900, 768);
        stage.setTitle("UpStudents");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}