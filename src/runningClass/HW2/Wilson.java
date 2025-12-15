package runningClass.HW2;

import static runningClass.HW2.GameConstants.BASIC_PUNCH;
import static runningClass.HW2.GameConstants.BASIC_ULT_ATTACK;

public class Wilson extends Characters implements Melee{

    //윌슨: 스탯 기본, 인벤토리 추가 가능
    public Wilson(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType, Resurrectable resurrectable, CharacterType type) {
        super(name, health, hunger, sanity, damage, inventory, foodType, resurrectable, CharacterType.MELEE);
    }


    public void ult(Characters target) {
        Logg.add(this.name + "의 궁");
        getDamage(target, BASIC_ULT_ATTACK);
    }

    public void punch(Characters target) {
        Logg.add(this.name + "의 근접 공격");
        getDamage(target, BASIC_PUNCH);
    }

    public void ownSkill(){
        Logg.add(this.name + "이 수염을 3칸짜리 인벤토리로 씁니다.");
        this.inventory += 3;
    }
}
