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
public class TesteBaseCalculo {

    IRPF irpf;
    private float rendimento;
    private float deducao;
    private float expectedBaseCalculo;

    public TesteBaseCalculo(float rendimento, float deducao, float expectedBaseCalculo) {
        this.rendimento = rendimento;
        this.deducao = deducao;
        this.expectedBaseCalculo = expectedBaseCalculo;
    }

    @Before
    public void setup() {
        irpf = new IRPF();
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
            { 6000, 1000, 5000f },
            { 10000, 3189.59f, 6810.41f },
            { 15000, 5000, 10000 },
            { 20000, 7000, 13000 }
        });
    }

    @Test
    public void TesteBaseCalculoValor() {
        irpf.criarRendimento("Salario", true, rendimento);
        irpf.cadastrarDeducaoIntegral("previdencia", deducao);
        assertEquals(expectedBaseCalculo, irpf.calcularBaseDeCalculo(), 0.0001);
    }
}
