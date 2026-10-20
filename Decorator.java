interface Pizza {
    String getDescription();
    double getPrice();
}
class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain Dough & Sauce";
    }
    @Override
    public double getPrice() {
        return 5.0;
    }
}
abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}
class Cheese extends ToppingDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }
    @Override
    public double getPrice() {
        return pizza.getPrice() + 2.0;
    }
}
class Olives extends ToppingDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 1.0;
    }
}
class Pineapple extends ToppingDecorator {
    public Pineapple(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pineapple";
    }
    @Override
    public double getPrice() {
        return pizza.getPrice() + 1.5;
    }
}
public class Decorator {
    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();
        pizza = new Cheese(pizza);
        pizza = new Olives(pizza);
        pizza = new Pineapple(pizza);
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Total Cost: $" + pizza.getPrice());
    }
}
