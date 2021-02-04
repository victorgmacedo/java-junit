package br.com.caelum.leilao.builder;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class ConstroiLeilaoLance extends ConstroiLeilao{

    protected Leilao leilao;

    private ConstroiLeilaoLance(){
    }

    protected ConstroiLeilaoLance(Leilao leilao){
        this.leilao = leilao;
    }

    public ConstroiLeilaoLance lance(Usuario usuario, Double valor){
        leilao.propoe(new Lance(usuario, valor));
        return this;
    }

    public Leilao constroi(){
        return this.leilao;
    }

}
