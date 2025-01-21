package app;

public class IRPF {

	private Rendimentos rendimentos;
	
	private String[] nomesDependentes;
	private String[] parentescosDependentes;
	private int numDependentes;
	
	private int numContribuicaoPrevidenciaria;
	private float totalContribuicaoPrevidenciaria;
	
	private float totalPensaoAlimenticia;
	
	private String[] nomesDeducoes;
	private float[] valoresDeducoes;

	public IRPF() {
		rendimentos = new Rendimentos();
		nomesDependentes = new String[0];
		parentescosDependentes = new String[0];
		numDependentes = 0;
		
		numContribuicaoPrevidenciaria = 0; 
		totalContribuicaoPrevidenciaria = 0f;
		
		totalPensaoAlimenticia = 0f;
		
		nomesDeducoes = new String[0];
		valoresDeducoes = new float[0];
	}
	
	/**
	 * Cadastra um rendimento na base do contribuinte, informando o nome do 
	 * rendimento, seu valor e se ele é tributável ou não. 
	 * @param nome nome do rendimento a ser cadastrado
	 * @param tributavel true caso seja tributável, false caso contrário
	 * @param valor valor do rendimento a ser cadastrado
	 */
	public void criarRendimento(String nome, boolean tributavel, float valor) {
		//Adicionar o nome do novo rendimento
		rendimentos.criarRendimento(nome, tributavel, valor);
	}

	/**
	 * Retorna o número de rendimentos já cadastrados para o contribuinte
	 * @return numero de rendimentos
	 */
	public int getNumRendimentos() {
		return rendimentos.getNumRendimentos();
	}

	/**
	 * Retorna o valor total de rendimentos cadastrados para o contribuinte
	 * @return valor total dos rendimentos
	 */
	public float getTotalRendimentos() {
		return rendimentos.getTotalRendimentos();
	}

	/**
	 * Retorna o valor total de rendimentos tributáveis do contribuinte
	 * @return valor total dos rendimentos tributáveis
	 */
	public float getTotalRendimentosTributaveis() {
		return rendimentos.getTotalRendimentosTributaveis();
	}

	/**
	 * Método para realizar o cadastro de um dependente, informando seu grau 
	 * de parentesco
	 * @param nome Nome do dependente
	 * @param parentesco Grau de parentesco
	 */
	public void cadastrarDependente(String nome, String parentesco) {
		adicionaNomeDependente(nome);
		adicionaNParentescoDependente(parentesco);
		numDependentes++;
	}

	private void adicionaNomeDependente(String nome) {
		String[] temp = new String[nomesDependentes.length + 1];
		for (int i=0; i<nomesDependentes.length; i++) {
			temp[i] = nomesDependentes[i];
		}
		temp[nomesDependentes.length] = nome;
		nomesDependentes = temp;
	}

	private void adicionaNParentescoDependente(String parentesco) {
		String[] temp = new String[parentescosDependentes.length + 1];
		for (int i=0; i<parentescosDependentes.length; i++) {
			temp[i] = parentescosDependentes[i];
		}
		temp[parentescosDependentes.length] = parentesco;
		parentescosDependentes = temp;
		
	}

	/**
	 * Método que retorna o numero de dependentes do contribuinte
	 * @return numero de dependentes
	 */
	public int getNumDependentes() {
		return numDependentes;
	}
	
	/**
	 * Return o valor do total de deduções para o contribuinte
	 * @return valor total de deducoes
	 */
	public float getDeducao() {
		float total = 0; 
		for (String d: nomesDependentes) {
			total += 189.59f;
		}
		total += totalContribuicaoPrevidenciaria;
		
		return total;
	}

	/**
	 * Cadastra um valor de contribuição previdenciária oficial
	 * @param contribuicao valor da contribuição previdenciária oficial
	 */
	public void cadastrarContribuicaoPrevidenciaria(float contribuicao) {
		numContribuicaoPrevidenciaria++;
		totalContribuicaoPrevidenciaria += contribuicao;
	}

	/**
	 * Retorna o numero total de contribuições realizadas como contribuicao 
	 * previdenciaria oficial
	 * @return numero de contribuições realizadas
	 */
	public int getNumContribuicoesPrevidenciarias() {
		return numContribuicaoPrevidenciaria;
	}

	/**
	 * Retorna o valor total de contribuições oficiais realizadas
	 * @return valor total de contribuições oficiais
	 */
	public float getTotalContribuicoesPrevidenciarias() {
		return totalContribuicaoPrevidenciaria;
	}

