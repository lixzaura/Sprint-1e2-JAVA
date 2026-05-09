package br.com.soulmove.veiculo;

abstract class Veiculo {
    double emissaoPorKm; // quanto de carbono o veículo emite por km rodado

    //métodos getters e setters
    public double getEmissaoPorKm() {
        return emissaoPorKm;
    }

    public void setEmissaoPorKm(double emissaoPorKm) {
        this.emissaoPorKm = emissaoPorKm;
    }

    //métodos exclusivos da classe

    public double calcularEmissao(double kmPercorrido) {
        return kmPercorrido * emissaoPorKm;
    }

    public double comparaEmissao() {
        return this.emissaoPorKm / getEmissaoPorKm();
    }
}
