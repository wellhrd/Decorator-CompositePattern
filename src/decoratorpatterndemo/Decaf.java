// Concrete Class
package decoratorpatterndemo;

public class Decaf implements Beverage {

    @Override
    public String getDescription() {
        return "Defcaf";
    }

    @Override
    public double getCost() {
        return 16.00;
    }
    
}
