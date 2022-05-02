package razarm.tosan.repository.data.transport;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.domain.transport.VehicleType;

import java.math.BigInteger;
import java.time.Instant;

public abstract class VehicleData extends BaseEntityData {
    protected final String name;
    protected final VehicleType type;
    protected final String fromStation;
    protected final String toStation;
    protected final String ticketNumber;
    protected final BigInteger price;
    protected final Instant departure;
    protected final Instant arrival;
    protected final VehicleProviderData vehicleProvider;

    public VehicleData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, VehicleType type, String fromStation, String toStation, String ticketNumber, BigInteger price, Instant departure, Instant arrival, VehicleProviderData vehicleProvider) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.type = type;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.ticketNumber = ticketNumber;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.vehicleProvider = vehicleProvider;
    }

    public String getName() {
        return name;
    }

    public VehicleType getType() {
        return type;
    }

    public String getFromStation() {
        return fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public BigInteger getPrice() {
        return price;
    }

    public Instant getDeparture() {
        return departure;
    }

    public Instant getArrival() {
        return arrival;
    }

    public VehicleProviderData getVehicleProvider() {
        return vehicleProvider;
    }


}
