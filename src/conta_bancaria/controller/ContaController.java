package conta_bancaria.controller;

import java.util.ArrayList;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	// Cria a Collection
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	// Variavel para receber o numero da conta
	int numero = 0;

	@Override
	public void procuraPorNumero(int numero) {
		// TODO Auto-generated method stub

	}

	@Override
	public void listarTodas() {
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
		// TODO Auto-generated method stub

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

	public float calcularLimite(float saldo) {
		return saldo = saldo * 0.10f;
	}

}
