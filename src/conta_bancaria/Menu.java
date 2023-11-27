package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNum(), 123, 1, "Joao", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		
		
		int cod, agencia,numero,tipo,aniversario, numeroDestino;
		float saldo, valor, limite;
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
			System.out.println("|           9 - Buscar por Titular                  |");
			System.out.println("|           0 - Sair                                |");
			System.out.println("|                                                   |");
			System.out.println("o---------------------------------------------------o");
			System.out.println("|            Entre com a opção desejada:            |");
			System.out.println("o---------------------------------------------------o" + Cores.TEXT_RESET);
			
			try {
			cod = sc.nextInt();		
			}catch(InputMismatchException e) {
				System.out.println("Digite valores Inteiros");
				sc.nextLine();
				cod = 9;
			}
			if (cod == 0) {
				System.out
						.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "\nNuBanco Rosa - Lugar perfeito para sua comodidade");
				sobre();
				System.exit(0);
			}

			switch (cod) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Criar Conta\n\n");
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
				case 1 -> contas.cadastrar(new ContaCorrente(contas.gerarNum(), agencia, tipo, titular, saldo, contas.calcularLimite(saldo))); //Conta conta - Objeto conta
			//            ContaCorrente cc1(Contas(ContaController).cadastras) = new ContaCorrente(contas.gerarNum(), 123, 1, "Joao", 1000.00f, 100.00f);
				case 2 -> {
					System.out.println("Digite o Aniversário da conta: " + Cores.TEXT_RESET);
					aniversario = sc.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNum(), agencia, tipo, titular, saldo, aniversario));
				}
				}
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Consultar dados da Conta - por número\n\n");
				
				System.out.println("Digite o numero da conta: ");
				numero = sc.nextInt();
				contas.procuraPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Atualizar dados da Conta\n\n");
				
				System.out.println("Digite o numero da conta: ");
				numero = sc.nextInt();
				
				Optional<Conta> conta = contas.buscarColle(numero);
				
				if(conta.isPresent()) {
					System.out.println("Numero da agência: ");
					
					agencia = sc.nextInt();
					System.out.println("Digite o nome do Titular: ");
					sc.skip("\\R");
					titular = sc.nextLine();
					
					System.out.println("Digite o saldo da conta: ");
					saldo = sc.nextFloat();
					
					tipo = conta.get().getTipo();
					
					switch (tipo) {
					
					case 1 -> {
						System.out.println("Digite o limita da conta");
						limite = sc.nextInt();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o Aniversário da conta: ");
						aniversario = sc.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					}
					
				}else
					System.out.println("A conta numero: " + conta.get() + " não foi encontrada");
				
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Apagar a Conta\n\n");
				
				System.out.println("Digite o numero da Conta: ");
				numero = sc.nextInt();
				contas.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Saque\n\n");
				
				System.out.println("Digite o numero da Conta: ");
				numero = sc.nextInt();
				
				System.out.println("Digite o valor do saque: ");
				valor = sc.nextFloat();
				
				contas.sacar(numero, valor);
				
				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Depósito\n\n");
				
				System.out.println("Digite o numero da Conta: ");
				numero = sc.nextInt();
				
				System.out.println("Digite o valor do deposito: ");
				valor = sc.nextFloat();
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "Transferência entre Contas\n\n");
				
				System.out.println("Digite o numero da Conta de Origem: ");
				numero = sc.nextInt();
				
				System.out.println("Digite o numero da Conta de Destino: ");
				numeroDestino = sc.nextInt();
				
				if (numero != numeroDestino) {
				System.out.println("Digite o valor da tranferencia: ");
				valor = sc.nextFloat();
				
				contas.tranferir(numero, numeroDestino, valor);
				
				}else
					System.out.println("Os números das Contas são Iguais!");
				keyPress();
				break;
			case 9:
				System.out.println(tema + "Consultar conta por titular\n\n");
				
				System.out.println("Digite o nome do Titular: ");
				sc.skip("\\R");
				titular = sc.nextLine();
				
				contas.procurarPorNome(titular);
				
				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
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

	public static void keyPress() {
		try {
			System.out.println("\nPressione a tecla Enter para continaur...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla inválida!");
		}
	}

}
