public class Main {
    public static void main(String[] args) {
        Team<SoccerPlayer> soccerTeam = new Team("FCB");
        soccerTeam.addPlayer(new SoccerPlayer("player01"));
/*
        soccerTeam.addPlayer(new CricketPlayer("player02"));
        Error:
            Required type: SoccerPlayer
            Provided: CricketPlayer
*/


        League<Team<SoccerPlayer>> fifa = new League("FIFA 2022");
        Team<SoccerPlayer>[] clubs= new Team[7];

        for(int i=0;i<7;i++){
            clubs[i] = new Team("ST"+(i+1));
            fifa.addTeam(clubs[i]);
        }
/*
        fifa.addTeam(new Team<CricketPlayer>("INC"));
        Error:
            Required type: Team<SoccerPlayer>
            Provided: Team<CricketPlayer>
*/

        fifa.fixtures();
        fifa.scoreboard();
    }

}
