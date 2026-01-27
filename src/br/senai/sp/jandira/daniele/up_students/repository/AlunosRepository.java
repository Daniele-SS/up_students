package br.senai.sp.jandira.daniele.up_students.repository;

import br.senai.sp.jandira.daniele.up_students.model.Alunos;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlunosRepository {
    private final String ARQUIVO_CSV = "src/database/alunos.csv";

    public boolean salvar(Alunos aluno) {
        new File("src/database").mkdirs();

        // Impede duplicata
        if (buscarTodos().stream().anyMatch(a -> a.getMatricula().equals(aluno.getMatricula())))
            return false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_CSV, true))) {
            writer.write(String.join(";", aluno.getNome(), aluno.getMatricula(),
                    aluno.getEmail(), aluno.getTelefone(), aluno.getDataNascimento()));
            writer.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public List<Alunos> buscarTodos() {
        List<Alunos> lista = new ArrayList<>();
        File file = new File(ARQUIVO_CSV);
        if (!file.exists()) return lista;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] d = linha.split(";");
                if (d.length == 5) lista.add(new Alunos(d[0], d[1], d[2], d[3], d[4]));
            }
        } catch (IOException e) { e.printStackTrace(); }
        return lista;
    }
}