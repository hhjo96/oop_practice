
package runningClass.HW2;

import java.util.Random;

import static runningClass.HW2.GameConstants.*;

public class Main {


    public static void main(String[] args) {

        Characters wilson
                = new Wilson("윌슨", BASIC, BASIC, BASIC, BASIC_ATTACK, BASIC_INVENTORY,  "normal");
        Characters wigfrid
                = new Wigfrid("위그", HUGE_BASIC, SMALL_BASIC, TINY_BASIC, STRONG_ATTACK, BASIC_INVENTORY, "meatatarian");
        Characters walter
                = new Walter("월터", SMALL_BASIC, BIG_BASIC, HUGE_BASIC, BASIC_ATTACK, BASIC_INVENTORY, "normal");
        Characters wurt
                = new Wurt("워트", BASIC, HUGE_BASIC, BASIC, BASIC_ATTACK, BASIC_INVENTORY, "vegetarian");

        Random random = new Random();

        //랜덤한 두명을 고르기
        Characters[] characters = {wilson, wigfrid, walter, wurt};
        int rand1 = random.nextInt(characters.length);
        int rand2 = random.nextInt(characters.length);

        while(rand1 == rand2) { // 같은사람 뽑히면 다시 뽑기
            rand2 = random.nextInt(characters.length);
        }

        System.out.println("======일대일 시작!======");

        while(characters[rand1].health > 0 && characters[rand2].health > 0) {
            characters[rand1].attackDamage(characters[rand2], random.nextInt(30));
            characters[rand2].attackDamage(characters[rand1], random.nextInt(30));

            characters[rand1].ownSkill();
            characters[rand2].ownSkill();

            characters[rand1].fillHealth(random.nextInt(100));
            characters[rand2].fillHealth(random.nextInt(100));

            if(characters[rand1] instanceof Melee) {
                ((Melee) characters[rand1]).punch(characters[rand2]);
            }
            if(characters[rand2] instanceof Melee) {
                ((Melee) characters[rand2]).punch(characters[rand1]);
            }
            if (characters[rand1] instanceof Ranged) {
                ((Ranged) characters[rand1]).kite(characters[rand2]);
            }
            if (characters[rand2] instanceof Ranged) {
                ((Ranged) characters[rand2]).kite(characters[rand1]);
            }

            characters[rand1].ult(characters[rand2]);
            characters[rand2].ult(characters[rand1]);
        }

        System.out.println("======일대일 종료!======");
        if(characters[rand1].health > characters[rand2].health) {
            System.out.println(characters[rand1].name + " 승!"+ characters[rand2].name + " 패!");
            characters[rand2].resurrect();
        } else if(characters[rand1].health < characters[rand2].health) {
            System.out.println(characters[rand2].name + " 승!"+ characters[rand1].name + " 패!");
            characters[rand2].resurrect();
        } else {
            System.out.println(characters[rand1].name+"와(과) "+ characters[rand2].name + "은(는) 비겼다!");
            if(characters[rand1].health == 0 && characters[rand2].health == 0) {
                characters[rand1].resurrect();
                characters[rand2].resurrect();
            }
        }

        System.out.println("캐릭터 생성 횟수: "+ Characters.characterCount + " 전투 횟수: " + Characters.battleCount);
    }
}
