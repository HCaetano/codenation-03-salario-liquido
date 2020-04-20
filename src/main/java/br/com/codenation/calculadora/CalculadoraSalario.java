package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		double salarioFinal = salarioBase;

		salarioFinal = this.calcularInss(salarioFinal);
		salarioFinal = this.calcularIrrf(salarioFinal);

		return Math.round(salarioFinal);
	}

	private double calcularInss(double salarioBase) {
		double resultado;

		if (salarioBase <= 1500.00) {
			resultado = salarioBase - salarioBase * 0.08;
		} else if (salarioBase < 4000.00) {
			resultado = salarioBase - salarioBase * 0.09;
		} else {
			resultado = salarioBase - salarioBase * 0.11;
		}

		return resultado;
	}

	private double calcularIrrf(double salarioComDescontoInss) {
		double resultado = salarioComDescontoInss;

		if(salarioComDescontoInss < 1039.00) {
			return 0.0;
		} else if (salarioComDescontoInss > 3000.00 && salarioComDescontoInss <= 6000.00) {
			resultado = salarioComDescontoInss - salarioComDescontoInss * 0.075;
		} else if (salarioComDescontoInss > 6000.00) {
			resultado = salarioComDescontoInss - salarioComDescontoInss * 0.15;
		}

		return resultado;
	}

}