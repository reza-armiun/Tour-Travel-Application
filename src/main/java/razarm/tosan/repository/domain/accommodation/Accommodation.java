package razarm.tosan.repository.domain.accommodation;

import lombok.ToString;
import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.Costable;
import razarm.tosan.repository.domain.Timeable;
import razarm.tosan.repository.domain.location.Address;

import java.math.BigInteger;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Set;

@ToString
public abstract class Accommodation extends BaseEntity implements Costable, Timeable {

    protected final String name;
    protected final AccommodationType type;
    protected final Address address;
    protected final BigInteger price;
    protected final ZonedDateTime checkIn;
    protected final ZonedDateTime checkOut;
    protected final AccommodationProvider accommodationProvider;
    protected final Set<AccommodationOrder> accommodationOrders;

    public abstract AccommodationType getType();

    public Accommodation(
            String id,
            Instant createdAt,
            Instant modifiedAt,
            String createdBy,
            String modifiedBy,
            String name,
            AccommodationType type,
            Address address,
            BigInteger price,
            ZonedDateTime checkIn,
            ZonedDateTime checkOut,
            AccommodationProvider accommodationProvider,
            Set<AccommodationOrder> accommodationOrders) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.address = address;
        this.price = price;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

    public ZonedDateTime getCheckIn() {
        return checkIn;
    }

    public ZonedDateTime getCheckOut() {
        return checkOut;
    }

    public AccommodationProvider getAccommodationProvider() {
        return accommodationProvider;
    }

    public Set<AccommodationOrder> getAccommodationOrders() {
        return accommodationOrders;
    }
}

