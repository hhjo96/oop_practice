package runningClass.HW3.HW2;

import static runningClass.HW2.GameConstants.*;

//워트: 스탯을 올릴 수 있음, 야채만 먹음
public class Wurt extends Characters implements Melee {
    public Wurt(Resurrectable resurrectable) {
        super("워트", BASIC, BASIC_ATTACK, BASIC_INVENTORY, "vegetarian", resurrectable, CharacterType.MELEE);
    }


    public void useQ(Characters target) {
        Logg.add(this.getName() + "의 궁");
        takeDamage(target, BASIC_ULT_ATTACK);
    }

    public void punch(Characters target) {
        Logg.add(this.getName() + "의 근접 공격");
        takeDamage(target, BASIC_PUNCH-target.getDefense());
    }

    public void ownSkill() {
        Logg.add(this.getName() + "가 야채를 먹고 스탯을 향상시킵니다.");
        this.setHealth(this.getHealth() + 100);
    }
    public void resurrectAfterEffects() {
    }
}
