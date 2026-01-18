package br.senai.sp.jandira.daniele.up_students.model;

public class Alunos {
    private String nome;
    private String matricula;
    private String email;
    private String telefone;
    private String dataNascimento;

    // Construtor, Getters e Setters
    public Alunos(String nome, String matricula, String email, String telefone, String dataNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

}