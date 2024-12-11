package tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;

public class TesteAliquotaEfetiva {

	IRPF irpf;
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void TesteAliquotaEfetivaValor() {
        irpf.criarRendimento("Salario", true, 6000);
        irpf.cadastrarDeducaoIntegral("previdencia", 1000);
		assertEquals(8.16, irpf.calculoAliquotaEfetiva(), 0.01);
	}
	public void TesteAliquotaEfetivaValor2() {
        irpf.criarRendimento("Salario", true, 10000);
        irpf.cadastrarDeducaoIntegral("previdencia",  3189.59f);
		assertEquals(9.87, irpf.calculoAliquotaEfetiva(), 0.01);
	}

}