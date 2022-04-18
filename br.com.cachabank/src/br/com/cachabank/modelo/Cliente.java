package br.com.cachabank.modelo;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Cliente {
	private  String cpf;
	private String nome;
	private int NumTel;
	private String profissao;
	private  double renda;

	Scanner sc = new Scanner(System.in);

	public Cliente() {

	}

	public Cliente(String cpf, String nome, int numTel, String profissao, double renda) {
		this.cpf = cpf;
		this.nome = nome;
		this.NumTel = numTel;
		this.profissao = profissao;
		this.renda = renda;
	}

	public void CadastroCliente() throws InputMismatchException {
		System.out.println("Cadastro");
		System.out.println("Nome...: ");
		setNome(sc.nextLine());
		System.out.println("Profissão...:");
		setProfissao(sc.nextLine());
		System.out.println("CPF...: ");
		setCpf (sc.nextLine());	
		try {
			System.out.println("Qual o sua renda salarial? ");
			setRenda(sc.nextDouble());
			System.out.println("Cadastro efetuado com sucesso!\n");
		} catch (InputMismatchException error) {
			System.out.println("\nPreencha apenas com números! Você será redirecionado novamente para o cadastro.\n" + error);
			sc.nextLine();
			CadastroCliente();
		}
	
	}

	public void Dados() {
		System.out.println("Seus dados...: " + toString());
	}

	@Override
	public String toString() {
		return "\n\n[>Nome: " +  this.nome +  "\n>Seu CPF:  " + this.cpf +  "\n>Sua Profissão: " + this.profissao
				+ "\n>Sua renda salarial: " + getRenda() + "]";
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public int getNumTel() {
		return NumTel;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNumTel(int NumTel) {
		this.NumTel = NumTel;
	}

	public void setProfissao(String Profissao) {
		this.profissao = Profissao;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}


}
