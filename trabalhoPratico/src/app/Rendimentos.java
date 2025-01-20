package app;

public class Rendimentos {
    
    public static final boolean TRIBUTAVEL = true;
	public static final boolean NAOTRIBUTAVEL = false;
	private String[] nomeRendimento;
	private boolean[] rendimentoTributavel;
	private float[] valorRendimento;
	private int numRendimentos;
	private float totalRendimentos;

    public Rendimentos () {
        nomeRendimento = new String[0];
		rendimentoTributavel = new boolean[0];
		valorRendimento = new float[0];
    }

    public void criarRendimento(String nome, boolean tributavel, float valor) {
		//Adicionar o nome do novo rendimento
		String[] temp = new String[nomeRendimento.length + 1];
		for (int i=0; i<nomeRendimento.length; i++)
			temp[i] = nomeRendimento[i];
		temp[nomeRendimento.length] = nome;
		nomeRendimento = temp;

		//adicionar tributavel ou nao no vetor 
		boolean[] temp2 = new boolean[rendimentoTributavel.length + 1];
		for (int i=0; i<rendimentoTributavel.length; i++) 
			temp2[i] = rendimentoTributavel[i];
		temp2[rendimentoTributavel.length] = tributavel;
		rendimentoTributavel = temp2;
		
		//adicionar valor rendimento ao vetor
		float[] temp3 = new float[valorRendimento.length + 1];
		for (int i=0; i<valorRendimento.length; i++) {
			temp3[i] = valorRendimento[i];
		}
		temp3[valorRendimento.length] = valor; 
		valorRendimento = temp3;
		
		this.numRendimentos += 1;
		this.totalRendimentos += valor;
		
	}

	/**
	 * Retorna o número de rendimentos já cadastrados para o contribuinte
	 * @return numero de rendimentos
	 */
	public int getNumRendimentos() {
		return numRendimentos;
	}

	/**
	 * Retorna o valor total de rendimentos cadastrados para o contribuinte
	 * @return valor total dos rendimentos
	 */
	public float getTotalRendimentos() {
		return totalRendimentos;
	}

	/**
	 * Retorna o valor total de rendimentos tributáveis do contribuinte
	 * @return valor total dos rendimentos tributáveis
	 */
	public float getTotalRendimentosTributaveis() {
		float totalRendimentosTributaveis = 0;
		for (int i=0; i<rendimentoTributavel.length; i++) {
			if (rendimentoTributavel[i]) {
				totalRendimentosTributaveis += valorRendimento[i];
			}
		}
		return totalRendimentosTributaveis;
	}
}
