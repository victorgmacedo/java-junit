package br.com.caelum.leilao.builder;

import br.com.caelum.leilao.dominio.Leilao;

public class ConstroiLeilao {

    public ConstroiLeilaoLance para(String descricao){
        return new ConstroiLeilaoLance(new Leilao(descricao));
    }

}
