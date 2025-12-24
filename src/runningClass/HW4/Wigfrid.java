package runningClass.HW3.HW2;

import static runningClass.HW2.GameConstants.*;

//위그: 공격력 2배, 고기만 먹음
public class Wigfrid extends Characters implements Melee {

    public Wigfrid(Resurrectable resurrectable) {
        super("위그", HUGE_BASIC, STRONG_ATTACK, BASIC_INVENTORY, "meatatarian", resurrectable, CharacterType.MELEE);
    }


    public void useQ(Characters target) {
        Logg.add(this.getName() + "의 궁");
        takeDamage(target, STRONG_ULT_ATTACK * 2);
    }

    public void punch(Characters target) {
        Logg.add(this.getName() + "의 근접 공격");
        takeDamage(target, STRONG_PUNCH-target.getDefense());
    }

    public void ownSkill(){
        Logg.add(this.getName() + "가(이) 고기를 먹고 체력을 60 회복합니다.");
        this.setHealth(this.getHealth() + 60);
    }

    public void resurrectAfterEffects() {

    }
}
