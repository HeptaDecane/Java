import java.util.HashSet;
import java.util.Set;

public abstract class CelestialObject {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<CelestialObject> satellites;

    public CelestialObject(String name,double orbitalPeriod,Category category){
        this.key = new Key(name,category);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public boolean addSatellite(CelestialObject satellite){
       return satellites.add(satellite);
    }

    public Set<CelestialObject> getSatellites(){
        return new HashSet<CelestialObject>(satellites);
    }

    public static Key generateKey(String name, Category category){
        return new Key(name,category);
    }

    @Override
    public String toString() {
        return key.name+" "+key.category+" : "+orbitalPeriod+" Days";
    }

    public Key getKey(){
        return key;
    }

    @Override
    public final int hashCode() {
        return key.hashCode();
    }

    @Override
    public final boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj instanceof CelestialObject){
            CelestialObject first = this;
            CelestialObject second = (CelestialObject) obj;
            return first.key.equals(second.key);
        }
        return false;
    }

    public static enum Category{
        STAR,PLANET,MOON,COMET,ASTEROID,METEORS
    }

    public static final class Key{
        private String name;
        private Category category;

        private Key(String name,Category category){
            this.name = name;
            this.category = category;
        }

        public Category getCategory(){
            return category;
        }

        @Override
        public int hashCode() {
            return name.hashCode()+category.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj)
                return true;
            Key first = this;
            Key second = (Key) obj;
            if(first.name.equals(second.name))
                return first.category==second.category;
            return false;
        }
    }
}
