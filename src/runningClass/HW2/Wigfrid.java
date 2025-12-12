package runningClass.HW2;

import static runningClass.HW2.GameConstants.STRONG_PUNCH;
import static runningClass.HW2.GameConstants.STRONG_ULT_ATTACK;

//위그: 공격력 2배, 고기만 먹음
public class Wigfrid extends Characters implements Melee{

    public Wigfrid(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType) {
        super(name, health, hunger, sanity, damage, inventory, foodType);
    }


    public void ult(Characters target) {
        System.out.println(this.name + "의 궁");
        getDamage(target, STRONG_ULT_ATTACK);
    }

    public void punch(Characters target) {
        System.out.println(this.name + "의 근접 공격");
        getDamage(target, STRONG_PUNCH);
    }

    public void ownSkill(){
        System.out.println(this.name + "가(이) 고기를 먹고 체력을 60 회복합니다.");
        this.health += 60;
    }

}
