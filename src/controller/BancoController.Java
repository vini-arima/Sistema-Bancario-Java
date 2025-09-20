package controller;

import model.Conta;
import model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BancoController {
    private List<Conta> contas;
    private List<Cliente> clientes;
    private JsonController jsonController;
    private Scanner scanner;

    public BancoController() {
        this.jsonController = new JsonController();
        this.scanner = new Scanner(System.in);
        carregarDados();
    }

    private void carregarDados() {
        contas = jsonController.carregarContas();
        clientes = jsonController.carregarClientes();

        if (contas == null)
            contas = new ArrayList<>();
        if (clientes == null)
            clientes = new ArrayList<>();
    }

    private void salvarDados() {
        jsonController.salvarContas(contas);
        jsonController.salvarClientes(clientes);
    }

    public void criarConta() {
        System.out.println("\n --- Nova Conta ----");
        System.out.print("Numero da Conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Titular: ");
        String titular = scanner.nextLine();

        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Tipo (Corrente/Poupança): ");
        String tipo = scanner.nextLine();

        // Criar instancia para nova conta
        Conta novaConta = new Conta(numero, titular, saldo, tipo);
        contas.add(novaConta);

        salvarDados();
        System.out.println("Conta criada com sucesso!");
    }

    public void atualizarConta() {
        System.out.print("Numero da Conta para atualizar");
        int numero = scanner.nextInt();
        scanner.nextLine();

        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                System.out.print("Novo titular: ");
                conta.settitular(scanner.nextLine());

                System.out.print("Novo tipo: ");
                conta.settipo(scanner.nextLine());

                salvarDados();
                System.out.println("Conta atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada!");
    }

    public void deletarConta() {
        System.out.print("Numero da conta para deletar: ");

    }
}
