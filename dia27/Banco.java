import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BancoCentral {
    private final Estabelecimento[] estabelecimentos;
    private final Empregado[] empregados;
    private final Lock trava;

    public BancoCentral() {
        this.estabelecimentos = new Estabelecimento[2];
        this.empregados = new Empregado[4];
        this.trava = new ReentrantLock();
    }

    public void adicionarEstabelecimento(Estabelecimento estabelecimento, int indice) {
        estabelecimentos[indice] = estabelecimento;
    }

    public void adicionarEmpregado(Empregado empregado, int indice) {
        empregados[indice] = empregado;
    }

    public void realizarTransferencia(ContaBancaria origem, ContaBancaria destino, double valor) {
        trava.lock();
        try {
            if (origem.getSaldo() >= valor) {
                origem.debitar(valor);
                destino.creditar(valor);
                System.out.println("Transferência de " + valor + " realizada de " +
                        origem.getTitular() + " para " + destino.getTitular());
            } else {
                System.out.println("Saldo insuficiente para transferência de " + origem.getTitular());
            }
        } finally {
            trava.unlock();
        }
    }

    public void mostrarSaldos() {
        for (Estabelecimento estabelecimento : estabelecimentos) {
            estabelecimento.mostrarSaldo();
        }
        for (Empregado empregado : empregados) {
            empregado.mostrarSaldos();
        }
    }
}