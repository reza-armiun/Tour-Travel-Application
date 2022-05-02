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
}
