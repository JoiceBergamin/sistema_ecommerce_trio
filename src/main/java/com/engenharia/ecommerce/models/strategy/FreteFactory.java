package com.engenharia.ecommerce.models.strategy;

import com.engenharia.ecommerce.models.enums.TipoFrete;

public class FreteFactory {
    public static FreteStrategy obterFrete(TipoFrete tipo){
        switch (tipo){
            case TERRESTRE : return new FreteTerrestre();
            case AEREO: return new FreteAereo();
            default: throw new IllegalArgumentException("Frete inválido");

        }
    }
}
