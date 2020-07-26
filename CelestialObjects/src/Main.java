import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<CelestialObject.Key,CelestialObject> solarSystem;
    private static Set<CelestialObject> planets;
    private static Set<CelestialObject> stars;
    private static Set<CelestialObject> moons;

    static {
        solarSystem = new HashMap<>();
        planets = new HashSet<>();
        stars = new HashSet<>();
        moons = new HashSet<>();
        CelestialObject object;

        object = new Star("Sun",0.0);
        solarSystem.put(object.getKey(),object);
        object.addSatellite(new Planet("Mercury",0.241));
        object.addSatellite(new Planet("Venus",0.6152));
        object.addSatellite(new Planet("Earth",1.0));
        object.addSatellite(new Planet("Mars",1.8809));
        object.addSatellite(new Planet("Jupiter",11.8618));
        object.addSatellite(new Planet("Saturn",29.5));
        object.addSatellite(new Planet("Uranus",84.0));
        object.addSatellite(new Planet("Neptune",164.8));

        planets = new HashSet<>(object.getSatellites());
        for(CelestialObject planet:planets)
            solarSystem.put(planet.getKey(),planet);

    }

    public static void main(String[] args) {
        for(CelestialObject.Key key:solarSystem.keySet())
            System.out.println(solarSystem.get(key));
    }
}

