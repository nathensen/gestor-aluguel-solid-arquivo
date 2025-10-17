package com.tecdes.aluguel.repository;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AluguelRepository {

    private final String caminhoArquivo = "data/alugueis.txt";

    public void salvar(String registro) {
        try (FileWriter fw = new FileWriter(caminhoArquivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(registro);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar aluguel: " + e.getMessage());
        }
    }

    public List<String> listar() {
        List<String> alugueis = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                alugueis.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return alugueis;
    }
}