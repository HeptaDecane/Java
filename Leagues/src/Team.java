import java.util.ArrayList;
import java.util.List;

public class Team<E extends Player> implements Comparable<Team<E>>{
    private String name;
    private int matches;
    private int wins;
    private int ties;
    private List<E> players;

    public Team(String name){
        this.name = name;
        matches = 0;
        wins = 0;
        ties = 0;
        players = new ArrayList<>();
    }

    public String getName(){
        return name;
    }
    public int getMatches(){
        return matches;
    }
    public int getWins(){
        return wins;
    }
    public int getTies(){
        return ties;
    }

    public boolean addPlayer(E newPlayer){
        if(players.contains(newPlayer))
            return false;
        players.add(newPlayer);
        return true;
    }

    public void updateScore(Team<E> opp,int home,int away){
        if(home>away)
            this.wins++;
        else if(home<away)
            opp.wins++;
        else{
            this.ties++;
            opp.ties++;
        }
        this.matches++;
        opp.matches++;
    }

    public int score(){
        return wins*2 + ties;
    }

    @Override
    public int compareTo(Team<E> second) {
        Team<E> first = this;
        if(first.score()>second.score())
            return -1;
        else if(first.score()<second.score())
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
