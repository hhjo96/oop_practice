package runningClass.HW4;

public class LevelUpPassive implements Passive{

    @Override
    public void applyPassive(Characters self, Characters target) {
            Characters.Logg.add(self.getName()+"의 패시브 스킬: 레벨업하여 데미지 +10");
            self.levelUp();
    }
}
