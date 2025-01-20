package tst;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.IRPF;

@RunWith(Parameterized.class)
public class TesteAliquotaEfetiva {

	IRPF irpf;
	private float rendimento;
	private float deducao;
	private float expectedAliquota;

	public TesteAliquotaEfetiva(float rendimento, float deducao, float expectedAliquota) {
		this.rendimento = rendimento;
		this.deducao = deducao;
		this.expectedAliquota = expectedAliquota;
	}
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		return Arrays.asList(new Object[][] {
			{ 6000, 1000, 8.16f },
			{ 10000, 3189.59f, 9.87f },
			{ 15000, 5000, 12.43f },
            { 20000, 7000, 13.45f }
		});
	}
	
	@Test
	public void TesteValor() {
        irpf.criarRendimento("Salario", true, rendimento);
        irpf.cadastrarDeducaoIntegral("previdencia", deducao);
		assertEquals(expectedAliquota, irpf.calculoAliquotaEfetiva(), 0.01);
	}
}