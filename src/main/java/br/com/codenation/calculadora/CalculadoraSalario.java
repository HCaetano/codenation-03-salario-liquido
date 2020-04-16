package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		double salarioFinal = salarioBase;

		salarioFinal = this.calcularInss(salarioFinal);
		salarioFinal = this.calcularIrrf(salarioFinal);

		return Math.round(salarioFinal);
	}

	private double calcularInss(double salarioBase) {
		if (salarioBase <= 1500.00) {
			return salarioBase - salarioBase * 0.08;
		} else if (salarioBase > 1500.00 && salarioBase < 4000.00) {
			return salarioBase - salarioBase * 0.09;
		} else if (salarioBase > 4000.00) {
			return salarioBase - salarioBase * 0.11;
		}

		return 0.0;
	}

	private double calcularIrrf(double salarioComDescontoInss) {
		if (salarioComDescontoInss <= 3000.00 && salarioComDescontoInss >= 1039.00) {
			return salarioComDescontoInss;
		} else if (salarioComDescontoInss > 3000.00 && salarioComDescontoInss <= 6000.00) {
			return salarioComDescontoInss - salarioComDescontoInss * 0.075;
		} else if (salarioComDescontoInss > 6000.00) {
			return salarioComDescontoInss - salarioComDescontoInss * 0.15;
		}

		return 0.0;
	}

}