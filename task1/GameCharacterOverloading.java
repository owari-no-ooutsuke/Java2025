class GameCharacter {
    protected String name;

    public GameCharacter(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}


class Monster extends GameCharacter {
    public Monster(String name) {
        super(name);
    }

    public void attack() {
        System.out.println("Монстр " + name + " атакует!");
    }
}

class Warrior extends GameCharacter {
    public Warrior(String name) {
        super(name);
    }

    //Перегруженные методы

    //Встреча с монстром
    public void encounter(Monster monster) {
        System.out.println(name + " встречает монстра " + monster.getName() + " -> Атака!");
        monster.attack();
    }

    //Встреча с другим воином
    public void encounter(Warrior warrior) {
        System.out.println(name + " встречает воина " + warrior.getName() + " -> Приветствие");
    }

    //Встреча с неизвестным персонажем
    public void encounter(GameCharacter character) {
        System.out.println(name + " встречает " + character.getName() + " -> Изучает персонажа...");
    }
}

// Демонстрация
public class GameCharacterOverloading {
    public static void main(String[] args) {
        Monster monster = new Monster("Гоблин");
        Warrior warrior1 = new Warrior("Артур");
        Warrior warrior2 = new Warrior("Ланселот");
        GameCharacter someCharacter = new GameCharacter("Мерлин");

        warrior1.encounter(monster); //encounter(Monster monster)
        warrior1.encounter(warrior2); //encounter(Warrior warrior)
        warrior1.encounter(someCharacter); //encounter(GameCharacter character)
    }
}
