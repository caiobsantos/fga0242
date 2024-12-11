package tst;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Before;
import org.junit.Test;

import app.IRPF;

public class TesteImposto {
    IRPF irpf;
	
	@Before
	public void setup() {
		irpf = new IRPF();
	}
	
	@Test
	public void TesteBaseCalculoValor() {
        irpf.criarRendimento("Salario", true, 10000);
        irpf.cadastrarDeducaoIntegral("integral", 3189.59f);
		assertEquals(987.9, irpf.calcularImposto(), 0.01);
	}

	@Test
	public void TesteBaseCalculoValor2() {
        irpf.criarRendimento("Salario", true, 6000);
        irpf.cadastrarDeducaoIntegral("integral", 1000);
		assertEquals(490.03, irpf.calcularImposto(), 0.01);
	}
}