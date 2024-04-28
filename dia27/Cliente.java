public class Comprador extends Thread {
    private final ContaBancaria contaBancaria;

    public Comprador(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public void run() {
        while (contaBancaria.getSaldo() > 0) {
            double valorCompra = Math.random() > 0.5 ? 100 : 200;
            if (contaBancaria.getSaldo() >= valorCompra) {
                contaBancaria.sacar(valorCompra);
                System.out.println("Comprador realizou uma compra de " + valorCompra);
            }
        }
        System.out.println("Comprador esgotou o saldo da conta bancária.");
    }
}

