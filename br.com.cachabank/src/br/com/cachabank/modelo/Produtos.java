package br.com.cachabank.modelo;

import java.util.Scanner;

public class Produtos {
	Scanner sc = new Scanner(System.in);

	private String nome, codigo;
	private double valor;

	public Produtos() {

	}

	public Produtos(String nome, String codigo, double valor) {
		this.nome = nome;
		this.codigo = codigo;
		this.valor = valor;
	}

	public void Imprimir() {
		System.out.printf("%6s  |  %-20s  |  %.2f\n", getCodigo(), getNome(), getValor());
	}
	
	public void EntradaDados() {
		System.out.println("Código: ");
		setCodigo(sc.nextLine());
		entradaDadosAlteracao();
	}

	private void entradaDadosAlteracao() {
		System.out.println(" Nome: ");
        setNome(sc.nextLine());
        System.out.println(" Valor: ");
        setValor(sc.nextDouble());
	}
	
	public void cadastrar(String codigo, String nome, double valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	


}
