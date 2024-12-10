package tst;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app.IRPF;

public class TesteBaseCalculo {

	IRPF irpf;
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void TesteBaseCalculoValor() {
        irpf.criarRendimento("Salario", true, 6000);
        irpf.cadastrarDeducaoIntegral("previdencia", 1000);
		assertEquals(5000.0, irpf.calcularBaseDeCalculo(), 0.0001);
	}

}
