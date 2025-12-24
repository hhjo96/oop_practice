
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

        //pool 생성
        List<Characters> pool = new ArrayList<>(Arrays.asList(new Characters[]{wilson, wigfrid, walter, wurt}));
        //랜덤 팀 생성
        Collections.shuffle(pool);
        teamBlue.addMembers(new ArrayList<>(pool.subList(0, pool.size() / teamSize)));
        teamRed.addMembers(new ArrayList<>(pool.subList(pool.size() / teamSize, pool.size())));

        //1대1로 싸우기: 배틀 클래스에서 팀당 1명을 뽑음
        Battle battle = new Battle(teamRed, teamBlue);
        //안전 전투 진행
        battle.battle();
        //승패 및 전투 종료 메시지 출력
        battle.finishBattleLog();


        Characters.Logg.add("캐릭터 생성 횟수: "+ Characters.getCharacterCount() + " 전투 횟수: " + Characters.getBattleCount());

        //전체 전투 이력을 보거나 스트림을 활용하여 전투 로그 요약하기(승패만 출력)
        System.out.print("전체 전투 이력을 볼 경우 1을 입력, 결과만 볼 경우 2를 입력하세요: ");
        String answer = sc.nextLine();

        if(answer.trim().equals("1")) { Characters.Logg.printAll(); }
        else if(answer.trim().equals("2")) { battle.summaryBattle(); }
        else { System.out.println("잘못된 입력입니다.");}


        //팀 구성 확인
        System.out.print("팀 구성을 볼 경우 1을 입력, 다음으로 넘어갈 경우 2를 입력하세요: ");
        answer = sc.nextLine();
        if(answer.trim().equals("1")) {
            teamRed.printTeamMembers(pool.subList(0, pool.size() / teamSize));
            teamBlue.printTeamMembers(pool.subList(pool.size() / teamSize, pool.size()));
        }

        //캐릭터 이름으로 검색하기
        System.out.print("캐릭터가 있는지 검색하려면 1을 입력, 다음으로 넘어갈 경우 2를 입력하세요: ");
        answer = sc.nextLine();
        if(answer.trim().equals("1")) { searchCharacter(teamBlue, teamRed, sc); }

        //캐릭터 이름으로 로그 확인하기
        System.out.print("캐릭터에 대한 로그를 검색하려면 1을 입력, 다음으로 넘어갈 경우 2를 입력하세요: ");
        answer = sc.nextLine();
        if(answer.trim().equals("1")) { searchLog(sc); }

        System.out.println("프로그램을 종료합니다.");
        sc.close();

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
