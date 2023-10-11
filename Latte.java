///Класс предоставляет описание и стоимость латте
public class Latte implements Coffee {
    public String getDescription() {
        return "Латте";
    }

    public int cost() {
        return 650;
    }
}
