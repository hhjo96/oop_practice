package runningClass.HW2;

import java.util.*;

public class Battle {

    public static void battle(Team teamRed, Team teamBlue) {

        Random random = new Random();

        Characters.Logg.add("======일대일 시작!======");

        Characters red = teamRed.getLeader();
        Characters blue = teamBlue.getLeader();

        while (red.getHealth() > 0 && blue.getHealth() > 0) {
            red.attackDamage(blue, random.nextInt(30));
            if(!blue.continueBattle()) { break; }
            blue.attackDamage(red, random.nextInt(30));
            if(!red.continueBattle()) { break; }

            red.ownSkill();
            if(!blue.continueBattle()) { break; }
            blue.ownSkill();
            if(!red.continueBattle()) { break; }

            red.punchOrKite(blue);
            if(!blue.continueBattle()) { break; }
            blue.punchOrKite(red);
            if(!red.continueBattle()) { break; }

            red.ult(blue);
            if(!blue.continueBattle()) { break; }
            blue.ult(red);
            if(!red.continueBattle()) { break; }
        }

        Characters.Logg.add("======일대일 종료!======");
        if (red.getHealth() > blue.getHealth()) {
            Characters.Logg.add(red.getName() + " 승!" + blue.getName() + " 패!");
        } else if (red.getHealth() < blue.getHealth()) {
            Characters.Logg.add(blue.getName() + " 승!" + red.getName() + " 패!");
        } else {
            Characters.Logg.add(red.getName() + "와(과) " + blue.getName() + "은(는) 비겼다!");
        }
    }
}
