package testeErro;

import java.time.LocalDate;

public class ContaCorrente {
	
	private double saldo;
	private String nome;
	private String endereco;
	private String cpf;
	private String dataNascimento;
	
	public ContaCorrente(String nome, String endereco, String cpf, LocalDate dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
	}

	public boolean equals(Object obj) {
		ContaCorrente conta = (ContaCorrente) obj;
		return (conta.cpf.contentEquals(this.cpf));
	}
	
	public double getSaldo() {
		return saldo;		
	}
	public void deposita(double valor) {
		this.saldo = saldo + valor;		
	}
	public void saca(double valor) throws SaldoInsuficiente {
		if(this.saldo < valor) {
			throw new SaldoInsuficiente("Saldo Insuficiente para saque");
		}
		this.saldo = saldo - valor;		
	}
}
