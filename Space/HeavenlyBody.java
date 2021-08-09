package Space;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private BodyType bodyType;

    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        /*
        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        */

        if (obj instanceof HeavenlyBody) {
            String objName = ((HeavenlyBody) obj).getName();
            return this.name.equals(objName);
        }

        //String objName = ((HeavenlyBody) obj).getName();
        //return this.name.equals(objName);

        return false;
    }    

    @Override
    public int hashCode() {
        System.out.println("hashCode called");
        return this.name.hashCode() + this.getBodyType().hashCode() + 57;
    }
}
