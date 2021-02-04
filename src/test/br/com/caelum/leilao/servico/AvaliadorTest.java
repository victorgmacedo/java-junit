package test.br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.builder.ConstroiLeilao;
import br.com.caelum.leilao.servico.Avaliador;
import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static test.br.com.caelum.leilao.matchers.LeilaoMathers.temLance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AvaliadorTest {

    private Avaliador avaliador;
    private Usuario maria;
    private Usuario jose;
    private Usuario joao;

    @BeforeEach
    public void before(){
       this.avaliador = new Avaliador();

        maria = new Usuario("Maria");
        joao = new Usuario("Jõao");
        jose = new Usuario("José");

        System.out.println("Executado sempre que um novo test é iniciado");
    }

    @AfterEach
    public void after(){
        System.out.println("Executado sempre que o test termina");
    }

    @BeforeAll
    public void beforeAll(){
        System.out.println("Executado uma vez no começo dos testes");
    }

    @AfterAll
    public void afterAll(){
        System.out.println("Executado uma vez no fim dos testes");
    }

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        Leilao leilao = new ConstroiLeilao()
                .para("Play Station")
                .lance(joao, 300d)
                .lance(jose, 400d)
                .lance(maria, 500d)
                .constroi();
        avaliador.avalia(leilao);

        assertThat(avaliador.getMaiorLance(), equalTo(500d));
        assertThat(avaliador.getMenorLance(), equalTo(300d));
        assertThat(avaliador.getValorMedio(), equalTo(400d));
    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance(){
        Leilao leilao = new Leilao("Play Station");
        leilao.propoe(new Lance(joao, 300d));

        avaliador.avalia(leilao);

        assertThat(leilao, temLance());
        assertThat(avaliador.getMaiorLance(), equalTo(300d));
        assertThat(avaliador.getMaiorLance(), equalTo(300d));
        assertThat(avaliador.getValorMedio(), equalTo(300d));
    }

    @Test
    public void deveEncontrarOsTresMaioresLances(){
        Leilao leilao = new ConstroiLeilao()
                .para("Play Station")
                .lance(joao, 300d)
                .lance(jose, 400d)
                .lance(maria, 500d)
                .lance(jose, 700d)
                .lance(jose, 800d)
                .constroi();
        avaliador.avalia(leilao);

        assertThat(3, equalTo(avaliador.getTresMaiores().size()));
        assertThat(avaliador.getTresMaiores(), hasItems(
                new Lance(jose, 800d),
                new Lance(jose, 700d),
                new Lance(maria, 500d)
        ));
    }

    @Test
    public void deveEncontrarOsMaioresLancesComApenasDoisLances(){
        Leilao leilao = new ConstroiLeilao()
                .para("Play Station")
                .lance(joao, 300d)
                .lance(maria, 800d)
                .constroi();

        avaliador.avalia(leilao);

        assertThat(2, equalTo(avaliador.getTresMaiores().size()));
        assertThat(avaliador.getTresMaiores(), hasItems(
                new Lance(joao, 300d),
                new Lance(maria, 800d)
        ));
    }

    @Test
    public void deveRetornarListaVaziaDosMaioresLances(){
        Leilao leilao = new Leilao("Play Station");
        Assertions.assertThrows(RuntimeException.class, () -> {
            avaliador.avalia(leilao);
        });
    }



}
