package model;

public class Conta {
    private int numero;
    private String titular;
    private double saldo;
    private String tipo;

    public Conta(int numero, String titular, double saldo, String tipo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setnumero(int numero) {
        this.numero = numero;
    }

    public void setsaldo(double saldo) {
        this.saldo = saldo;
    }

    public void settitular(String titular) {
        this.titular = titular;
    }

    public void settipo(String tipo) {
        this.tipo = tipo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            this.saldo -= valor;
            // Resolver esse problema
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
