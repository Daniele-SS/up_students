package br.senai.sp.jandira.daniele.up_students.ui;

import javafx.scene.layout.VBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import br.senai.sp.jandira.daniele.up_students.model.Alunos;

public class CadastroUI {

    public VBox getLayout() {
        TableView<Alunos> tabela = new TableView<>();

        // Colunas
        TableColumn<Alunos, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Alunos, String> colMatricula = new TableColumn<>("Matrícula");
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));

        TableColumn<Alunos, String> colEmail = new TableColumn<>("E-mail");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Alunos, String> colDataNascimento = new TableColumn<>("Data de Nascimento");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("data de nascimento"));

        TableColumn<Alunos, String> colTelefone = new TableColumn<>("Telefone");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        tabela.getColumns().addAll(colNome, colMatricula, colEmail,  colDataNascimento, colTelefone);

        VBox layout = new VBox(tabela);
        return layout;
    }
}
