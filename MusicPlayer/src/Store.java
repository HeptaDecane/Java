import java.text.DecimalFormat;
import java.util.ArrayList;

public class Store {
// Fields
    ArrayList<Track> tracks;

// Constructors
    public Store(){
        tracks = new ArrayList<Track>();
        initialize();
    }

// Methods
    public void initialize(){
        tracks.add(new Track("Maluma","Black Eyed Peas",258));
        tracks.add(new Track("Be Happy","Dixie D'Amelio",199));
        tracks.add(new Track("Be Kind","Marshmello",185));
        tracks.add(new Track("Sour Candy","Lady Gaga",158));
        tracks.add(new Track("Savage Love","Jason Derulo",173));
        tracks.add(new Track("The Kids are Alright","EBEN",180));
        tracks.add(new Track("Lose You","Tiesto",150));
        tracks.add(new Track("Naked","Jonas Blue",213));
        tracks.add(new Track("I Cry","Usher",227));
        tracks.add(new Track("Tap In","Saweetie",151));
        tracks.add(new Track("Power","Ellie Goulding",198));
        tracks.add(new Track("In Your Eyes","The Weekend",261));
        tracks.add(new Track("Comeback","JoJo",176));
        tracks.add(new Track("Past Life","Salena Gomez",157));
        tracks.add(new Track("Fire Drill","Melanie Martinez",256));
        tracks.add(new Track("Small Things","JoJo",214));
        tracks.add(new Track("Girlfriend","Charlie Puth",178));
        tracks.add(new Track("Heat Waves","Glass Animals",236));
        tracks.add(new Track("No More","B",186));
        tracks.add(new Track("Sigala","Becky Hill",197));
        tracks.add(new Track("Exhale","Kenzie",165));
        tracks.add(new Track("Attitude","Deante Hitchcock",223));
        tracks.add(new Track("Girl Like Me","Black Eyed Peas",225));
        tracks.add(new Track("Nobody","INNA",172));
        tracks.add(new Track("Together","Sia",209));
        tracks.add(new Track("Daisies","Katy Perry",177));
        tracks.add(new Track("911","Lady Gaga",174));
        tracks.add(new Track("Toosie Slide","Drake",312));
    }

    public Track getTrack(int index){
        if(index>=0 && index<tracks.size())
            return tracks.get(index);
        return null;
    }

    public Track getTrack(String title){
        for(Track track : tracks){
            if(track.getTitle().equals(title))
                return track;
        }
        return null;
    }

    public void addTrack(Track track){
        tracks.add(track);
    }

    public void showTracks(){
        int i=0;
        System.out.println("------------------------STORE------------------------");
        for(Track track:tracks){
            i++;
            DecimalFormat sr = new DecimalFormat("000. ");
            System.out.println(sr.format(i)+track.toString());
        }
        System.out.println("----------------------------------------------------\n");
    }


}
