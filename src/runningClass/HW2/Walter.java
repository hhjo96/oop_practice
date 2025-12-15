package runningClass.HW2;

import static runningClass.HW2.GameConstants.*;

//월터: 전용 탈것이 있음, 맞은만큼 정신력도 깎임
public class Walter extends Characters implements Ranged {
    public Walter(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType, Resurrectable resurrectable, CharacterType type) {
        super(name, health, hunger, sanity, damage, inventory, foodType, resurrectable, CharacterType.RANGED);
    }



    public void ult(Characters target) {
        Logg.add(this.name + "의 궁");
        getDamage(target, STRONG_ULT_ATTACK);
    }

    @Override
    public void kite(Characters target) {
        Logg.add(this.name + "의 원거리 공격");
        getDamage(target, BASIC_KITE);
    }

    public void ownSkill() {
        Logg.add(this.name + "는 전용 탈것 워비를 타고 빠르게 이동합니다.");
    }

    @Override
    public void resurrectAfterEffects() {
        this.fillHealth(100);
    }


}
