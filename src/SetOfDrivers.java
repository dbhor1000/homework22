import java.util.HashSet;
import java.util.Objects;

public class SetOfDrivers {

    HashSet<Driver> drivers = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SetOfDrivers that = (SetOfDrivers) o;
        return drivers.equals(that.drivers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drivers);
    }
}
