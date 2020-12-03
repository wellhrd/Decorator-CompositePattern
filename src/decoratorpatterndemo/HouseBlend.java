// Concrete Class
package decoratorpatterndemo;

public class HouseBlend implements Beverage {

    @Override
    public String getDescription() {
        return "House Blend";
    }

    @Override
    public double getCost() {
        return 18.00;
    }
    
}
