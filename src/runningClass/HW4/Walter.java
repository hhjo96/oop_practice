package runningClass.HW4;

import static runningClass.HW2.GameConstants.*;

//월터: 전용 탈것이 있음, 맞은만큼 정신력도 깎임
public class Walter extends Characters implements Ranged {
    public Walter(Resurrectable resurrectable) {
        super("월터", SMALL_BASIC, BASIC_ATTACK, BASIC_INVENTORY, "normal", resurrectable, CharacterType.RANGED);
    }



    public void useQ(Characters target) {
        Logg.add(this.getName() + "의 궁");
        takeDamage(target, STRONG_ULT_ATTACK);
    }

    @Override
    public void kite(Characters target) {
        Logg.add(this.getName() + "의 원거리 공격");
        takeDamage(target, BASIC_KITE-target.getDefense());
    }

    public void ownSkill() {
        Logg.add(this.getName() + "는 전용 탈것 워비를 타고 빠르게 이동합니다.");
    }

    @Override
    public void resurrectAfterEffects() {
        this.fillHealth(100);
    }


}
