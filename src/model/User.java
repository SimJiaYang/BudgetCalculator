package model;

import Services.*;

public class User {
    private String name;
    private int age;
    private String maritalStatus;
    private String carOwnerShipStatus;
    private int child;
    private double salary;

    //-------------------------Constructor----------------------//
    public User(String name,int age, String maritalStatus, String carOwnerShipStatus,int child){
        this.name = name;
        this.age = age;
        this.maritalStatus = maritalStatus;
        this.carOwnerShipStatus = carOwnerShipStatus;
        this.child = child;
    }
    //----------------------------------------------------------//

    //---------------------Getter and Setter--------------------//
    //----------------------------------------------------------//

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
    public String getCarOwnerShipStatus() {
        return carOwnerShipStatus;
    }
    public int getChild() {return child;}
    public double getSalary() {return salary;}

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public void setCarOwnerShipStatus(String carOwnerShipStatus) {
        this.carOwnerShipStatus = carOwnerShipStatus;
    }
    public void setChild(int child) {this.child = child;}
    public void setSalary(double salary) {this.salary = salary;}
    //-----------------------------------------------------------//


    //------------Determine the Expected Budget------------------//
    public double getAllocatedBudget(){
        double budget = 0;
        if(maritalStatus == Constant.SINGLE){
            if(child == 2){
                budget = Constant.SINGLE_WITH_TWO_CHILD;
            }else if(child == 1){
                budget = Constant.SINGLE_WITH_ONE_CHILD;
            }else{
                if(age >= 60){
                    budget = Constant.SINGLE_ELDER;
                }else{
                    if(carOwnerShipStatus == Constant.CAR_OWNER){
                        budget = Constant.SINGLE_CAR_OWNER;
                    }else if(carOwnerShipStatus == Constant.PUBLIC_TRANSPORT_OWNER){
                        budget = Constant.SINGLE_PUBLIC_TRANSPORT;
                    }
                }
            }
        }else if(maritalStatus == Constant.MARRIED){
            if(child == 2){
                budget = Constant.MARRIED_WITH_TWO_CHILD;
            }else if(child == 1){
                budget = Constant.MARRIED_WITH_ONE_CHILD;
            }else if(child == 0 && age < 60){
                budget = Constant.MARRIED_WITH_NO_CHILD;
            }else{
                if (age >= 60){
                    budget = Constant.MARRIED_ELDER_COUPLE  ;
                }
            }
        }
        return Formatter.formattedDecimal(budget);
    }
    //-----------------------------------------------------------//

    //-----Compare the Want and Needs with Suggested Expenses----//
    public String compareWithSuggestedExpenses(){
        String isExceeds;
        Budget budget = new Budget(salary);
        budget.allocateBudget();

        // Get need and wants
        double needAndWants =  budget.getNeeds() + budget.getWants();

        // Get difference amount
        double getDifference = getAllocatedBudget() - needAndWants;

        // Compare
        isExceeds = (needAndWants > getAllocatedBudget())
                ? "According the government suggested expenses budget, " +
                "\nyour expenses has higher than suggested expenses budget, it has exceeded RM "  + Formatter.formattedDecimal(getDifference)
                : "According the government suggested expenses budget, " +
                "\nyour expenses has lower than suggested expenses budget, it has left RM "  + Formatter.formattedDecimal(getDifference);
        return isExceeds;
    }
    //-----------------------------------------------------------//


    //-------------------Print User Profile----------------------//
    @Override
    public String toString() {
        return
                "\n--------------------Personal Information------------------\n"+
                        "\nName: " + name +
                        "\nAge: " + age +
                        "\nMarital Status: " + maritalStatus +
                        "\nChild Quantity: " + child +
                        "\nCar OwnerShip Status: " + carOwnerShipStatus +
                        "\nSalary: RM " + Formatter.formattedDecimal(salary) +
                        "\n\n"+ compareWithSuggestedExpenses() +
                        "\n\n----------------------------------------------------------\n";
    }
    //-----------------------------------------------------------//
}
