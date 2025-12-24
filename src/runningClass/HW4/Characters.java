package runningClass.HW4;

import java.util.ArrayList;
import java.util.List;

import static runningClass.HW2.GameConstants.*;

public abstract class Characters {
    private String name = "";
    private int health = BASIC;
    private int damage = BASIC_ATTACK;
    private int inventory = BASIC_INVENTORY;
    private String foodType = "normal";
    private int defense;
    private int level = 1;

    private static int characterCount = 0;
    private static int battleCount = 0;

    private boolean isDead = false;
    private final Resurrectable resurrectable;
    private CharacterType type;

    public Characters(String name, int health, int damage, int inventory, String foodType, Resurrectable resurrectable, CharacterType type) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.inventory = inventory;
        this.foodType = foodType;
        this.defense = 0;
        characterCount++;
        this.isDead = false;
        this.resurrectable = resurrectable;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }
    public int getHealth() {
        return this.health;
    }
    public int takeDamage() {
        return this.damage;
    }

    public boolean getDead() {
        return this.isDead;
    }
    public int getInventory() {
        return this.inventory;
    }

    public int getDefense() {
        return this.defense;
    }
    public int getLevel() {
        return this.level;
    }

    public static int getCharacterCount() {
        return characterCount;
    }
    public static int getBattleCount() {
        return battleCount;
    }

public void setDamage(int damage) { this.damage = damage;}
    public int setHealth(int health) {
        return this.health = health;
    }
    public void setIsDead(boolean dead) {
        this.isDead = dead;
    }
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    public void setLevel(int level) { this.level = level;
    }

    abstract void useQ(Characters ch);

    abstract void ownSkill();

    void fillHealth(int health) {
        Logg.add(this.getName() + "가(이) 체력을 " + health + " 회복합니다.");
        this.setHealth(this.getHealth() + health);
    }

    void takeDamage(Characters ch, int damage) {
        battleCount++;
        if (ch.getHealth() - damage <= 0) {
            ch.setHealth(0);
            Logg.add(ch.getName() + "가(이) " + damage + "의 데미지를 받고 죽었습니다!");
        } else {
            ch.setHealth(ch.getHealth() - damage);
            Logg.add(ch.getName() + "가(이) " + damage + "의 데미지를 받았습니다! 현재 체력: " + ch.getHealth());
        }
    }

    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
        this.setDamage(this.takeDamage() + 10);
    }

    void basicAttack(Characters ch, int damage) {
        Logg.add(this.name + "가(이) 공격합니다.");
        takeDamage(ch, damage);
    }

    final void resurrect() {
        if (isDead) {
            if (resurrectable.canResurrect()) {
                fillHealth(1);
                this.setIsDead(false);
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

    boolean cannotContinueBattle() {
        if (this.getHealth() > 0) {
            return false;
        }

        // 체력 0 이하일 때 부활
        if (resurrectable.canResurrect()) {
            this.setIsDead(true);
            resurrect();
            return false;
        }

        this.setIsDead(true);
        return true;
    }


    static class Logg {
        private static final List<String> log = new ArrayList<>();

        private Logg() {}

        public static List<String> getLog() {
            return log;
        }

        static void add(String msg) {
            log.add(msg);
        }
        static void printAll() {
            for (String msg : log) {
                System.out.println(msg);
            }
        }
        static void nameFromLog(String name) {

            List<String> log = Logg.log.stream().filter(s->s.contains(name)).toList();
            if(log.isEmpty()) {
                System.out.println("해당 캐릭터의 로그가 없습니다.");
            } else {
                log.forEach(System.out::println);
            }
        }

    }
}
