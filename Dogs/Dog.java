package Dogs;

public class Dog {

    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof Dog) {
            String objName = ((Dog) obj).getName();
            if (this.name.equals(objName)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int code = this.name.hashCode() + 11;
        System.out.println("hashcode: " + code);
        return code;
        
    }
}
