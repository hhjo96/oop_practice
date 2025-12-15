package runningClass.HW2;

import static runningClass.HW2.GameConstants.STRONG_PUNCH;
import static runningClass.HW2.GameConstants.STRONG_ULT_ATTACK;

//위그: 공격력 2배, 고기만 먹음
public class Wigfrid extends Characters implements Melee{

    public Wigfrid(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType, Resurrectable resurrectable, CharacterType type) {
        super(name, health, hunger, sanity, damage, inventory, foodType, resurrectable, CharacterType.MELEE);
    }


    public void ult(Characters target) {
        Logg.add(this.name + "의 궁");
        getDamage(target, STRONG_ULT_ATTACK);
    }

    public void punch(Characters target) {
        Logg.add(this.name + "의 근접 공격");
        getDamage(target, STRONG_PUNCH);
    }

    public void ownSkill(){
        Logg.add(this.name + "가(이) 고기를 먹고 체력을 60 회복합니다.");
        this.health += 60;
    }

    public void resurrectAfterEffects() {

    }
}
