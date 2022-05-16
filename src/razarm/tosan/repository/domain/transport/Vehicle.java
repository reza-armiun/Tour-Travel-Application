package razarm.tosan.repository.domain.transport;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.Discountable;
import razarm.tosan.repository.domain.Costable;
import razarm.tosan.repository.domain.Timeable;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Set;

public abstract class Vehicle extends BaseEntity
        implements Costable, Timeable {

    protected final String name;
    protected final VehicleType type;
    protected final String fromStation;
    protected final String toStation;
    protected final String ticketNumber;
    protected final BigInteger price;

    protected final Instant departure;
    protected final Instant arrival;

    protected final VehicleProvider vehicleProvider;
    protected final Set<VehicleOrder> vehicleOrders;

    public abstract VehicleType getType();
    public abstract Vehicle cloneWithId(String id);
    public Vehicle(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, VehicleType type, String fromStation, String toStation, String ticketNumber, BigInteger price, Instant departure, Instant arrival, VehicleProvider vehicleProvider, Set<VehicleOrder> vehicleOrders) {
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
        this.vehicleOrders = vehicleOrders;
    }

    public String getName() {
        return name;
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

    public VehicleProvider getVehicleProvider() {
        return vehicleProvider;
    }

    public Set<VehicleOrder> getVehicleOrders() {
        return vehicleOrders;
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", fromStation='" + fromStation + '\'' +
                ", toStation='" + toStation + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", price=" + price +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", vehicleProvider=" + vehicleProvider +
                '}';
    }
}
