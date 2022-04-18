package TesteBanco;
import br.com.cachabank.modelo.*;
import java.util.Scanner;


public class ProgRodando {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		Conta conta = new Conta();
		Cliente cliente = new Cliente();
		
		

		int slct;
		
		
		System.out.println("Bem vindo! Nosso sistema não lhe reconhece ainda, você será redirecionado para cadastrar-se");
		System.out.println();
		cliente.CadastroCliente();

		while (true) {

			System.out.printf("\n|----Bem vindo, %s!---|\n", cliente.getNome());
			System.out.printf("\n|----Seu saldo é de: R$%.2f----|\n" , conta.getSaldo()); 
			System.out.printf("\n[Impostômetro: R$%.2f]\n", conta.getValorImposto());
			System.out.println("_____________________________");
			System.out.println("O que deseja fazer?");
			System.out.println("0 -> Sair");
			System.out.println("1 -> Sacar");
			System.out.println("2 -> Depositar");
			System.out.println("3 -> Transferir");
			System.out.println("4 -> Seus dados");			
			System.out.println("_____________________________");		
			System.out.println();
			slct = sc.nextInt();
			if (slct == 0) {
				System.out.print("\nAté logo!");
				sc.close();
				break;
			}

			switch (slct) {
			
			case 1:
				conta.Sacar();
				break;

			case 2:
				conta.Depositar();
				break;

			case 3:
				conta.Transferir();
				break;
			
			case 4:
				cliente.Dados();
				break;
			default:
				throw new Exception ("-Ação não pode ser executada- Error: 2022.");
			}

		}
		
	}

}
