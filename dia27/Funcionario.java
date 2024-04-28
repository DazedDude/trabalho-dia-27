public class Funcionario extends Thread {
    private final Conta contaSalario;
    private final Conta contaInvestimento;
    private final double salario;

    public Funcionario(Conta contaSalario, Conta contaInvestimento, double salario) {
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
        this.salario = salario;
    }

    @Override
    public void run() {
        receberSalario();
        investir();
    }

    public void receberSalario() {
        contaSalario.creditar(salario);
        System.out.println("Salário recebido por funcionário.");
    }

    public void investir() {
        double valorInvestimento = salario * 0.2;
        contaSalario.debitar(valorInvestimento);
        contaInvestimento.creditar(valorInvestimento);
        System.out.println("Investimento realizado por funcionário.");
    }

    public double getSalario() {
        return salario;
    }

    public void mostrarSaldos() {
        System.out.println("Saldo da conta salário: " + contaSalario.getSaldo());
        System.out.println("Saldo da conta investimento: " + contaInvestimento.getSaldo());
    }
}
