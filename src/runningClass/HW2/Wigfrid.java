package runningClass.HW2;

//위그: 공격력 2배, 고기만 먹음
public class Wigfrid extends Characters implements Melee {

    public Wigfrid(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType) {
        super(name, health, hunger, sanity, damage, inventory, foodType);
    }


    void ult(Characters target) {
        System.out.println(this.name + "의 궁");
        getDamage(target, this.damage * 8 * 2);
    }

    public void punch(Characters target) {
        System.out.println(this.name + "의 근접 공격");
        getDamage(target, this.damage * 2);
    }

    public void ownSkill(){
        System.out.println(this.name + "가(이) 고기를 먹고 체력을 60 회복합니다.");
        this.health += 60;
    }

}
