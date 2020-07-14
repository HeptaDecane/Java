import java.text.DecimalFormat;

public class Track {
// Fields
    private String title;
    private String artist;
    private int mins;
    private int secs;

// Constructors
    public Track(String title,String artist ,int duration){
        this.title = title;
        this.artist = artist;
        this.mins = duration/60;
        this.secs = duration%60;
    }

// Methods
    public String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        DecimalFormat duration = new DecimalFormat("00");
        String str = String.format("%-35s",artist+" - "+title);
        return (str+"\t"+duration.format(mins)+":"+duration.format(secs));
    }

}
