# RunningClassHW
스프링 부트캠프 달리기반 과제

롤은 안해봐서 다른 게임 캐릭터 이름 따왔습니다!

메인함수 Main.java
각 캐릭터 공통 Characters.java
근딜 원딜 종류 CharacterType
부활 관련 Resurrectable.java, CoolTimeResurrect.java
캐릭터 walter, wigfrid, wilson, walter
게임 관련 상수 GameConstants.java

랜덤한 두 캐릭터가 싸우다가 한쪽이 죽으면 승패 출력

기본~선택까지.(선택3 static 남용문제 제외)

```mermaid
classDiagram
    class GameConstants {
        +static int TINY_BASIC
        +static int SMALL_BASIC
        +static int BASIC
        +static int BIG_BASIC
        +static int HUGE_BASIC
        +static int BASIC_ATTACK
        +static int STRONG_ATTACK
        +static int BASIC_ULT_ATTACK
        +static int STRONG_ULT_ATTACK
        +static int BASIC_PUNCH
        +static int BASIC_KITE
        +static int STRONG_PUNCH
        +static int BASIC_INVENTORY
        
        -GameConstants()
        
        
    }
    class Ranged {
        <<interface>>
        ~kite(target: Characters) 
    }
    class Melee {
        <<interface>>
        ~punch(target: Characters) 
    }
    class Resurrectable {
        <<interface>>
        ~canResurrect(): boolean
        ~afterResurrect(): void
    }
    class CoolTimeResurrect{
        -nextResurrectTime: long
        -final cooltime: long
        +Resurrectable(cooltime: long)
        +canResurrect(): boolean
        +afterResurrect(): void
    }
    class Characters {
        ~name: String
        ~health: int
        ~hunger: int
        ~sanity: int
        ~damage: int
        ~inventory: int
        ~foodType: String
        ~static battleCount: int
        ~static characterCount: int
        +Characters(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType, int battleCount)
        
        ~abstract ult(ch: Characters): void
        ~abstract ownSkill() : void
        ~fillHealth(health: int) : void
        ~fillHunger(hunger: int) : void
        ~fillSanity(sanity: int) : void
        ~getDamage(ch: Characters, damage: int) : void
        ~attachDamage(ch: Characters, damage: int) : void
        ~final resurrect() void
        ~punchOrKite(ch: Characters) : void
        ~abstract resurrectAfterEffects(): void
    }
    class Logger {
        <<static>>
        ~add(msg: String): void
        ~printAll(): void
    }
    class Walter {
        +Walter(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType)
        +ult(target: Characters): void
        +ownSkill(): void
        +kite(target: Characters): void
        +resurrectAfterEffects(): void
    }
    class Wilson {
        ~Wilson(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType)
        +ult(target: Characters): void
        +ownSkill(): void
        +punch(target: Characters): void
        +resurrectAfterEffects(): void
    }
    class Wigfrid  {
        ~Wigfrid(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType)
        +ult(target: Characters): void
        +ownSkill(): void
        +punch(target: Characters): void
        +resurrectAfterEffects(): void
    }
    class Wurt {
        ~Wurt(String name, int health, int hunger, int sanity, int damage, int inventory, String foodType)
        +ult(target: Characters): void
        +ownSkill(): void
        +punch(target: Characters): void
        +resurrectAfterEffects(): void
    }

Characters <|-- Walter
Characters <|-- Wigfrid
Characters <|-- Wilson
Characters <|-- Wurt

Melee <|.. Wigfrid
Melee <|.. Wilson
Melee <|.. Wurt
Ranged <|.. Walter
Characters *-- Logger

```