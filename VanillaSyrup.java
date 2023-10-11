///Класс-декоратор, представляющий ванильный сироп
public class VanillaSyrup extends CoffeeDecorator {
    public VanillaSyrup(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", с ванильным сиропом";
    } ///добавляет название сиропа к кофе

    public int cost() {
        return decoratedCoffee.cost() + 200;
    } ///добавляет цену сиропа к цене кофе
} 
