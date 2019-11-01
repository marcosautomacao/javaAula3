package testeErro;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class testeErro {
	public static void main(String[] args) {
		System.out.println("Inicio do main");
		try {
		metodo1();
		System.out.println("Fim do main");
		} catch (NullPointerException e) {
			System.out.println("Teve um erro");
		}
	}
	
	static void metodo1() {
		System.out.println("Inicio do metodo1");
		metodo2();
		System.out.println("Fim do metodo1");
	}
	
	static void metodo2() {
		System.out.println("Inicio do metodo2");
		ContaCorrente cc = new ContaCorrente("marcos", "rua 1", "123123123", LocalDate.of(2019, 10, 01));
		metodo3(cc);
		/*
		 * for (int i = 0; i < 15; i++) { cc.deposita(i+1000);
		 * System.out.println(cc.getSaldo()); if(i==5) { cc = null; } }
		 */
		}
	
	static void metodo3(ContaCorrente cc) {
		Double valueDeposita = Double.valueOf(JOptionPane.showInputDialog("valor:"));
		cc.deposita(valueDeposita);
		System.out.println("Valor final é: ");
		ContaCorrente c2 = new ContaCorrente("marcos", "rua 1", "12312123", LocalDate.of(2019, 10, 01));
		boolean cpf = cc.equals(c2);
		System.out.println("comparacao é:" + cpf);
		System.out.println(cc.getSaldo());
		Double valueSaca = Double.valueOf(JOptionPane.showInputDialog("valor:"));
		try {
			cc.saca(valueSaca);
		} catch (SaldoInsuficiente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		System.out.println("valor final 2: " + cc.getSaldo());
	}
}

