import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {
// Fields
    private String name;
    private LinkedList<Track> queue;
    private ListIterator<Track> iterator;
    int index;

// Constructors
    public Playlist(String name){
        this.name = name;
        queue = new LinkedList<Track>();
        iterator = queue.listIterator();
        index = -1;
    }

// Methods
    public boolean play(){
        if(queue.isEmpty()){
            System.out.println("Play List Empty!");
            return false;
        }
        index = iterator.nextIndex();
        if(index<0||index>=queue.size())
            return false;
        System.out.println("Playing: "+queue.get(index).getTitle());
        return true;
    }

    public boolean next(){
        if(index==-1)
            return play();
        if(index==queue.size()-1)
            return false;
        if(iterator.hasNext()) {
            iterator.next();
            play();
        }
        return false;
    }

    public boolean previous(){
        if(iterator.hasPrevious()){
            iterator.previous();
            return play();
        }
        return false;
    }

    public Track getTrack(String title){
        for(Track track:queue){
            if(track.getTitle().equals(title))
                return track;
        }
        return null;
    }

    public boolean addTrack(Track track){
        if(track == null)
            return false;
        queue.add(track);
        iterator = queue.listIterator();
        return true;
    }

    public void showPlayList(){
        int i=0;
        DecimalFormat sr = new DecimalFormat("00. ");
        for(Track track:queue){
            if(i==index)
                System.out.println(sr.format(i+1)+track+" <=");
            else
                System.out.println(sr.format(i+1)+track);
            i++;
        }
    }

}
