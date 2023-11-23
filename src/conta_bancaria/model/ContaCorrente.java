package conta_bancaria.model; /*HERANÇA*/

public class ContaCorrente extends Conta {

	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;

	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar(float valor) {
		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\nSaldo Insuficiente");
			return false;
		}
		
		this.setSaldo(this.getSaldo()- valor);
		return true;
	}	
	/*Polimorfismo ou sobrescrever */
	@Override
	public void visual() {
		super.visual();
		System.out.println("Limite da conta: " + this.limite);
	}
}
