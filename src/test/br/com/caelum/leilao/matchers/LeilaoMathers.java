package test.br.com.caelum.leilao.matchers;

import br.com.caelum.leilao.dominio.Leilao;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class LeilaoMathers extends TypeSafeMatcher<Leilao> {
    @Override
    protected boolean matchesSafely(Leilao item) {
        return item.getLances().size() > 0;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Leilão não possui lances");
    }

    @Factory
    public static Matcher<Leilao> temLance() {
        return new LeilaoMathers();
    }
}
