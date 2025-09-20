package view;

public class BancoView {
    private int opcao;

    public void exibir() {
        while (opcao != 0) {
            System.out.println("\n=== SISTEMA BANCÁRIO ===");
            System.out.println("1. Criar Conta");
            System.out.println("2. Listar Contas");
            System.out.println("3. Atualizar Conta");
            System.out.println("4. Deletar Conta");
            System.out.println("5. Depositar");
            System.out.println("6. Sacar");
            System.out.println("7. Criar Cliente");
            System.out.println("8. Listar Clientes");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
        }
    }
}
