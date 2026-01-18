package br.senai.sp.jandira.daniele.up_students;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import br.senai.sp.jandira.daniele.up_students.ui.CadastroUI;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Instancia a sua classe de UI
        CadastroUI telaCadastro = new CadastroUI();

        // Define a cena com o layout da CadastroUI
        // Tamanho do stage (tela)
        Scene scene = new Scene(telaCadastro.getLayout(), 1000, 900);

        primaryStage.setTitle("Sistema de Gestão de Alunos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}