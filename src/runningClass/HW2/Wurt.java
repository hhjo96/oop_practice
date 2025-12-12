package runningClass.HW2;

import static runningClass.HW2.GameConstants.BASIC_PUNCH;
import static runningClass.HW2.GameConstants.BASIC_ULT_ATTACK;

//워트: 스탯을 올릴 수 있음, 야채만 먹음
public class Wurt extends Characters implements Melee {
    public Wurt(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType) {
        super(name, health, hunger, sanity, damage, inventory, foodType);
    }


    public void ult(Characters target) {
        System.out.println(this.name + "의 궁");
        getDamage(target, BASIC_ULT_ATTACK);
    }

    public void punch(Characters target) {
        System.out.println(this.name + "의 근접 공격");
        getDamage(target, BASIC_PUNCH);
    }

    public void ownSkill() {
        System.out.println(this.name + "가 야채를 먹고 스탯을 향상시킵니다.");
        this.health += 100;
        this.sanity += 50;
        this.hunger += 50;
    }
}
