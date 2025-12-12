package runningClass.HW2;



public abstract class Characters {
    String name = "";
    int health = 150;
    int hunger = 150;
    int sanity = 150;
    int damage = 10;
    int inventory = 15;
    String foodType = "normal";

    public Characters(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType){
        this.name = name;
        this.health = health;
        this.hunger = hunger;
        this.sanity = sanity;
        this.damage = damage;
        this.inventory = inventory;
        this.foodType = foodType;
    }

    abstract void ult(Characters target);
    abstract void ownSkill();

    void fillHealth(int health) {
        System.out.println(this.name + "가(이) 체력을 " + health + " 회복합니다.");
        this.health += health;
    };
    void fillHunger(int hunger) {
        System.out.println(this.name + "가(이) 허기를 " + hunger + " 회복합니다.");
        this.hunger += hunger;
    };
    void fillSanity(int sanity) {
        System.out.println(this.name + "가(이) 정신력을 " + sanity + " 회복합니다.");
        this.sanity += sanity;
    };

    void getDamage(Characters ch, int damage) {
        if(ch.health - damage <= 0) {
            ch.health = 0;
            System.out.println(ch.name + "가(이) " + damage + "의 데미지를 받고 죽었습니다!");
        } else {
            ch.health -= damage;
            System.out.println(ch.name + "가(이) " + damage + "의 데미지를 받았습니다! 현재 체력: " + ch.health);
        }
    };

    void attackDamage(Characters characters, int damage) {
        System.out.println(this.name+ "가 공격합니다.");
        getDamage(characters, damage);
    }

}
