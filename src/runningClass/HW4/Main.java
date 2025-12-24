
package runningClass.HW3.HW2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Resurrectable shortRes = new CoolTimeResurrect(10);
        Resurrectable longRes = new CoolTimeResurrect(100);


        Characters wilson = new Wilson(shortRes);
        Characters wigfrid = new Wigfrid(longRes);
        Characters walter = new Walter(shortRes);
        Characters wurt = new Wurt(longRes);

        Team<Characters> teamBlue = new Team<>("Blue");
        Team<Characters> teamRed = new Team<>("Red");
        int teamSize = 2;

        //랜덤하게 팀 두개를 짜기
        List<Characters> pool = new ArrayList<>(Arrays.asList(new Characters[]{wilson, wigfrid, walter, wurt}));
        Collections.shuffle(pool);
        teamBlue.addMembers(pool.subList(0, pool.size() / teamSize));
        teamRed.addMembers(pool.subList(pool.size() / teamSize, pool.size()));

        //1대1로 싸우기
        Battle.battle(teamRed, teamBlue);


        Characters.Logg.add("캐릭터 생성 횟수: "+ Characters.getCharacterCount() + " 전투 횟수: " + Characters.getBattleCount());
        Characters.Logg.printAll();

        teamRed.printTeamMembers(pool.subList(0, pool.size() / teamSize));
        teamBlue.printTeamMembers(pool.subList(pool.size() / teamSize, pool.size()));
    }
}
