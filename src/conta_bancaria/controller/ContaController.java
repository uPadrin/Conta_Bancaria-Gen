package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

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

		Optional<Conta> conta = buscarColle(numero);

		if (conta.isPresent())
			conta.get().visual();
		else
			System.out.println("A conta numero " + numero + " não foi encontrada");
	}

	@Override
	public void listarTodas() {
		if (listaContas.isEmpty()) {
			System.out.println("Não existem contas cadastradas.");
		} else
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

		Optional<Conta> buscaConta = buscarColle(conta.getNumero());
		if (buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.println("A conta numero: " + conta.getNumero() + " foi atualizada com sucesso!");
		} else
			System.out.println("A conta numero: " + conta.getNumero() + " não foi encontrada");

	}

	@Override
	public void deletar(int numero) {

		Optional<Conta> conta = buscarColle(numero);
		if (conta.isPresent()) {
			if (listaContas.remove(conta.get()) == true)
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

	public Optional<Conta> buscarColle(int numero) {

		for (var conta : listaContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}

		return Optional.empty();
	}

	public float calcularLimite(float saldo) {
		return saldo = saldo * 0.10f;
	}

}
