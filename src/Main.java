import Services.Constant;
import model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = "";
        int age = 0;
        int maritalStatusNumber = 0;
        String maritalStatus = "";
        int childQuantity = 0;
        int carOwnerShipStatusNumber = 0;
        String carOwnerShipStatus =  "";
        double salary;

        Scanner input = new Scanner(System.in);
        boolean validInput = false;

        //--------------Welcome to Budget Calculator----------------//
        System.out.println("\n--------------Welcome to Budget Calculator----------------");
        System.out.println("---------Please enter your Personal Information-----------\n");
        System.out.print("Please enter your name: ");
        name = input.next();

        //--------------------Age validation------------------------//
        while(!validInput){
            try{
                System.out.print("Please enter your age (12-100): ");
                age = input.nextInt();
                while (age < 12 || age > 100) {
                    System.out.print("\nPlease enter a valid age (12 -100): ");
                    age = input.nextInt();
                }
                validInput = true;
            }catch (Exception e){
                System.out.println("\nInvalid input! Please enter a valid integer.");
                // Clear the keyboard input
                input.nextLine();
            }
        }

        validInput = false;


        //-------------------Marital validation---------------------//
        while (!validInput){
            try{
                System.out.print("Please enter your marital status (1:Single,2:Married): ");
                maritalStatusNumber = input.nextInt();
                while (maritalStatusNumber<1 || maritalStatusNumber>2) {
                    System.out.print("\nPlease enter a valid marital status (1:Single,2:Married): ");
                    maritalStatusNumber  = input.nextInt();
                }
                validInput = true;
            }catch (Exception e){
                System.out.print("\nPlease enter a valid marital status (1:Single,2:Married): ");
                // Clear the keyboard input
                input.nextLine();
            }
        }

        validInput = false;


        //-----------------Child Quantity validation----------------//
        while (!validInput){
            try{
                System.out.print("Please enter your child quantity (0-2 child): ");
                childQuantity = input.nextInt();
                while (childQuantity<0 || childQuantity>2) {
                    System.out.print("\nPlease enter a valid child quantity (0-2 child): ");
                    childQuantity  = input.nextInt();
                }
                validInput = true;
            }catch (Exception e){
                System.out.print("\nPlease enter a valid child quantity (0-2 child): ");
                // Clear the keyboard input
                input.nextLine();
            }
        }

        validInput = false;

        //-----------------Car Ownership validation-----------------//
        while (!validInput){
            try{
                System.out.print("Please enter your car ownership status (0:Public Transport,1:Self-Car): ");
                carOwnerShipStatusNumber = input.nextInt();
                while (carOwnerShipStatusNumber<0 || carOwnerShipStatusNumber>1) {
                    System.out.print("\nPlease enter a valid car ownership status (0:Public Transport,1:Self-Car): ");
                    carOwnerShipStatusNumber  = input.nextInt();
                }
                validInput = true;
            }catch (Exception e){
                System.out.print("\nPlease enter a valid car ownership status (0:Public Transport,1:Self-Car): ");
                // Clear the keyboard input
                input.nextLine();
            }
        }

        validInput = false;


        //----------------------------------------------------------//

        //--------------Make the main thread sleep------------------//
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread Error");
            System.exit(0);
        }


        //---------------------Pass the data------------------------//
        if(maritalStatusNumber == 1){
            maritalStatus = Constant.SINGLE;
        }else if(maritalStatusNumber == 2){
            maritalStatus = Constant.MARRIED;
        }
        if(carOwnerShipStatusNumber == 0){
            carOwnerShipStatus = Constant.PUBLIC_TRANSPORT_OWNER;
        } else if (carOwnerShipStatusNumber == 1) {
            carOwnerShipStatus = Constant.CAR_OWNER;
        }

        User user = new User(name,age, maritalStatus, carOwnerShipStatus,childQuantity);
        //----------------------------------------------------------//

        //------------------Suggested Expenses Budget---------------//
        System.out.println("\n\n\n-----------------Suggested Expenses Budget----------------");
        System.out.println("\nFor Johor Bahru, the average expenses budget for you is RM " + user.getAllocatedBudget());
        System.out.println("\n----------------------------------------------------------");
        //----------------------------------------------------------//

        //---------------------Enter the Salary---------------------//
        System.out.println("\n\n\n-------------------Provide us your Salary-----------------");
        while (!validInput){
            try{
                System.out.print("\nPlease enter your salary: ");
                salary = input.nextDouble();
                while (salary <=0){
                    System.out.print("\nPlease enter a valid salary: ");
                    salary = input.nextDouble();
                }
                user.setSalary(salary);
                validInput = true;
            }catch (Exception e){
                System.out.print("\nPlease enter a valid salary: ");
                // Clear the keyboard input
                input.nextLine();
            }
        }

        System.out.println("\n----------------------------------------------------------");
        //----------------------------------------------------------//


        //--------------Compare with Suggested Expenses-------------//
        System.out.println("\n\n\n----------------------Compare Result----------------------");
        System.out.println("\n" + user.compareWithSuggestedExpenses());
        System.out.println("\n----------------------------------------------------------");
        //----------------------------------------------------------//

        //----------------------User Information--------------------//
        System.out.println("\n" + user.toString());
        //----------------------------------------------------------//

        input.close();
    }

}