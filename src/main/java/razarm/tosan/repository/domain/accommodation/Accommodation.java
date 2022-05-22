package razarm.tosan.repository.domain.accommodation;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.Costable;
import razarm.tosan.repository.domain.Timeable;
import razarm.tosan.repository.domain.location.Address;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Set;

public abstract class Accommodation extends BaseEntity
        implements Costable, Timeable {

    protected final String name;
    protected final AccommodationType type;
    protected final Address address;
    protected final BigInteger price;
    protected final Long time;
    protected final AccommodationProvider accommodationProvider;
    protected final Set<AccommodationOrder> accommodationOrders;


    public abstract AccommodationType getType();

    public Accommodation(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, AccommodationType type, Address address, BigInteger price, Long time, AccommodationProvider accommodationProvider, Set<AccommodationOrder> accommodationOrders) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.address = address;
        this.price = price;
        this.time = time;
        this.accommodationProvider = accommodationProvider;
        this.accommodationOrders = accommodationOrders;
    }

    public String getName() {
        return name;
    }



    public Address getAddress() {
        return address;
    }

    public BigInteger getPrice() {
        return price;
    }

    public Long getTime() {
        return time;
    }

    public AccommodationProvider getAccommodationProvider() {
        return accommodationProvider;
    }

    public Set<AccommodationOrder> getAccommodationOrders() {
        return accommodationOrders;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Accommodation{");
        sb.append("id='").append(id).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append(", modifiedAt=").append(modifiedAt);
        sb.append(", createdBy='").append(createdBy).append('\'');
        sb.append(", modifiedBy='").append(modifiedBy).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", type=").append(type);
        sb.append(", address=").append(address);
        sb.append(", price=").append(price);
        sb.append(", time=").append(time);
        sb.append(", accommodationProvider=").append(accommodationProvider);
        sb.append(", accommodationOrders=").append(accommodationOrders);
        sb.append('}');
        return sb.toString();
    }
}
