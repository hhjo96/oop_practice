# RunningClassHW
스프링 부트캠프 달리기반 과제

롤은 안해봐서 다른 게임 캐릭터 이름 따왔습니다!

랜덤한 두 캐릭터가 싸우다가 한쪽이 죽으면 승패 출력


## 파일 정리
메인함수 Main.java  
각 캐릭터 공통 Characters.java  
근딜 원딜 종류 CharacterType  
부활 관련 Resurrectable.java, CoolTimeResurrect.java  
캐릭터 walter, wigfrid, wilson, walter  
게임 관련 상수 GameConstants.java  
싸우기 Battle.java  
팀 Team.java  
패시브 ExtraDamagePassive.java, LevelUpPassive.java, MoreHealthPassive.java, MorePunchPassive.java

## 흐름 정리

네명의 캐릭터가 랜덤하게 두 팀을 짜고 대표 1명을 정해서 전투  
기본공격, 고유능력 공격, 근딜원딜 공격, 궁, 패시브 공격 순서로 진행
전투 중 피가 0이하로 떨어질 경우 즉시 종료(안전 전투)

## 참고

패시브 스킬의 경우 로그가 너무 길어져서 편의상 턴이 전부 끝나고 나서 한번 적용하는 것으로 함.

## 구현한 것

✔ ① Champion 추상 클래스 완성: Characters 클래스  
✔ ② 챔피언 2명 이상 구현: Walter, Wilson, Wigfrid, Wurt  
✔ ③ static / final 활용: Characters의 battleCount, CharacterCount  
✔ ④ ChampionPool(Map) 구현: main 에 존재  
✔ ⑤ SafeBattle(전투 모듈) 구현: Battle 클래스의 battle()  
✔ ⑥ 최종 "1:1 결투 모드" 실행 클래스: Battle  

✔ 선택 구현: 패시브(ExtraDamagePassive.java, LevelUpPassive.java, MoreHealthPassive.java, MorePunchPassive.java), 
Stream을 활용한 전투 로그 요약 출력(Battle의 summartBattle()) 
