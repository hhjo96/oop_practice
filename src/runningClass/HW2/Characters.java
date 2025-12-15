package runningClass.HW2;

import java.util.ArrayList;
import java.util.List;

import static runningClass.HW2.GameConstants.*;

public abstract class Characters {
    String name = "";
    int health = BASIC;
    int hunger = BASIC;
    int sanity = BASIC;
    int damage = BASIC_ATTACK;
    int inventory = BASIC_INVENTORY;
    String foodType = "normal";

    static int characterCount = 0;
    static int battleCount = 0;

    boolean dead = false;
    final Resurrectable resurrectable;
    CharacterType type;

    public Characters(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType, Resurrectable resurrectable, CharacterType type) {
        this.name = name;
        this.health = health;
        this.hunger = hunger;
        this.sanity = sanity;
        this.damage = damage;
        this.inventory = inventory;
        this.foodType = foodType;
        characterCount++;
        this.resurrectable = resurrectable;
        this.type = type;
    }



    abstract void ult(Characters ch);

    abstract void ownSkill();

    void fillHealth(int health) {
        Logg.add(this.name + "가(이) 체력을 " + health + " 회복합니다.");
        this.health += health;
    }

    ;

    void fillHunger(int hunger) {
        Logg.add(this.name + "가(이) 허기를 " + hunger + " 회복합니다.");
        this.hunger += hunger;
    }

    ;

    void fillSanity(int sanity) {
        Logg.add(this.name + "가(이) 정신력을 " + sanity + " 회복합니다.");
        this.sanity += sanity;
    }

    ;

    void getDamage(Characters ch, int damage) {
        battleCount++;
        if (ch.health - damage <= 0) {
            ch.health = 0;
            Logg.add(ch.name + "가(이) " + damage + "의 데미지를 받고 죽었습니다!");
        } else {
            ch.health -= damage;
            Logg.add(ch.name + "가(이) " + damage + "의 데미지를 받았습니다! 현재 체력: " + ch.health);
        }
    }

    ;

    void attackDamage(Characters ch, int damage) {
        Logg.add(this.name + "가(이) 공격합니다.");
        getDamage(ch, damage);
    }

    final void resurrect() {
        if (dead) {
            if (resurrectable.canResurrect()) {
                fillHealth(1);
                this.dead = false;
                Logg.add(this.name + "가(이) 부활했습니다!");
                resurrectable.afterResurrect();
                resurrectAfterEffects();
            } else {
                Logg.add(this.name + " 부활 쿨타임");
            }
        }
    }

    abstract void resurrectAfterEffects();

    void punchOrKite(Characters ch) {
        switch(this.type) {
            case MELEE -> ((Melee)this).punch(ch);
            case RANGED -> ((Ranged)this).kite(ch);
        }
    }

    static class Logg {
        private static final List<String> log = new ArrayList<>();

        private Logg() {}

        static void add(String msg) {
            log.add(msg);
        }
        static void printAll() {
            for (String msg : log) {
                System.out.println(msg);
            }
        }

    }
}
