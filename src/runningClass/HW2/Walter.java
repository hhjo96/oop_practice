package runningClass.HW2;

//월터: 전용 탈것이 있음, 맞은만큼 정신력도 깎임
public class Walter extends Characters implements Ranged {
    public Walter(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType) {
        super(name, health, hunger, sanity, damage, inventory, foodType);
    }



    void ult(Characters target) {
        System.out.println(this.name + "의 궁");
        getDamage(target, this.damage * 10);
    }

    @Override
    public void kite(Characters target) {
        System.out.println(this.name + "의 원거리 공격");
        getDamage(target, this.damage - 10);
    }

    public void ownSkill() {
        System.out.println(this.name + "는 전용 탈것 워비를 타고 빠르게 이동합니다.");
    }

}
