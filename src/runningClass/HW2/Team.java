package runningClass.HW2;

import java.util.ArrayList;
import java.util.List;

public class Team <T extends Characters> {
    private String name;
    private List<T> members = new ArrayList<T>();

    public Team(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void addMember(T member) {
        members.add(member);
        Characters.Logg.add(member.getName()+"는 "+this.name+"팀");
    }
    int getTotalHealth() {
        return members.stream().mapToInt(Characters::getHealth).sum();
    }
    List<T> getMembers() {
        return this.members;
    }
    T getLeader() {
        return this.members.get(0);
    }

    void printTeamMembers(List<? extends Characters> members) {
        for (Characters ch : members) {
            System.out.println(ch.getName());
        }
    }
    void addMembers(List<? extends T> members) {
        this.members.addAll(members);
    }

}
