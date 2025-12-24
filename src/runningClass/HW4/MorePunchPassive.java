package runningClass.HW4;

public class MorePunchPassive implements Passive{
    public void applyPassive(Characters self, Characters target) {
        Characters.Logg.add(self.getName() + "의 패시브 스킬: 근접공격 한번 더");
        self.punchOrKite(target);
    }
}
