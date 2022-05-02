package razarm.tosan.controller.dto.transport;

import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.repository.domain.transport.VehicleType;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public class VehicleDto extends BaseEntityDto {
    protected final String name;
    protected final VehicleType type;
    protected final String fromStation;
    protected final String toStation;
    protected final String ticketNumber;
    protected final BigInteger price;
    protected final ZonedDateTime departure;
    protected final ZonedDateTime arrival;
    protected final VehicleProviderDto vehicleProvider;

    public VehicleDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, VehicleType type, String fromStation, String toStation, String ticketNumber, BigInteger price, ZonedDateTime departure, ZonedDateTime arrival, VehicleProviderDto vehicleProvider) {
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

    public ZonedDateTime getDeparture() {
        return departure;
    }

    public ZonedDateTime getArrival() {
        return arrival;
    }

    public VehicleProviderDto getVehicleProvider() {
        return vehicleProvider;
    }
}
