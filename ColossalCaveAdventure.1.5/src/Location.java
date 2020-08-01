import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class Location implements Serializable {
    private final int locationID;
    private final String description;
    private final Map<String,Integer> exits;
    private long serialVersionUID = 0;

    public Location(int locationID,String description){
        this(locationID,description,new HashMap<>());
    }

    public Location(int locationID,String description,Map<String,Integer> exits){
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<>(exits);
        this.exits.put("Q",0);
    }

    public void addExit(String direction,int location){
        exits.put(direction,location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }
}
