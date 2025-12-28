package br.senai.sp.jandira.daniele.cadastro_alunos.model;

public class Alunos {
    public String nome;
    public String curso;
    public String matricula;
    public String email;
    public String nota;

    public void exibirAluno () {
        System.out.println("Nome: " + nome);
        System.out.println("Curso de Ensino: " + curso);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Email: " + email);
        System.out.println("Nota final: " + nota);
    }
}
