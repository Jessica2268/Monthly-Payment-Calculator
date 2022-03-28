public class Loan {
    private String customerName;
    private int accountNumber;
    private double loanBalance;
    private double monthlyPayment;
    private double interestRate;
    private int numberOfMonthlyPayments;
    private static int numberOfLoans=1;

    public Loan (){
        customerName = "";
        loanBalance = 0;
        interestRate = 0;
        numberOfMonthlyPayments = 0;
        accountNumber = numberOfLoans;
        numberOfLoans ++;
    }
    public Loan(String name, double amount, double rate, int months){
        accountNumber = numberOfLoans;
        numberOfLoans ++;
        customerName = name;
        loanBalance = amount;
        interestRate = rate;
        numberOfMonthlyPayments = months;
    }
    public static int getNumberOfLoans(){
        return numberOfLoans;
    }
    public String getCustomerName(){
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getLoanBalance() {
        return loanBalance;
    }
    public void setLoanBalance(double loanBalance) {
        this.loanBalance = loanBalance;
    }
    public double getMonthlyPayment() {
        return monthlyPayment;
    }
    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public int getNumberOfMonthlyPayments() {
        return numberOfMonthlyPayments;
    }
    public void setNumberOfMonthlyPayments(int numberOfMonthlyPayments) {
        this.numberOfMonthlyPayments = numberOfMonthlyPayments;
    }
    public static void decreaseNumberOfLoans(){
        numberOfLoans--;
    }
    public void calculateMonthlyPayment(){
        /*
        double calculatedMonthlyPayment;
        double num;
        num = (Math.pow((1+interestRate),-numberOfMonthlyPayments));
        calculatedMonthlyPayment = (interestRate*loanBalance)/(1-num);
        monthlyPayment = calculatedMonthlyPayment;

         */

        monthlyPayment = (interestRate / 100 * loanBalance)
                / (1 - Math.pow(1 + interestRate / 100, -numberOfMonthlyPayments));
    }

    @Override
    public String toString() {
        return
                "Customer Name:" + customerName +
                ", Account Number:" + accountNumber +
                ", Loan Balance:" + loanBalance +
                ", Monthly Payment:" + monthlyPayment +
                ", Interest Rate:" + interestRate +
                ", Monthly Payment:" + numberOfMonthlyPayments;
    }
}

