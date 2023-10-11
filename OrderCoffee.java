///Главный класс, который управляет заказом кофе и сиропов, а так же выводит интерфейс
import java.util.Scanner;

public class OrderCoffee {
    private Coffee currentCoffee; ///выбранный кофе
    private int totalCost; ///сумма

    public OrderCoffee() {
        currentCoffee = null;
        totalCost = 0;
    }

    ///интерфейс
    public void displayCoffeeMenu() {
        System.out.println("Меню:");
        System.out.println("1. Капучино - 600 тенге");
        System.out.println("2. Латте - 650 тенге");
    }

    public void displaySyrupMenu() {
        System.out.println("Сироп:");
        System.out.println("1. Карамельный - 150 тенге");
        System.out.println("2. Ванильный - 200 тенге");
        System.out.println("3. Шоколадный - 250 тенге");
    }

    ///выбор кофе
    public void orderCoffee(int coffeeChoice) {
        switch (coffeeChoice) {
            case 1:
                currentCoffee = new Capucino();
                break;
            case 2:
                currentCoffee = new Latte();
                break;
            case 0:
                finishOrder();
                break;
            default:
                System.out.println("Ошибка при выборе кофе.");
        }
    }

    ///выбор сиропа
    public void orderSyrup(int syrupChoice) {
        if (currentCoffee == null) {
            System.out.println("Сначала выберите кофе.");
            return;
        }

        ///заказ без сиропа
        if (syrupChoice == 0) {
            finishOrder();
        } 
        
        ///заказ с сиропом
        else {
            switch (syrupChoice) {
                case 1:
                    currentCoffee = new CaramelSyrup(currentCoffee);
                    break;
                case 2:
                    currentCoffee = new VanillaSyrup(currentCoffee);
                    break;
                case 3:
                    currentCoffee = new ChocolateSyrup(currentCoffee);
                    break;
                default:
                    System.out.println("Ошибка при выборе сиропа.");
            }
        }
    }

    ///если заказ завершен, то выводим название и сумму заказа
    public void finishOrder() {
        if (currentCoffee != null) {
            System.out.println("Ваш заказ:");
            System.out.println(currentCoffee.getDescription() + " - " + currentCoffee.cost() + " тенге");
            totalCost += currentCoffee.cost();
        }
        System.out.println("Итоговая стоимость: " + totalCost + " тенге");
    }

    public static void main(String[] args) {
        OrderCoffee coffeeOrder = new OrderCoffee();
        Scanner scanner = new Scanner(System.in);

        int coffeeChoice; ///переменная выбора кофе
        int syrupChoice; ///переменная выбора сиропа

        ///цикл добавляющий опцию завершения заказа
        while (true) {
            coffeeOrder.displayCoffeeMenu();
            System.out.print("Выберите номер напитка (или 0 для завершения заказа): ");
            coffeeChoice = scanner.nextInt();

            coffeeOrder.orderCoffee(coffeeChoice);

            ///цикл добавляющий опцию заказа без сиропа
            if (coffeeChoice != 0) {
                coffeeOrder.displaySyrupMenu();
                System.out.print("Выберите номер сиропа (или 0 для заказа без сиропа): ");
                syrupChoice = scanner.nextInt();
                coffeeOrder.orderSyrup(syrupChoice);
            } else {
                break;
            }
        }

        System.out.println("Спасибо за заказ!");
    }
}
