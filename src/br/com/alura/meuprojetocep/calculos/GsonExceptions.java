package br.com.alura.meuprojetocep.calculos;

import com.google.gson.annotations.SerializedName;

public class GsonExceptions {

    public static class CEP {
        @SerializedName("cep")
        public String CEP;  // Java ainda usa maiúsculo, mas vai mapear certinho

        // ... outros atributos e métodos
    }

}
