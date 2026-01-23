package br.senai.sp.jandira.daniele.up_students.repository;

import br.senai.sp.jandira.daniele.up_students.model.Alunos;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlunosRepository {
    private final String CAMINHO_PASTA = "src/database";
    private final String ARQUIVO_CSV = CAMINHO_PASTA + "/alunos.csv";

    public boolean salvar(Alunos aluno) {
        File pasta = new File(CAMINHO_PASTA);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        // VERIFICAÇÃO DE DUPLICIDADE: Lê todos e compara a matrícula
        List<Alunos> existentes = buscarTodos();
        for (Alunos a : existentes) {
            if (a.getMatricula().equalsIgnoreCase(aluno.getMatricula())) {
                return false; // Retorna falso e não salva se a matrícula já existir
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_CSV, true))) {
            String linha = String.format("%s;%s;%s;%s;%s",
                    aluno.getNome(), aluno.getMatricula(), aluno.getEmail(),
                    aluno.getTelefone(), aluno.getDataNascimento());
            writer.write(linha);
            writer.newLine();
            return true; // Salvo com sucesso
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Alunos> buscarTodos() {
        List<Alunos> lista = new ArrayList<>();
        File arquivo = new File(ARQUIVO_CSV);
        if (!arquivo.exists()) return lista;

        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_CSV))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados.length == 5) {
                    lista.add(new Alunos(dados[0], dados[1], dados[2], dados[3], dados[4]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}