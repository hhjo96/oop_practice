package runningClass.HW4;

import java.util.Random;

public class Battle {

    private Team teamRed;
    private Team teamBlue;
    private Characters red;
    private Characters blue;

    public Battle(Team teamRed, Team teamBlue) {
        this.teamRed = teamRed;
        this.teamBlue = teamBlue;
        red = teamRed.getLeader();
        blue = teamBlue.getLeader();
    }
    // 사망 관련 함수
    public void canContinueBattle(Characters leader){
        if(!leader.continueBattle()) {
            throw new DeadChampionActionException(leader.getName() + "은 사망했습니다!");
        }
    }

    public void battle() {

        Random random = new Random();

        Characters.Logg.add("======일대일 시작!======");

        while (red.getHealth() > 0 && blue.getHealth() > 0) {
            Characters.Logg.add("1. 기본 공격 주고받기");
            red.basicAttack(blue, random.nextInt(30));
            canContinueBattle(blue);
            blue.basicAttack(red, random.nextInt(30));
            canContinueBattle(red);

            Characters.Logg.add("2. 고유 능력 주고받기");
            red.ownSkill();
            canContinueBattle(blue);
            blue.ownSkill();
            canContinueBattle(red);

            Characters.Logg.add("3. 근딜/원딜 능력 주고받기");
            red.punchOrKite(blue);
            canContinueBattle(blue);
            blue.punchOrKite(red);
            canContinueBattle(red);

            Characters.Logg.add("4. 궁쓰기");
            red.useQ(blue);
            canContinueBattle(blue);
            blue.useQ(red);
            canContinueBattle(red);
        }
    }

    public void battleLog(){
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
