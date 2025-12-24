package runningClass.HW4;

import static runningClass.HW2.GameConstants.*;

public class Wilson extends Characters implements Melee {

    //윌슨: 스탯 기본, 인벤토리 추가 가능
    public Wilson( Resurrectable resurrectable) {
        super("윌슨", BASIC, BASIC_ATTACK, BASIC_INVENTORY,  "normal", resurrectable, CharacterType.MELEE);
    }


    public void useQ(Characters target) {
        Logg.add(this.getName() + "의 궁");
        takeDamage(target, BASIC_ULT_ATTACK);
    }

    public void punch(Characters target) {
        Logg.add(this.getName() + "의 근접 공격");
        takeDamage(target, BASIC_PUNCH-target.getDefense());
    }

    public void ownSkill(){
        Logg.add(this.getName() + "이 수염을 3칸짜리 인벤토리로 씁니다.");
        this.setInventory(this.getInventory() + 3);
    }
    public void resurrectAfterEffects() {
        this.fillHealth(100);
    }
}
