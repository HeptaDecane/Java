import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League<E extends Team> {
    private String name;
    private List<E> teams;

    public League(String name){
        this.name = name;
        teams = new ArrayList<>();
    }

    public boolean addTeam(E team){
        if(teams.contains(team))
            return false;
        teams.add(team);
        return true;
    }

    public void fixtures(){
        System.out.println("\nFixtures:");
        for(int i=0;i<teams.size();i++){
            for (int j=0;j<teams.size();j++){
                if(i==j)
                    continue;
                int home = (int)(Math.random()*8);
                int away = (int)(Math.random()*8);
                teams.get(i).updateScore(teams.get(j),home,away);
                System.out.println(teams.get(i)+": "+home+" vs "+away+" :"+teams.get(j));
            }
        }
    }

    public void scoreboard(){
        System.out.println("\nScoreboard:");
        Collections.sort(teams);
        for(E team:teams) {
            System.out.print(team + " : " + team.score());
            System.out.println(" ("+team.getWins()+","+team.getTies()+")\n");
        }
    }
}