	/**
	 * Realiza busca do dependente no cadastro do contribuinte
	 * @param nome nome do dependente que está sendo pesquisado
	 * @return nome do dependente ou null, caso nao conste na lista de dependentes
	 */
	public String getDependente(String nome) {
		for (String d : nomesDependentes) {
			if (d.contains(nome))
				return d;
		}
		return null;
	}

	/**
	 * Método que retorna o grau de parentesco para um dado dependente, caso ele
	 * conste na lista de dependentes
	 * @param dependente nome do dependente
	 * @return grau de parentesco, nulo caso nao exista o dependente
	 */
	public String getParentesco(String dependente) {
		for (int i = 0; i<nomesDependentes.length; i++) {
			if (nomesDependentes[i].equalsIgnoreCase(dependente))
				return parentescosDependentes[i];
		}
		return null;
	}

	/**
	 * Realiza o cadastro de uma pensao alimenticia para um dos dependentes do 
	 * contribuinte, caso ele seja um filho ou alimentando. 
	 * @param dependente nome do dependente 
	 * @param valor valor da pensao alimenticia
	 */
	public void cadastrarPensaoAlimenticia(String dependente, float valor) {
		String parentesco = getParentesco(dependente); 
		if (parentesco.toLowerCase().contains("filh") || 
			parentesco.toLowerCase().contains("alimentand")) {
			totalPensaoAlimenticia += valor;
		}
	}

	/**
	 * Retorna o valor total pago em pensões alimentícias pelo contribuinte.
	 * @return valor total de pensoes alimenticias
	 */
	public float getTotalPensaoAlimenticia() {
		return totalPensaoAlimenticia;
	}

	
	/**
	 * Metodo para cadastrar deduções integrais para o contribuinte. Para cada
	 * dedução é informado seu nome e valor. 
	 * @param nome nome da deducao 
	 * @param valorDeducao valor da deducao
	 */
	public void cadastrarDeducaoIntegral(String nome, float valorDeducao) {
		String temp[] = new String[nomesDeducoes.length + 1];
		for (int i=0; i<nomesDeducoes.length; i++) {
			temp[i] = nomesDeducoes[i]; 
		}
		temp[nomesDeducoes.length] = nome;
		nomesDeducoes = temp;
		
		float temp2[] = new float[valoresDeducoes.length + 1];
		for (int i=0; i<valoresDeducoes.length; i++) {
			temp2[i] = valoresDeducoes[i]; 
		}
		temp2[valoresDeducoes.length] = valorDeducao;
		valoresDeducoes = temp2;
	}

	
	/**
	 * Método para pesquisar uma deducao pelo seu nome. 
	 * @param substring do nome da deducao a ser pesquisada
	 * @return nome da deducao, ou null caso na esteja cadastrada
	 */
	public String getOutrasDeducoes(String nome) {
		for (String d : nomesDeducoes) {
			if (d.toLowerCase().contains(nome.toLowerCase()))
				return d;
		}
		return null;
	}

	/**
	 * Obtem o valor da deducao à partir de seu nome 
	 * @param nome nome da deducao para a qual se busca seu valor
	 * @return valor da deducao
	 */
	public float getDeducao(String nome) {
		for (int i=0; i<nomesDeducoes.length; i++) {
			if (nomesDeducoes[i].toLowerCase().contains(nome.toLowerCase()))
				return valoresDeducoes[i];
		}
		return 0;
	}

	/**
	 * Obtem o valor total de todas as deduções que nao sao do tipo
	 * contribuicoes previdenciarias ou por dependentes
	 * @return valor total das outras deducoes
	 */
	public float getTotalOutrasDeducoes() {
		float soma = 0;
		for (float f : valoresDeducoes) {
			soma += f;
		}
		return soma;
	}
	
	public float calcularBaseDeCalculo() {
		float rendimentosTributaveis = getTotalRendimentosTributaveis();
		
		float deducoesTotais = getTotalOutrasDeducoes();
	
		return Math.max(0, rendimentosTributaveis - deducoesTotais);
	}

	public float calcularImposto() {
		return new CalculadoraImposto(this).calculaImposto();
	}

	public float calculoAliquotaEfetiva() {
		float rendimentosTributaveis = getTotalRendimentosTributaveis();
		float imposto = calcularImposto();
		return (imposto / rendimentosTributaveis) * 100;
	}
	
}
