import java.util.Scanner;
public class ATM {

    Scanner sc = new Scanner(System.in);
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 0;
        int pin = 1234;
        int enteredPin = 0;
        int choice = 0;
        int attempts = 0;
        boolean validation = false;
        boolean checkPin = false;




            for(int i = 0; i < 5; i++){
                System.out.print("Enter your pin to continue: ");
                enteredPin = sc.nextInt();
                attempts++;

                if(enteredPin != pin){
                    System.out.println("incorrect! Try again");
                }else{
                    validation = true;
                    break;
                }

                if(attempts == 5){
                    System.out.print("Maximum attempts exceeded! Access Denied. Please Contact Support for any further assistance\n");
                    break;

            }


        }

               if(validation){

                   do{
                       System.out.println("------BANKING PROGRAM-------");
                       System.out.print("1. Check Balance\n2. Withdraw Money\n3. Deposit Money\n4. Change Pin\n5. Exit\nChoose an option: ");
                       choice = sc.nextInt();

                       switch(choice){
                           case 1:
                               balance = checkBalance(balance);
                               break;
                           case 2:
                               balance = withdrawMoney(balance);
                               break;
                           case 3:
                               balance = depositMoney(balance);
                               break;
                           case 4:
                               pin = changePin(pin, checkPin);
                               break;
                           case 5:
                               System.out.println("Thank you for banking with us!");
                               break;
                           default:
                               System.out.println("Invalid Choice");
                       }
                   }while(choice != 4);

               }










        sc.close();
    }

     double checkBalance(double balance){
        System.out.println("Balance = " + "$" + balance);
        return balance;
    }

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

    public int changePin(int pin, boolean checkPin){
        int enteredPin;
        int newPin = 0;
        

        do{
            System.out.print("Enter current Pin: ");
            enteredPin = sc.nextInt();
            if(pin == enteredPin){
                System.out.print("Enter new Pin: ");
                newPin = sc.nextInt();
                pin = newPin;
                System.out.println("PIN Successfully Changed to " + pin);
                checkPin = true;
            }else{
                System.out.println("Incorrect Pin!");
            }
        }while(checkPin = false);

        return newPin;
    }
}