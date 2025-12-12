
package runningClass.HW2;

import java.util.Random;

public class Main {
    public static int BASIC = 150;

    public static void main(String[] args) {

        Characters wilson = new Wilson("윌슨", BASIC, BASIC, BASIC, 10, 15,  "normal");
        Characters wigfrid = new Wigfrid("위그", BASIC+50, BASIC-30, BASIC-30, 10 * 2, 15, "meatatarian");
        Characters walter = new Walter("월터", BASIC-20, BASIC-40, BASIC+50, 10, 15, "normal");
        Characters wurt = new Wurt("워트", BASIC, BASIC+50, BASIC, 10, 15, "vegetarian");

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
        } else if(characters[rand1].health < characters[rand2].health) {
            System.out.println(characters[rand2].name + " 승!"+ characters[rand1].name + " 패!");
        } else {
            System.out.println(characters[rand1].name+"와(과) "+ characters[rand2].name + "은(는) 비겼다!");
        }

    }
}
