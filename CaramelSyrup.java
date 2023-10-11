///Класс-декоратор, представляющий карамельный сироп
public class CaramelSyrup extends CoffeeDecorator {
    public CaramelSyrup(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", с карамельным сиропом";
    } ///добавляет название сиропа к кофе

    public int cost() {
        return decoratedCoffee.cost() + 150;
    } ///добавляет цену сиропа к цене кофе
}