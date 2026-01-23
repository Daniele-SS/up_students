package br.senai.sp.jandira.daniele.up_students.ui;

import br.senai.sp.jandira.daniele.up_students.model.Alunos;
import br.senai.sp.jandira.daniele.up_students.repository.AlunosRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CadastroUI {

    public VBox getLayout() {
        AlunosRepository repo = new AlunosRepository();
        ObservableList<Alunos> listaAlunos = FXCollections.observableArrayList(repo.buscarTodos());

        // CONFIGURAÇÃO DA TABELA
        TableView<Alunos> tabela = new TableView<>();
        tabela.setItems(listaAlunos);
        tabela.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox.setVgrow(tabela, Priority.ALWAYS);

        TableColumn<Alunos, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

        TableColumn<Alunos, String> colMatricula = new TableColumn<>("Matrícula");
        colMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));

        TableColumn<Alunos, String> colEmail = new TableColumn<>("E-mail");
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Alunos, String> colTel = new TableColumn<>("Telefone");
        colTel.setCellValueFactory(new PropertyValueFactory<>("telefone"));

        TableColumn<Alunos, String> colData = new TableColumn<>("Data de Nasc.");
        colData.setCellValueFactory(new PropertyValueFactory<>("dataNascimento"));

        tabela.getColumns().addAll(colNome, colMatricula, colEmail, colTel, colData);

        // FORMULÁRIO
        TextField txtNome = new TextField(); txtNome.setPromptText("Nome");
        TextField txtMat = new TextField(); txtMat.setPromptText("Matrícula");
        TextField txtEmail = new TextField(); txtEmail.setPromptText("E-mail");
        TextField txtTel = new TextField(); txtTel.setPromptText("Telefone");
        TextField txtData = new TextField(); txtData.setPromptText("Data Nasc.");

        Button btnSalvar = new Button("Salvar");
        btnSalvar.setMinWidth(80);

        // LÓGICA DO BOTÃO COM MENSAGENS NA TELA
        btnSalvar.setOnAction(event -> {
            String nome = txtNome.getText().trim();
            String matricula = txtMat.getText().trim();
            String email = txtEmail.getText().trim();
            String telefone = txtTel.getText().trim();
            String data = txtData.getText().trim();

            // 1. Verificar se todos os campos estão preenchidos
            if (nome.isEmpty() || matricula.isEmpty() || email.isEmpty() || telefone.isEmpty() || data.isEmpty()) {
                exibirMensagem("Erro", "Campos Incompletos", "Preencha todos os campos!", Alert.AlertType.WARNING);
                return;
            }

            // 2. Validar se Matrícula e Telefone contêm APENAS números
            if (!matricula.matches("\\d+") || !telefone.matches("\\d+")) {
                exibirMensagem("Erro de Formato", "Apenas Números", "Matrícula e Telefone devem conter apenas números (letras não são permitidas).", Alert.AlertType.ERROR);
                return;
            }

            // 3. Validar tamanho exato da Matrícula (8 dígitos)
            if (matricula.length() != 8) {
                exibirMensagem("Erro de Tamanho", "Matrícula Inválida", "A matrícula deve ter exatamente 8 números.", Alert.AlertType.ERROR);
                return;
            }

            // 4. Validar Nome Completo (pelo menos Nome e Sobrenome)
            if (!nome.contains(" ")) {
                exibirMensagem("Erro", "Nome Incompleto", "Insira o nome e o sobrenome do aluno.", Alert.AlertType.WARNING);
                return;
            }

            // 5. Validar E-mail (mínimo de estrutura)
            if (!email.contains("@") || !email.contains(".")) {
                exibirMensagem("Erro", "E-mail Inválido", "O e-mail deve ser completo (ex: aluno@escola.com).", Alert.AlertType.WARNING);
                return;
            }

            // Se passar por todas as travas, tenta salvar
            Alunos novo = new Alunos(nome, matricula, email, telefone, data);
            if (repo.salvar(novo)) {
                listaAlunos.add(novo);
                exibirMensagem("Sucesso", "Aluno Cadastrado", "Dados validados e salvos com sucesso!", Alert.AlertType.INFORMATION);
                txtNome.clear(); txtMat.clear(); txtEmail.clear(); txtTel.clear(); txtData.clear();
            } else {
                exibirMensagem("Erro", "Duplicidade", "Esta matrícula já está cadastrada.", Alert.AlertType.ERROR);
            }
        });

        HBox formulario = new HBox(10, txtNome, txtMat, txtEmail, txtTel, txtData, btnSalvar);
        formulario.setAlignment(Pos.CENTER);
        // HGrow apenas nos campos de texto para não esmagar o botão
        HBox.setHgrow(txtNome, Priority.ALWAYS); HBox.setHgrow(txtMat, Priority.ALWAYS);

        VBox layoutPrincipal = new VBox(20, formulario, tabela);
        layoutPrincipal.setPadding(new Insets(20));

        return layoutPrincipal;
    }

    // MÉTODO AUXILIAR PARA EXIBIR MENSAGENS (Alertas na Stage)
    private void exibirMensagem(String titulo, String cabecalho, String conteudo, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(conteudo);
        alerta.showAndWait();
    }
}