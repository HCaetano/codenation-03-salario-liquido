package br.com.codenation.calculadora;

public class CalculadoraSalario {

	final private double SALARIO_MINIMO = 1039.00;
	final private double INSS_FAIXA_1 = 1500.00;
	final private double INSS_FAIXA_2 = 4000.00;
	final private double INSS_ALIQUOTA_1 = 0.08;
	final private double INSS_ALIQUOTA_2 = 0.09;
	final private double INSS_ALIQUOTA_3 = 0.11;
	final private double IRRF_FAIXA_1 = 3000.00;
	final private double IRRF_FAIXA_2 = 6000.00;
	final private double IRRF_ALIQUOTA_1 = 0.075;
	final private double IRRF_ALIQUOTA_2 = 0.15;

	public long calcularSalarioLiquido(double salarioBase) {
		double salarioFinal = salarioBase;

		if(salarioFinal < SALARIO_MINIMO) {
			return Math.round(0.0);
		}

		salarioFinal = this.calcularInss(salarioFinal);
		salarioFinal = this.calcularIrrf(salarioFinal);

		return Math.round(salarioFinal);
	}

	private double calcularInss(double salarioBase) {
		double resultado;

		if (salarioBase <= INSS_FAIXA_1) {
			resultado = salarioBase - salarioBase * INSS_ALIQUOTA_1;
		} else if (salarioBase < INSS_FAIXA_2) {
			resultado = salarioBase - salarioBase * INSS_ALIQUOTA_2;
		} else {
			resultado = salarioBase - salarioBase * INSS_ALIQUOTA_3;
		}

		return resultado;
	}

	private double calcularIrrf(double salarioComDescontoInss) {
		double resultado = salarioComDescontoInss;

		if (salarioComDescontoInss > IRRF_FAIXA_1 && salarioComDescontoInss <= IRRF_FAIXA_2) {
			resultado = salarioComDescontoInss - salarioComDescontoInss * IRRF_ALIQUOTA_1;
		} else if (salarioComDescontoInss > IRRF_FAIXA_2) {
			resultado = salarioComDescontoInss - salarioComDescontoInss * IRRF_ALIQUOTA_2;
		}

		return resultado;
	}

}