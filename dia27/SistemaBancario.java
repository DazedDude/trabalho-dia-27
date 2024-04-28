public class SistemaFinanceiro {
    public static void main(String[] args) {
        BancoCentral bancoCentral = new BancoCentral();

        ContaBancaria contaEstabelecimento1 = new ContaBancaria("Conta Estabelecimento 1", 0);
        ContaBancaria contaEstabelecimento2 = new ContaBancaria("Conta Estabelecimento 2", 0);

        Empregado[] empregadosEstabelecimento1 = {
                new Empregado(new ContaBancaria("Salário Empregado1 Estabelecimento1", 0), 1400),
                new Empregado(new ContaBancaria("Salário Empregado2 Estabelecimento1", 0), 1400)
        };
        Empregado[] empregadosEstabelecimento2 = {
                new Empregado(new ContaBancaria("Salário Empregado1 Estabelecimento2", 0), 1400),
                new Empregado(new ContaBancaria("Salário Empregado2 Estabelecimento2", 0), 1400)
        };

        EstabelecimentoComercial estabelecimento1 = new EstabelecimentoComercial(contaEstabelecimento1, empregadosEstabelecimento1);
        EstabelecimentoComercial estabelecimento2 = new EstabelecimentoComercial(contaEstabelecimento2, empregadosEstabelecimento2);

        bancoCentral.adicionarEstabelecimento(estabelecimento1, 0);
        bancoCentral.adicionarEstabelecimento(estabelecimento2, 1);

        for (int i = 1; i <= 5; i++) {
            Comprador comprador = new Comprador(new ContaBancaria("Comprador " + i, 1000));
            comprador.start();
        }

        estabelecimento1.pagarSalarios();
        estabelecimento2.pagarSalarios();
    }
}
