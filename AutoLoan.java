public class AutoLoan extends Loan {
    private double downPayment;

    public AutoLoan(String name, double amount, double rate, int months, double down) {
        super.setCustomerName(name);
        super.setLoanBalance(amount);
        super.setInterestRate(rate);
        super.setNumberOfMonthlyPayments(months);
        downPayment = down;
    }
    public double getDownPayment() {
        return downPayment;
    }
    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    @Override
    public void calculateMonthlyPayment() {
        setLoanBalance(getLoanBalance()-downPayment);
        super.calculateMonthlyPayment();
    }
    @Override
    public String toString() {
        return "Customer Name:" + super.getCustomerName() +
                ", Account Numbe:" + super.getAccountNumber() +
                ", Loan Balance:" + super.getLoanBalance() +
                ", Monthly Payment:" + super.getMonthlyPayment() +
                ", Interest Rate:" + super.getInterestRate() +
                ", Monthly Payment:" + super.getNumberOfMonthlyPayments() +
                ", Down Payment:" + downPayment;
    }
}