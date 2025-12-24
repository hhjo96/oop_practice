package runningClass.HW4;

public class MoreHealthPassive implements Passive{
    public void applyPassive(Characters self, Characters target) {
        Characters.Logg.add(self.getName()+"의 패시브 스킬: 피흡 +5");
        self.levelUp();
    }
}
