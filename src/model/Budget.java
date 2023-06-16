package model;
import Services.Formatter;
public class Budget {
    private double shortTermSaving;
    private double mediumTermSaving;
    private double longTermSaving;
    private double wants;
    private double needs;
    private double salary;

    protected Budget(double salary){
        this.salary = salary;
    }

    public void allocateBudget(){
        shortTermSaving = Formatter.formattedDecimal(salary * 0.1);
        mediumTermSaving = Formatter.formattedDecimal(salary * 0.1);
        longTermSaving = Formatter.formattedDecimal(salary * 0.1);
        wants = Formatter.formattedDecimal(salary * 0.25);
        needs = Formatter.formattedDecimal(salary * 0.45);
    }

    //---------------------Getter and Setter--------------------//
    //----------------------------------------------------------//
    public double getShortTermSaving() {
        return shortTermSaving;
    }

    public double getMediumTermSaving() {
        return mediumTermSaving;
    }

    public double getLongTermSaving() {
        return longTermSaving;
    }

    public double getNeeds() {
        return needs;
    }

    public double getWants() {
        return wants;
    }

    public double getSalary() {
        return salary;
    }
    //----------------------------------------------------------//

    @Override
    public String toString() {
        return "Suggested budget list based on your Salary" +
                "\n- Short Term Saving = RM " + shortTermSaving +
                "\n- Medium Term Saving = RM " + mediumTermSaving +
                "\n- Long Term Saving = RM " + longTermSaving +
                "\n- Wants = RM " + wants +
                "\n- Needs = RM " + needs;
    }

}
