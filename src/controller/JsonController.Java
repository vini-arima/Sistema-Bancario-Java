
package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;
import model.Conta;

public class JsonController {
    private static final String CONTAS_FILE = "data/contas.json";
    private static final String CLIENTES_FILE = "data/clientes.json";

    public JsonController() {
        new File("data").mkdirs();
    }

    // DUVIDA ?
    private String toJson(Object obj) {
        if (obj instanceof Conta conta) {
            return String.format("""
                    {"numero":%d,"titular":"%s","saldo":%.2f,"tipo":"%s"}
                    """,
                    conta.getNumero(),
                    conta.getTitular(),
                    conta.getSaldo(),
                    conta.getTipo());
        } else if (obj instanceof Cliente cliente) {
            return String.format("{\"cpf\":\"%s\",\"nome\":\"%s\",\"email\":\"%s\"}",
                    cliente.getCpf(),
                    cliente.getNome(),
                    cliente.getEmail());
        }
        return "{}";
    }

    // Metodos Principais

    public void salvarContas(List<Conta> contas) {
        try (FileWriter writer = new FileWriter(CONTAS_FILE)) {
            writer.write("[");
            for (int i = 0; i < contas.size(); i++) {
                writer.write(toJson(contas.get(i)));
                if (i < contas.size() - 1) {
                    writer.write(",");
                }
            }
            writer.write("]");
        } catch (IOException e) {
            System.out.println("Erro ao salvar contas: " + e.getMessage());
        }
    }

    public void salvarClientes(List<Cliente> clientes) {
        try (FileWriter writer = new FileWriter(CLIENTES_FILE)) {
            writer.write("[");

            for (int i = 0; i < clientes.size(); i++) {
                writer.write(toJson(clientes.get(i)));
                if (i < clientes.size() - 1) {
                    writer.write(",");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar contas: " + e.getMessage());
        }
    }

    public List<Conta> carregarContas() {
        throw new UnsupportedOperationException("Unimplemented method 'carregarContas'");
    }

    public List<Cliente> carregarClientes() {
        throw new UnsupportedOperationException("Unimplemented method 'carregarClientes'");
    }

}