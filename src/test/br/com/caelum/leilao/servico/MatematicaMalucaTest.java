package test.br.com.caelum.leilao.servico;

import br.com.caelum.leilao.servico.MatematicaMaluca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatematicaMalucaTest {

    @Test
    public void testeContaMalucaMaiorQue30(){
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        assertEquals(124, matematicaMaluca.contaMaluca(31));
    }

    @Test
    public void testeContaMalucaMaiorQue10eMenorQue30(){
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        assertEquals(45, matematicaMaluca.contaMaluca(15));
    }

    @Test
    public void testeContaMalucaMenorQue10(){
        MatematicaMaluca matematicaMaluca = new MatematicaMaluca();
        assertEquals(10, matematicaMaluca.contaMaluca(5));
    }

}
