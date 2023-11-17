package conta_bancaria.model;

public class Conta {

	// Definir os atributos da classe
	
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;
	
	// Criamos o Método Construtor
	public Conta(int numero, int agencia, int tipo, String titular, float saldo)  {
		this.numero = numero;  
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
		
		
	}
	// Criamos Método get-set
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	public boolean sacar(float valor) {
		if (this.getSaldo() < valor) {
			System.out.println("\nSaldo Insuficiente");
			return false;
		}
		
		this.setSaldo(this.getSaldo()- valor);
		return true;
	}
	
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
	}
	
	// Método auxiliar visualizar()
	public void visual() {
		
		String tipo = "";
		
		switch(this.tipo) {
		
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";
		}
		System.out.println("\n\no------------------------------------o");
		System.out.println("|           Dados da Conta           |");
		System.out.println("o------------------------------------o");
		System.out.println("Numero da conta: " + this.numero);
		System.out.println("Agencia da conta: " + this.agencia);
		System.out.println("Tipo da conta: " + tipo);
		System.out.println("Titular da conta: " + this.titular);
		System.out.println("Saldo da conta: " + this.saldo);
	
	}
	
}
