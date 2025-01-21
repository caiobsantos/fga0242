// APLICACAO DA OPERACAO DE SUBSTITUICAO DE MÉTODO POR OBJETO-MÉTODO

package app;

public class CalculadoraImposto {
    private IRPF _irpf;
    private float imposto;

    public CalculadoraImposto(IRPF irpf) {
        _irpf = irpf;
        imposto = 0;
    }


    // APLIQUEI UM TENTATIVA DE EXTRAÇÃO DE MÉTODO PARA ESSA CLASSE FICAR MAIS COESA
    public float verificaFaixaImposto(float base, float faixa, float ali){
        if (base > faixa) {
			imposto += (base - faixa) * (ali / 100);
			base = faixa;
		} 
        return base;
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

        calculoBase = verificaFaixaImposto(calculoBase, faixa3, ali4);
        calculoBase = verificaFaixaImposto(calculoBase, faixa2, ali3);
        calculoBase = verificaFaixaImposto(calculoBase, faixa1, ali2);
        calculoBase = verificaFaixaImposto(calculoBase, faixa0, ali1);

		return imposto;
    }
}
