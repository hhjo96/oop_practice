
package runningClass.HW4;


import java.util.*;

public class Main {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
        teamBlue.addMembers(new ArrayList<>(pool.subList(0, pool.size() / teamSize)));
        teamRed.addMembers(new ArrayList<>(pool.subList(pool.size() / teamSize, pool.size())));

        //1대1로 싸우기
        Battle battle = new Battle(teamRed, teamBlue);
        battle.battle();
        battle.battleLog();


        Characters.Logg.add("캐릭터 생성 횟수: "+ Characters.getCharacterCount() + " 전투 횟수: " + Characters.getBattleCount());
        Characters.Logg.printAll();

        teamRed.printTeamMembers(pool.subList(0, pool.size() / teamSize));
        teamBlue.printTeamMembers(pool.subList(pool.size() / teamSize, pool.size()));

        searchCharacter(teamBlue, teamRed, sc);
        searchLog(sc);

    }

    //캐릭터가 있는지 검색하기
    static void searchCharacter(Team<Characters> teamBlue, Team<Characters> teamRed, Scanner sc){
        System.out.println("======= 캐릭터가 있는지 검색하기 =======");
        System.out.print("검색할 캐릭터 이름을 입력하세요: ");
        String name1 = sc.nextLine();
        Optional<Characters> red = teamRed.find(name1);
        Optional<Characters> blue = teamBlue.find(name1);
        red.ifPresent(characters -> System.out.println("Red팀에 " + characters.getName() + " 가 있습니다."));
        blue.ifPresent(characters -> System.out.println("Blue팀에 " + characters.getName() + " 가 있습니다."));
        if(red.isEmpty() && blue.isEmpty()) {
            System.out.println("해당 캐릭터가 없습니다.");
        }
    }
    static void searchLog(Scanner sc){
        System.out.println("======= 캐릭터 이름으로 로그 검색하기 =======");
        System.out.print("검색할 캐릭터 이름을 입력하세요: ");
        String name2 = sc.nextLine();
        Characters.Logg.nameFromLog(name2);
    }

}
