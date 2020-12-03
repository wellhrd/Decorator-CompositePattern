
package decoratorpatterndemo;

public class Milk extends OptionDecorator {
    
    public Milk(Beverage decoratedbeverage) {
        super(decoratedbeverage); //Super refers to the immediate parent class: in that case 'decoratedbeverage
    }
    
    @Override
    public String getDescription(){
        return "Milk";
    }
    
    @Override
    public double getCost() {
        return 1.50;
    }
    
}
