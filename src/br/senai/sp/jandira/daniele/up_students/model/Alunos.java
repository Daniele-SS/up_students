package br.senai.sp.jandira.daniele.up_students.model;

public class Alunos {
    private String nome, matricula, email, telefone, dataNascimento;

    public Alunos(String nome, String matricula, String email, String telefone, String dataNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getDataNascimento() { return dataNascimento; }
}