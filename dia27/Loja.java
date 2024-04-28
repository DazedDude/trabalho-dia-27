public class EstabelecimentoComercial {
    private final ContaBancaria contaComercial;
    private final Empregado[] empregados;

    public EstabelecimentoComercial(ContaBancaria contaComercial, Empregado[] empregados) {
        this.contaComercial = contaComercial;
        this.empregados = empregados;
    }

    public void pagarSalarios() {
        double totalSalario = 0;
        for (Empregado empregado : empregados) {
            totalSalario += empregado.getSalario();
        }
        if (contaComercial.getSaldo() >= totalSalario) {
            for (Empregado empregado : empregados) {
                contaComercial.sacar(empregado.getSalario());
                empregado.receberSalario();
            }
            System.out.println("Salários pagos aos empregados do estabelecimento.");
        } else {
            System.out.println("Saldo insuficiente para pagar os salários.");
        }
    }

    public void mostrarSaldo() {
        System.out.println("Saldo do estabelecimento: " + contaComercial.getSaldo());
    }
}

