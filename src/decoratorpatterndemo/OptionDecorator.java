
package decoratorpatterndemo;

public abstract class OptionDecorator implements Beverage{
    protected Beverage decoratedBeverage;
    
    //Constructor - This essentially does the Wrapping of elements
    public OptionDecorator(Beverage decoratedbeverage) {
        this.decoratedBeverage = decoratedbeverage;
    }
    
    @Override
    public String getDescription(){
        return decoratedBeverage.getDescription();
    }
    
    @Override
    public double getCost(){
        return decoratedBeverage.getCost();
    }
}
