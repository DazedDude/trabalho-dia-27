public class ContaBancaria {
    private final String cliente;
    private double saldoAtual;

    public ContaBancaria(String cliente, double saldoInicial) {
        this.cliente = cliente;
        this.saldoAtual = saldoInicial;
    }

    public String getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldoAtual;
    }

    public synchronized void depositar(double valor) {
        saldoAtual += valor;
    }

    public synchronized void sacar(double valor) {
        saldoAtual -= valor;
    }
}
