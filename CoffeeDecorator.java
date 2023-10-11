///Основной класс, который демонстрирует использование шаблона "Декоратор"
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee; ///доступно только для подклассов "CoffeeDecorator"
///получаем кофе для добавления позже сиропа
    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
///получаем цену кофе для добавления позже цены сиропа
    public int cost() {
        return decoratedCoffee.cost();
    }
}