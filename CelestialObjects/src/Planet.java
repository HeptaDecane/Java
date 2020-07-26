public class Planet extends CelestialObject {
    public Planet(String name,double orbitalPeriod){
        super(name,orbitalPeriod,Category.PLANET);
    }

    @Override
    public boolean addSatellite(CelestialObject satellite) {
        if(satellite.getKey().getCategory() == Category.MOON){
            return super.addSatellite(satellite);
        }
        return false;
    }


}
