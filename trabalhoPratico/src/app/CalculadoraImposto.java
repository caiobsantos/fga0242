// APLICACAO DA OPERACAO DE SUBSTITUICAO DE MÉTODO POR OBJETO-MÉTODO

package app;

public class CalculadoraImposto {
    private IRPF _irpf;

    public CalculadoraImposto(IRPF irpf) {
        _irpf = irpf;
    }

    public float calculaImposto() {
        float faixa0 = 2112f;

		float faixa1 = 2826.65f;
		float ali1 = 7.5f;

		float faixa2 = 3751.05f;
		float ali2 = 15f;

		float faixa3 = 4664.68f;
		float ali3 = 22.5f;

		float ali4 = 27.5f;
		
		float calculoBase = _irpf.calcularBaseDeCalculo();
		float imposto = 0;

        if (calculoBase > faixa3) {
			imposto += (calculoBase - faixa3) * (ali4 / 100);
			calculoBase = faixa3;
		}
		if (calculoBase > faixa2) {
			imposto += (calculoBase - faixa2) * (ali3 / 100);
			calculoBase = faixa2;
		}
		if (calculoBase > faixa1) {
			imposto += (calculoBase - faixa1) * (ali2 / 100);
			calculoBase = faixa1;
		}
		if (calculoBase > faixa0) {
			imposto += (calculoBase - faixa0) * (ali1 / 100);
		}

		return imposto;
    }
}
