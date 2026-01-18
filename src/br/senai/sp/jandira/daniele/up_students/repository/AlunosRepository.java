package br.senai.sp.jandira.daniele.up_students.repository;

import br.senai.sp.jandira.daniele.up_students.model.Alunos;
import java.util.ArrayList;
import java.util.List;

public class AlunosRepository {
    private List<Alunos> listaDeAlunos = new ArrayList<>();

    public void salvar(Alunos aluno) {
        listaDeAlunos.add(aluno);
    }

    public List<Alunos> buscarTodos() {
        return listaDeAlunos;
    }
}
