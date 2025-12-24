package runningClass.HW4;

import java.util.*;

public class Team<T extends Characters> {
    private String name;
    private List<T> members = new ArrayList<T>();
    //private Map<String, T> teamMap = new HashMap<>();

    public Team(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void addMember(T member) {
        members.add(member);
        Characters.Logg.add(member.getName() + "는 " + this.name + "팀");
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
        System.out.printf("%-6s: ", this.getName()+ "팀");
        for (Characters ch : members) {
            System.out.print(ch.getName()+" ");
        }
        System.out.println();
    }

    void addMembers(Collection<? extends T> members) {
        this.members.addAll(members);
    }

    public Optional<Characters> find(String name) {
        return Optional.ofNullable(members.stream().filter(ch -> ch.getName().equals(name)).findFirst().orElse(null));
    }

}
