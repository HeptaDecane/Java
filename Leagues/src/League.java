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

    public boolean add(E team){
        if(teams.contains(team))
            return false;
        teams.add(team);
        return true;
    }

    public void scoreboard(){
        Collections.sort(teams);
        for(E team:teams)
            System.out.println(team.getName()+" : "+team.score());
    }
}
