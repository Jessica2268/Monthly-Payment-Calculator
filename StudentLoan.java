public class StudentLoan extends Loan{
    private boolean isDeferred;

    public StudentLoan(String name, double amount, double rate, int months, boolean isDef){
        super.setCustomerName(name);
        super.setLoanBalance(amount);
        super.setInterestRate(rate);
        super.setNumberOfMonthlyPayments(months);
        isDeferred = isDef;
    }

    public void setDeferred(boolean deferred) {
        isDeferred = deferred;
    }
    public boolean isDeferred() {
        return isDeferred;
    }

    @Override
    public void calculateMonthlyPayment() {
        if (isDeferred) {
            setMonthlyPayment(0);
        }else{
            super.calculateMonthlyPayment();
        }
    }

    @Override
    public String toString() {
        return "Customer Name:" + super.getCustomerName() +
                ", Account Number:" + super.getAccountNumber() +
                ", Loan Balance:" + super.getLoanBalance() +
                ", Monthly Payment:" + super.getMonthlyPayment() +
                ", Interest Rate:" + super.getInterestRate() +
                ", Monthly Payment:" + super.getNumberOfMonthlyPayments() +
                ", Deferment: "+isDeferred;
    }
}
