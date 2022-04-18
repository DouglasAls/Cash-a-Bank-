package br.com.cachabank.modelo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Conta extends Cliente implements Tributos {

	private int numerConta;
	private static double saldo;
	private double valorTransf;

	Scanner sc = new Scanner(System.in);

	public Conta() {

	}

	public Conta(String cpf, String nome, int numTel, String profissao, double renda) {
		super(cpf, nome, numTel, profissao, renda);
	}

	public void Transferir() throws InputMismatchException {
		if (saldo == 0) {
			throw new SaldoInsuficienteException("Não é possível transferir com o saldo negativo. ");
		}
		System.out.println("Transferência. Há impostos.");
		System.out.println("Digite o número da conta de quem você irá transferir: ");
		setNumerConta(sc.nextInt());
		System.out.println("Por favor, analise os dados que você digitou: " + getNumerConta());
		System.out.println("Quanto deseja transferir? ");
		try {
			setValorTransf(sc.nextDouble());
		} catch (InputMismatchException error) {
			System.out.println("Error: Não é possível acrescentar caracteres LETRAS ao invés de números " + error);
		}
		System.out.println("Confirmar transação? [1- Sim / 2- Não]");
		int op = sc.nextInt();
		if (op == 1) {
			saldo -= getValorTransf();
			saldo -= getValorImposto();
			System.out.println("Dados da transação: " + toString());
		} else if (op == 2) {
			return;
		} else {
			System.out.println("Comando inválido");
			return;
		}
	}

	public void Sacar() throws SaldoInsuficienteException {
		double valor = 0;
		if (saldo <= 0) {
			throw new SaldoInsuficienteException("Impossivel sacar um valor negativo.");
		}
		System.out.println("Sala de Sacar.");
		System.out.println("Quando deseja Sacar?");
		valor = sc.nextInt();
		Conta.saldo -= valor;
	}

	public void Depositar() throws SaldoInsuficienteException {
		int deposita;
		System.out.println("Sala para depositar");
		System.out.println("Seu saldo é de: " + saldo);
		System.out.println("Digite o quanto deseja depositar: ");
		deposita = sc.nextInt();
		if (deposita <= 0) {
			throw new SaldoInsuficienteException("Não é possível depositar um valor negativo...");
		}
		System.out.println("Valor depositado com sucesso.");
		Conta.saldo += deposita;
	}

	@Override
	public String toString() {
		return "Impostos cobrados:  " + getValorImposto() + ", " + "Você transferiu para: " + getNumerConta()
				+ ", " + "um valor de: " + getValorTransf();
	}

	@Override
	public double getValorImposto() {
		return getValorTransf() * 0.05;
	}

	// setters e getters
	public int getNumerConta() {
		return numerConta;
	}

	public void setNumerConta(int numerConta) {
		this.numerConta = numerConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		Conta.saldo = saldo;
	}

	public double getValorTransf() {
		return valorTransf;
	}

	public void setValorTransf(double valorTransf) {
		this.valorTransf = valorTransf;
	}

}

class SaldoInsuficienteException extends ArithmeticException {
	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(String msg) {
		super(msg);
	}
}
