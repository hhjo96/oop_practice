package runningClass.HW4;

import java.util.List;
import java.util.Random;

public class Battle {

    private Team teamRed;
    private Team teamBlue;
    private Characters red;
    private Characters blue;
    private Random random;

    public Battle(Team teamRed, Team teamBlue) {
        this.teamRed = teamRed;
        this.teamBlue = teamBlue;
        red = teamRed.getLeader();
        blue = teamBlue.getLeader();
        random = new Random();
    }

    public void battle() {

        Characters.Logg.add("======일대일 시작!======");

        while (red.getHealth() > 0 && blue.getHealth() > 0) {
            try {
                basicBattle();
                ownAbilityBattle();
                meleeRangedBattle();
                ultBattle();
                passiveBattle();
            } catch (DeadChampionActionException e) {
                Characters.Logg.add(e.getMessage());
                break;
            }
        }
    }

    public void basicBattle() {
        Characters.Logg.add("1. 기본 공격 주고받기");
        red.basicAttack(blue, random.nextInt(30));
        if (blue.cannotContinueBattle()) {
            throw new DeadChampionActionException(blue.getName() + "은 사망했습니다!");
        }
        blue.basicAttack(red, random.nextInt(30));
        if (red.cannotContinueBattle()) {
            throw new DeadChampionActionException(red.getName() + "은 사망했습니다!");
        }
        Characters.Logg.add("");
    }

    public void ownAbilityBattle() {
        Characters.Logg.add("2. 고유 능력 주고받기");
        red.ownSkill();
        if (blue.cannotContinueBattle()) {
            throw new DeadChampionActionException(blue.getName() + "은 사망했습니다!");
        }
        blue.ownSkill();
        if (red.cannotContinueBattle()) {
            throw new DeadChampionActionException(red.getName() + "은 사망했습니다!");
        }
        Characters.Logg.add("");
    }

    public void meleeRangedBattle() {
        Characters.Logg.add("3. 근딜/원딜 능력 주고받기");
        red.punchOrKite(blue);
        if (blue.cannotContinueBattle()) {
            throw new DeadChampionActionException(blue.getName() + "은 사망했습니다!");
        }
        blue.punchOrKite(red);
        if (red.cannotContinueBattle()) {
            throw new DeadChampionActionException(red.getName() + "은 사망했습니다!");
        }
        Characters.Logg.add("");
    }

    public void ultBattle() {
        Characters.Logg.add("4. 궁쓰기");
        red.useQ(blue);
        if (blue.cannotContinueBattle()) {
            throw new DeadChampionActionException(blue.getName() + "은 사망했습니다!");
        }
        blue.useQ(red);
        if (red.cannotContinueBattle()) {
            throw new DeadChampionActionException(red.getName() + "은 사망했습니다!");
        }
        Characters.Logg.add("");
    }
    public void passiveBattle(){
        Characters.Logg.add("5. 패시브 적용");
        red.getPassive().applyPassive(red, blue);
        if (blue.cannotContinueBattle()) {
            throw new DeadChampionActionException(blue.getName() + "은 사망했습니다!");
        }
        blue.getPassive().applyPassive(blue, red);
        if (red.cannotContinueBattle()) {
            throw new DeadChampionActionException(red.getName() + "은 사망했습니다!");
        }
        Characters.Logg.add("");
    }

    public void summaryBattle(){
        List<String> log = Characters.Logg.getLog().stream().filter(s->s.contains("승")).toList();
        if(log.isEmpty()) { // 누가 이겼다는 로그가 없는 경우 비긴 것이므로 비겼다를 찾기
            log = Characters.Logg.getLog().stream().filter(s->s.contains("비겼다")).toList();
        } else { // 누가 이겼다는 로그가 있을 경우
            System.out.println(log.get(0));
        }
    }


    public void finishBattleLog(){
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
