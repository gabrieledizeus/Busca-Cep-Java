package br.com.alura.meuprojetocep.modelos;

import com.google.gson.annotations.SerializedName;

public class CEPGeral {
    @SerializedName("cep")
    private String CEP;
    private String logradouro;
    private String bairro;
    private String uf;
    private String estado;
    private String ddd;

    public String getCEP() {
        return CEP;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getUf() {
        return uf;
    }

    public String getEstado() {
        return estado;
    }

    public String getDdd() {
        return ddd;
    }

    public class CEPCaseSensitive {
        @SerializedName("cep")
        public String CEP;
    }

    public CEPGeral(String logradouro, String bairro, String estado, String uf, String CEP, String ddd) {

        this.logradouro = logradouro;
        this.bairro = bairro;
        this.estado = estado;
        this.uf = uf;
        this.CEP = CEP;
        this.ddd = ddd;
    }

    @Override
    public String toString() {
        return "Endereço Completo: " + logradouro + " " + bairro + "\n"
                + "Estado: " + estado + " - " + uf + "\n"
                + "CEP: " + CEP + "\n"
                + "DDD: " + ddd + "\n";
    }

    public void exibeCEPGeral() {
            System.out.println("Endereço Completo: " + " " + logradouro + " " + bairro);
            System.out.println("Estado: " + estado + "-" + uf);
            System.out.println("CEP: " + CEP);
            System.out.println("DDD: " + ddd);

        }
    }

