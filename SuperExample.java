class GameCharacter {
    protected String name;
    protected int level;
    protected int health;
    protected int attackPower;

    public GameCharacter(String name, int level) {
        this.name = name;
        this.level = level;
        this.health = 100 + (level * 10);
        this.attackPower = 10 + (level * 2);
        System.out.println("Создан игровой персонаж: " + name + " ур. " + level);
    }

    public void attack(GameCharacter target) {
        System.out.println(name + " атакует " + target.name + " с силой " + attackPower);
        target.takeDamage(attackPower);
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " получает " + damage + " урона. Здоровье: " + health);
        if (health <= 0) {
            System.out.println(name + " повержен!");
        }
    }
}

class Warrior extends GameCharacter {
    private int armorHealth;
    private String name; //Сокрытие поля

    //super для вызова конструктора суперкласса
    public Warrior(String name, int level, int armorHealth) {
        super(name, level); //Вызов конструктора GameCharacter(String name, int level)
        this.armorHealth = armorHealth;
        this.name = "Воин " + name;
    }

    //super для доступа к полю суперкласса
    public void printStats() {
        System.out.println("Информация о персонаже:");
        System.out.println("Имя (super.name): " + super.name); //Обращаемся к полю name класса GameCharacter
        System.out.println("Имя и класс (this.name): " + this.name);
    }

    //super для доступа к методу суперкласса
    @Override
    public void takeDamage(int damage) {
        if (armorHealth >= 0) {
            System.out.println("Доспех заблокировал атаку!");
            armorHealth -= damage;
        }
        else {
            super.takeDamage(damage); //Вызываем метод takeDamage(int damage) класса GameCharacter
        }
    }

}

//Демонстрация
public class SuperExample {
    public static void main(String[] args) {
        GameCharacter monster = new GameCharacter("Монстр", 10);
        Warrior warrior = new Warrior("Кирито", 8, 100);
        warrior.printStats();
        monster.attack(warrior);
        warrior.attack(monster);
    }
}
