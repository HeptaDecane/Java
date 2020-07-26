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
        object.addSatellite(new Planet("Mercury",88.0));
        object.addSatellite(new Planet("Venus",224.7));
        object.addSatellite(new Planet("Earth",365.2));
        object.addSatellite(new Planet("Mars",687.0));
        object.addSatellite(new Planet("Jupiter",4331));
        object.addSatellite(new Planet("Saturn",10747));
        object.addSatellite(new Planet("Uranus",30589));
        object.addSatellite(new Planet("Neptune",59800));

        stars.add(object);
        planets = new HashSet<>();
        planets.addAll(object.getSatellites());
        for(CelestialObject planet:planets)
            solarSystem.put(planet.getKey(),planet);

        object = solarSystem.get(CelestialObject.generateKey("Earth",CelestialObject.Category.PLANET));
        object.addSatellite(new Moon("Luna",27.3));

        object = solarSystem.get(CelestialObject.generateKey("Mars",CelestialObject.Category.PLANET));
        object.addSatellite(new Moon("Deimos",(double)30/24));
        object.addSatellite(new Moon("Phobos",(double)8/24));


        object = solarSystem.get(CelestialObject.generateKey("Jupiter",CelestialObject.Category.PLANET));
        object.addSatellite(new Moon("Ganymede",(double)172/24));
        object.addSatellite(new Moon("Callisto",17));
        object.addSatellite(new Moon("Io",(double)42/24));
        object.addSatellite(new Moon("Europa",(double)85/24));
        object.addSatellite(new Moon("Amalthea",(double)12/24));


        object = solarSystem.get(CelestialObject.generateKey("Saturn",CelestialObject.Category.PLANET));
        object.addSatellite(new Moon("Titan",16));
        object.addSatellite(new Moon("Rhea",(double)108/24));
        object.addSatellite(new Moon("Iapetus",79));
        object.addSatellite(new Moon("Dione",(double)66/24));
        object.addSatellite(new Moon("Tethys",(double)45/24));

        object = solarSystem.get(CelestialObject.generateKey("Uranus",CelestialObject.Category.PLANET));
        object.addSatellite(new Moon("Titania",(double)209/24));
        object.addSatellite(new Moon("Oberon",13));
        object.addSatellite(new Moon("Umbriel",(double)99/24));
        object.addSatellite(new Moon("Ariel",(double)60/24));
        object.addSatellite(new Moon("Miranda",(double)34/24));

        object = solarSystem.get(CelestialObject.generateKey("Neptune",CelestialObject.Category.PLANET));
        object.addSatellite(new Moon("Triton",(double)141/24));
        object.addSatellite(new Moon("Proteus",(double)27/24));
        object.addSatellite(new Moon("Nereid",360));
        object.addSatellite(new Moon("Larissa",(double)13/24));
        object.addSatellite(new Moon("Galatea",(double)10/24));

        for(CelestialObject planet:planets)
            for(CelestialObject moon:planet.getSatellites()) {
                solarSystem.put(moon.getKey(), moon);
                moons.add(moon);
            }

    }

    public static void main(String[] args) {
        System.out.println("SolarSystem: ");
        for(CelestialObject.Key key:solarSystem.keySet())
            System.out.println(solarSystem.get(key));

        System.out.println();

        System.out.println("Stars: ");
        for(CelestialObject star:stars)
            System.out.println(star);

        System.out.println();

        System.out.println("Planets: ");
        for(CelestialObject planet:planets)
            System.out.println(planet);

        System.out.println();

        System.out.println("Moons: ");
        for(CelestialObject moon:moons)
            System.out.println(moon);
    }
}

