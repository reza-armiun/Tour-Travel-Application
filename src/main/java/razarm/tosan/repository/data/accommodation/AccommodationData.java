package razarm.tosan.repository.data.accommodation;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.data.location.AddressData;
import razarm.tosan.repository.domain.accommodation.AccommodationType;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.Instant;

public abstract class AccommodationData extends BaseEntityData implements Serializable {
    protected final String name;
    protected final AccommodationType type;
    protected final AddressData address;
    protected final BigInteger price;
    protected final Instant checkIn;
    protected final Instant checkOut;
    protected final AccommodationProviderData accommodationProvider;

    public AccommodationData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, AccommodationType type, AddressData address, BigInteger price, Instant checkIn, Instant checkOut, AccommodationProviderData accommodationProvider) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.address = address;
        this.price = price;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.accommodationProvider = accommodationProvider;
    }

    public String getName() {
        return name;
    }

    public AccommodationType getType() {
        return type;
    }

    public AddressData getAddress() {
        return address;
    }

    public BigInteger getPrice() {
        return price;
    }

    public Instant getCheckIn() {
        return checkIn;
    }

    public Instant getCheckOut() {
        return checkOut;
    }

    public AccommodationProviderData getAccommodationProvider() {
        return accommodationProvider;
    }




}
