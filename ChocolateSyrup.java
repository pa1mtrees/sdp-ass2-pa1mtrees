///Класс-декоратор, представляющий шоколадный сироп
public class ChocolateSyrup extends CoffeeDecorator{
    public ChocolateSyrup(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return decoratedCoffee.getDescription() + ", с шоколадным сиропом";
    } ///добавляет название сиропа к кофе

    public int cost() {
        return decoratedCoffee.cost() + 250;
    } ///добавляет цену сиропа к цене кофе
}
