package runningClass.HW4;

public class ExtraDamagePassive implements Passive{
    public void applyPassive(Characters self, Characters target) {
        Characters.Logg.add(self.getName()+"의 패시브 스킬: 추가 피해 +3");
        self.takeDamage(target, 3);
    }
}
