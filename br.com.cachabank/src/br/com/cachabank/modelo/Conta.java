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
			throw new SaldoInsuficienteException("N�o � poss�vel transferir com o saldo negativo. ");
		}
		System.out.println("Transfer�ncia. H� impostos.");
		System.out.println("Digite o n�mero da conta de quem voc� ir� transferir: ");
		setNumerConta(sc.nextInt());
		System.out.println("Por favor, analise os dados que voc� digitou: " + getNumerConta());
		System.out.println("Quanto deseja transferir? ");
		try {
			setValorTransf(sc.nextDouble());
		} catch (InputMismatchException error) {
			System.out.println("Error: N�o � poss�vel acrescentar caracteres LETRAS ao inv�s de n�meros " + error);
		}
		System.out.println("Confirmar transa��o? [1- Sim / 2- N�o]");
		int op = sc.nextInt();
		if (op == 1) {
			saldo -= getValorTransf();
			saldo -= getValorImposto();
			System.out.println("Dados da transa��o: " + toString());
		} else if (op == 2) {
			return;
		} else {
			System.out.println("Comando inv�lido");
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
		System.out.println("Seu saldo � de: " + saldo);
		System.out.println("Digite o quanto deseja depositar: ");
		deposita = sc.nextInt();
		if (deposita <= 0) {
			throw new SaldoInsuficienteException("N�o � poss�vel depositar um valor negativo...");
		}
		System.out.println("Valor depositado com sucesso.");
		Conta.saldo += deposita;
	}

	@Override
	public String toString() {
		return "Impostos cobrados:  " + getValorImposto() + ", " + "Voc� transferiu para: " + getNumerConta()
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
