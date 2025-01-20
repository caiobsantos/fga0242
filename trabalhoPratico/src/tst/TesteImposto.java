package tst;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import app.IRPF;

@RunWith(Parameterized.class)
public class TesteImposto {

    IRPF irpf;
    private float rendimento;
    private float deducao;
    private float expectedImposto;

    public TesteImposto(float rendimento, float deducao, float expectedImposto) {
        this.rendimento = rendimento;
        this.deducao = deducao;
        this.expectedImposto = expectedImposto;
    }

    @Before
    public void setup() {
        irpf = new IRPF();
    }

    @Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
            { 10000, 3189.59f, 987.9f },
            { 6000, 1000, 490.03f },
            { 15000, 5000, 1865.03f },
            { 20000, 7000, 2690.03f }
        });
    }

    @Test
    public void TesteImpostoValor() {
        irpf.criarRendimento("Salario", true, rendimento);
        irpf.cadastrarDeducaoIntegral("integral", deducao);
        assertEquals(expectedImposto, irpf.calcularImposto(), 0.01);
    }
}