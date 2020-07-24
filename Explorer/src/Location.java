import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public final class Location {
    private final int locationID;
    private final String description;
    private final Map<String,Integer> exits;

    public Location(int locationID,String description,Map<String,Integer> exits){
        this.locationID = locationID;
        this.description = description;
        this.exits = new LinkedHashMap<>(exits);
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
        return new LinkedHashMap<>(exits);
    }
}
