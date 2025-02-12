package tst;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import app.Rendimentos;
import app.IRPF;
// validar situacao da poupanca com o cpr
public class TesteRendimentos {

	
	IRPF irpf;
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void test1RendimentoTributavel() {
		irpf.criarRendimento("Salario", Rendimentos.TRIBUTAVEL, 5000f);
		assertEquals(1, irpf.getNumRendimentos());
		assertEquals(5000f, irpf.getTotalRendimentos(), 0);
		assertEquals(5000f, irpf.getTotalRendimentosTributaveis(), 0);
	}
	
	@Test
	public void testeOutroRendimentoTributavel() {
		irpf.criarRendimento("Aluguel", Rendimentos.TRIBUTAVEL, 4000f);
		assertEquals(1, irpf.getNumRendimentos());
		assertEquals(4000f, irpf.getTotalRendimentos(), 0);
		assertEquals(4000f, irpf.getTotalRendimentosTributaveis(), 0);
	}
	
	@Test
	public void testDoisRendimentosTributaveis() {
		irpf.criarRendimento("Salario", Rendimentos.TRIBUTAVEL, 5000f);
		irpf.criarRendimento("Aluguel", Rendimentos.TRIBUTAVEL, 4000f);
		assertEquals(2, irpf.getNumRendimentos());
		assertEquals(9000f, irpf.getTotalRendimentos(), 0);
		assertEquals(9000f, irpf.getTotalRendimentosTributaveis(), 0);
	}
	
	@Test
	public void testeTresRendimentos() {
		irpf.criarRendimento("Salario", Rendimentos.TRIBUTAVEL, 5000f);
		irpf.criarRendimento("Aluguel", Rendimentos.TRIBUTAVEL, 4000f);
		irpf.criarRendimento("Bolsa de pesquisa", Rendimentos.NAOTRIBUTAVEL, 3000f);
		assertEquals(3, irpf.getNumRendimentos());
		assertEquals(12000f, irpf.getTotalRendimentos(), 0);
		assertEquals(9000f, irpf.getTotalRendimentosTributaveis(), 0);
	}

}
