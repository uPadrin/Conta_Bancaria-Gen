package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNum(), 123, 1, "Joao", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		
		
		int cod, numero, agencia,tipo,aniversario ;
		float saldo,limite;
		String titular;
		
		while (true) {

			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_PURPLE_BOLD_BRIGHT);
			System.out.println("o---------------------------------------------------o");
			System.out.println("|                                                   |");
			System.out.println("|                   NuBanco Rosa                    |");
			System.out.println("|                                                   |");
			System.out.println("o---------------------------------------------------o");
			System.out.println("|                                                   |");
			System.out.println("|           1 - Criar Conta                         |");
			System.out.println("|           2 - Listar todas as Contas              |");
			System.out.println("|           3 - Buscar Conta por Numero             |");
			System.out.println("|           4 - Atualizar Dados da Conta            |");
			System.out.println("|           5 - Apagar Conta                        |");
			System.out.println("|           6 - Sacar                               |");
			System.out.println("|           7 - Depositar                           |");
			System.out.println("|           8 - Transferir valores entre Contas     |");
			System.out.println("|           0 - Sair                                |");
			System.out.println("|                                                   |");
			System.out.println("o---------------------------------------------------o");
			System.out.println("|            Entre com a opção desejada:            |");
			System.out.println("o---------------------------------------------------o" + Cores.TEXT_RESET);
			cod = sc.nextInt();

			if (cod == 0) {
				System.out
						.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "\nNuBanco Rosa - Lugar perfeito para sua comodidade");
				sobre();
				System.exit(0);
			}

			switch (cod) {
			case 1:
				System.out.println("Numero da agência: ");
				agencia = sc.nextInt();
				System.out.println("Digite o nome do Titular: ");
				sc.skip("\\R");
				titular = sc.nextLine();
				System.out.println("Digite o Tipo da conta(1 - CC ou 2 - CP): ");
				tipo = sc.nextInt();

				System.out.println("Digite o saldo da conta: ");
				saldo = sc.nextFloat();

				switch (tipo) {
				case 1 -> contas.cadastrar(new ContaCorrente(contas.gerarNum(), agencia, tipo, titular, saldo, contas.calcularLimite(saldo)));
			
				case 2 -> {
					System.out.println("Digite o Aniversário da conta: ");
					aniversario = sc.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNum(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Listar todas as Contas\n\n");
				contas.listarTodas();
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Consultar dados da Conta - por número\n\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Atualizar dados da Conta\n\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Apagar a Conta\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Saque\n\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Depósito\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Transferência entre Contas\n\n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				break;
			}

		}
	}

	public static String tema = Cores.TEXT_PURPLE_BOLD_BRIGHT;

	public static void sobre() {
		System.out.println(tema);
		System.out.println("\no-------------------------------------------------------o");
		System.out.println("|Projeto Desenvolvido por:                              |");
		System.out.println("|Bryan S Vieira - bryan.vieira2013@gmail.com            |");
		System.out.println("|github.com/uPadrin                                     |");
		System.out.println("o-------------------------------------------------------o");
	}

}
