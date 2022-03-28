/*
——————————————————————————————————————————
Name: Jessica Ly
Created a basic loan management system that
stores Customer Name, Account Number,
Loan Balance, Interest Rates, Number of
Monthly Payments, and Down Payments.
Calculates Monthly Payments using data
entered.

Emphasizes topics learned in class such as
Inheritance, Polymorphism, Super/Base,
ArrayLists, Static Variables/methods,
ToString Overrides.
——————————————————————————————————————————
*/
import java.util.ArrayList;
import java.util.Scanner;
public class Driver {
    static Scanner scan = new Scanner(System.in);
    public static void addLoan(ArrayList<Loan> loanArrayList){
        System.out.println("Enter Loan Type (1-Student, 2-Auto):");
        int LoanType = scan.nextInt();
        System.out.println("Enter Customer Name:");
        scan.nextLine();
        String customerName = scan.nextLine();
        System.out.println("Enter Loan Amount:");
        double loanAmount = scan.nextDouble();
        System.out.println("Enter Interest Rate:");
        double interestRate = scan.nextDouble();
        System.out.println("Enter Number of Monthly Payments:");
        int numMonthlyPayments = scan.nextInt();
        if (LoanType == 1){
            boolean loanDeferred;
            System.out.println("Is Loan Deferred? (Y or N)");
            scan.nextLine();
            String loan = scan.nextLine();
            if (loan.equalsIgnoreCase("Y")){
                loanDeferred = true;
            }
            else{
                loanDeferred = false;
            }
            StudentLoan newStudentLoan = new StudentLoan(customerName,loanAmount,interestRate,numMonthlyPayments, loanDeferred);
            loanArrayList.add(newStudentLoan);
        }
        if (LoanType == 2){
            System.out.println("Enter Amount of Down Payment:");
            double downPayment = scan.nextDouble();
            AutoLoan newAutoLoan = new AutoLoan(customerName,loanAmount,interestRate,numMonthlyPayments,downPayment);
            loanArrayList.add(newAutoLoan);
        }
    }
    public static void deleteLoan(ArrayList<Loan> loanArrayList){
        System.out.println("Enter Customer Name:");
        scan.nextLine();
        String customerName = scan.nextLine();
        for (int i=0; i < loanArrayList.size(); i++){
            if (loanArrayList.get(i).getCustomerName().equalsIgnoreCase(customerName)){
                loanArrayList.remove(i);
                Loan.decreaseNumberOfLoans();
            }
        }
    }
    public static void calculateMonthlyLoanPayment(ArrayList<Loan> loanArrayList){
        for (int i=0; i < loanArrayList.size(); i++){
            loanArrayList.get(i).calculateMonthlyPayment();
        }
    }
    public static void printLoans(ArrayList<Loan> loanArrayList){
        for (int i=0; i < loanArrayList.size(); i++){
            System.out.println(loanArrayList.get(i).toString());
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int choice;
        ArrayList<Loan> newLoan = new ArrayList<>();
        do{
            System.out.println("1-Add Loan");
            System.out.println("2-Delete Loan");
            System.out.println("3-Calculate Monthly Payments");
            System.out.println("4-Print Loans");
            System.out.println("5-Exit");
            System.out.println("\nEnter Choice:");
            choice = scan.nextInt();
            if (choice > 5){
                System.out.println("Error: Please enter Valid Input\n");
            }
            switch(choice){
                case 1: addLoan(newLoan);
                    break;
                case 2: deleteLoan(newLoan);
                    break;
                case 3: calculateMonthlyLoanPayment(newLoan);
                    break;
                case 4:printLoans(newLoan);
                    break;
            }
        }while (choice != 5);

    }
}
