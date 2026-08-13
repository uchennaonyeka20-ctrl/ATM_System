//imported java scanner for user input
import java.util.Scanner;

public class ATM {

    //instance variable declaration
    double balance = 0;
    int pin = 1234;
    int enteredPin = 0;
    int choice = 0;
    int attempts = 0;
    boolean validation = false;
    
    //Scanner object
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //atm object
        ATM atm = new ATM();




            //conditional to accept and verify user pin
            for(int i = 0; i < 5; i++){
                System.out.print("Enter your pin to continue: ");
                atm.enteredPin = atm.sc.nextInt();
                atm.attempts++;

                if(atm.enteredPin != atm.pin){
                    System.out.println("incorrect! Try again");
                }else{
                    atm.validation = true;
                    break;
                }
                //track user login attempts
                if(atm.attempts == 5){
                    System.out.print("Maximum attempts exceeded! Access Denied. Please Contact Support for any further assistance\n");
                    break;

            }


        }

               //Banking Program if Login Successful
               if(atm.validation){

                   do{
                       System.out.println("------BANKING PROGRAM-------");
                       System.out.print("1. Check Balance\n2. Withdraw Money\n3. Deposit Money\n4. Change PIN\n5. Exit\nChoose an option: ");
                       atm.choice = atm.sc.nextInt();

                       switch(atm.choice){
                           case 1:
                               atm.balance = atm.checkBalance(atm.balance);
                               break;
                           case 2:
                               atm.balance = atm.withdrawMoney(atm.balance);
                               break;
                           case 3:
                               atm.balance = atm.depositMoney(atm.balance);
                               break;
                           case 4:
                               atm.pin = atm.changePin(atm.pin);
                               break;
                           case 5:
                               System.out.println("Thank you for banking with us!");
                               break;
                           default:
                               System.out.println("Invalid Choice");
                       }
                   }while(atm.choice != 5);

               }
        //closed scanner       
        atm.sc.close();
    }
     
    
     //method to check user account balance
     double checkBalance(double balance){
        System.out.println("Balance = " + "$" + balance);
        return balance;
    }

    //method to withdraw money from user account balance
    double withdrawMoney(double balance){
        double amount;
        System.out.print("Enter amount to withdraw: ");
        amount = sc.nextDouble();
        if(amount < balance){
            balance = balance - amount;
        }else{
            System.out.println("You do not have enough money for this transaction!");
        }
        System.out.println("Balance = " + "$" + balance);
        return balance;

    }

    //method to deposit money into user account balance
    double depositMoney(double balance){
        double amount;
        System.out.print("Enter amount to deposit: ");
        amount = sc.nextDouble();
        if(amount > 0){
            balance = balance + amount;
        }else{
            System.out.println("Can't Deposit negative number");
        }
        System.out.println("Balance = " + "$" + balance);
        return balance;
    }

    //method to change user pin
    int changePin(int pin){
        int enteredPin;
        int newPin = 0;
        boolean val = true;

        do{
            System.out.print("Enter current Pin: ");
            enteredPin = sc.nextInt();
            if(pin == enteredPin){
                System.out.print("Enter new Pin: ");
                newPin = sc.nextInt();
                
                System.out.println("PIN Successfully Changed to " + pin);
                val = false;
            }else{
                System.out.println("Incorrect Pin!\n");
            }
        }while(val);

        return newPin;
    }
}