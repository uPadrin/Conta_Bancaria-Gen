package conta_bancaria.controller;

import java.util.ArrayList;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	// Cria a Collection
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	// Conta = class
	// Variavel para receber o numero da conta
	int numero = 0;

	@Override
	public void procuraPorNumero(int numero) {
		var conta = buscarColle(numero);
		if (conta != null)
			conta.visual();
		else
			System.out.println("A conta numero " + numero + " não foi encontrada");
	}

	@Override
	public void listarTodas() {
		if(listaContas.isEmpty()) {
            System.out.println("Não existem contas cadastradas.");
        }else
		for (var conta : listaContas) {
			conta.visual();

		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("A Conta numero: " + conta.getNumero() + " foi criada com sucesso");
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(int numero) {
		var conta = buscarColle(numero);
		if (conta != null) {
			if (listaContas.remove(conta) == true)
				System.out.println("A conta numero: " + numero + " foi excluida com sucesso!");
	} else
				System.out.println("A conta numero " + numero + " não foi encontrada");

	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tranferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub

	}

	// Métodos aux

	public int gerarNum() {
		return ++numero;
	}

	public Conta buscarColle(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero)
				return conta;
		}
		return null;
	}

	public float calcularLimite(float saldo) {
		return saldo = saldo * 0.10f;
	}

}
