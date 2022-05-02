package razarm.tosan.repository.data.accommodation;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.domain.accommodation.AccommodationType;
import razarm.tosan.repository.domain.location.Address;

import java.math.BigInteger;
import java.time.Instant;

public abstract class AccommodationData extends BaseEntityData {
    protected final String name;
    protected final AccommodationType type;
    protected final Address address;
    protected final BigInteger price;
    protected final Long time;
    protected final AccommodationProviderData accommodationProvider;

    public AccommodationData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, AccommodationType type, Address address, BigInteger price, Long time, AccommodationProviderData accommodationProvider) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.address = address;
        this.price = price;
        this.time = time;
        this.accommodationProvider = accommodationProvider;
    }

    public String getName() {
        return name;
    }

    public AccommodationType getType() {
        return type;
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

    public AccommodationProviderData getAccommodationProvider() {
        return accommodationProvider;
    }


}
