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
            return false;
        }
        index = iterator.nextIndex();
        System.out.println("Playing: "+queue.get(index).getTitle());
        return true;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean next(){
        if(index==-1)
            return play();
        if(index==queue.size()-1)
            return false;
        if(iterator.hasNext()) {
            iterator.next();
            play();
            return true;
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

    public boolean addTrack(Track track){
        if(track == null)
            return false;
        queue.add(track);
        goToStart();
        return true;
    }

    public boolean addTrack(Track track,int index){
        if(track == null)
            return false;
        if(index<0 || index>=queue.size())
            return false;
        queue.add(index,track);
        goToStart();
        return true;
    }

    public boolean removeTrack(String title){
        goToStart();
        while(iterator.hasNext()){
            if(iterator.next().getTitle().equals(title)) {
                iterator.remove();
                goToStart();
                return true;
            }
        }
        return false;
    }

    public boolean removeTrack(int index){
        if(index<0 || index>=queue.size())
            return false;
        queue.remove(index);
        goToStart();
        return true;
    }


    public boolean showPlayList(){
        if(queue.isEmpty())
            return false;
        System.out.println("\n------------------PLAYLIST: "+name+"------------------");
        int i=0;
        DecimalFormat sr = new DecimalFormat("00. ");
        for(Track track:queue){
            if(i==index)
                System.out.println(sr.format(i+1)+track+" <=");
            else
                System.out.println(sr.format(i+1)+track);
            i++;
        }
        System.out.println("----------------------------------------------------\n");
        return true;
    }
    public void delete(){
        queue.clear();
    }
    public void goToStart(){
        iterator = queue.listIterator();
        index = -1;
    }

}
