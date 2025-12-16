package runningClass.HW2;

import java.util.ArrayList;
import java.util.List;

import static runningClass.HW2.GameConstants.*;

public abstract class Characters {
    private String name = "";
    private int health = BASIC;
    private int damage = BASIC_ATTACK;
    private int inventory = BASIC_INVENTORY;
    private String foodType = "normal";

    private static int characterCount = 0;
    private static int battleCount = 0;

    private boolean dead = false;
    private final Resurrectable resurrectable;
    private CharacterType type;

    public Characters(String name, int health, int damage, int inventory, String foodType, Resurrectable resurrectable, CharacterType type) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.inventory = inventory;
        this.foodType = foodType;
        characterCount++;
        this.resurrectable = resurrectable;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }
    public int getHealth() {
        return this.health;
    }
    public int getDamage() {
        return this.damage;
    }

    public boolean getDead() {
        return this.dead;
    }
    public int getInventory() {
        return this.inventory;
    }


    public static int getCharacterCount() {
        return characterCount;
    }
    public static int getBattleCount() {
        return battleCount;
    }

    public int setHealth(int health) {
        return this.health = health;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    abstract void ult(Characters ch);

    abstract void ownSkill();

    void fillHealth(int health) {
        Logg.add(this.getName() + "가(이) 체력을 " + health + " 회복합니다.");
        this.setHealth(this.getHealth() + health);
    }

    void getDamage(Characters ch, int damage) {
        battleCount++;
        if (ch.getHealth() - damage <= 0) {
            ch.setHealth(0);
            Logg.add(ch.getName() + "가(이) " + damage + "의 데미지를 받고 죽었습니다!");
        } else {
            ch.setHealth(ch.getHealth() - damage);
            Logg.add(ch.getName() + "가(이) " + damage + "의 데미지를 받았습니다! 현재 체력: " + ch.getHealth());
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
                this.setDead(false);
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

    boolean continueBattle() {
        if(this.getHealth() > 0) {
            return true;
        }
        this.setDead(true);
        if (this.resurrectable.canResurrect()) {
            resurrect();
            return true;

        }
        return false;
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
