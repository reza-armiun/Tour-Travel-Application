package razarm.tosan.controller.dto.transport;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import razarm.tosan.controller.dto.BaseEntityDto;
import razarm.tosan.controller.dto.accommodation.HotelDto;
import razarm.tosan.repository.domain.transport.VehicleType;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BusDto.class, name = "BUS"),
        @JsonSubTypes.Type(value = PlaneDto.class, name = "PLANE"),
})
public class VehicleDto extends BaseEntityDto {
    protected  String name;
    protected  VehicleType type;
    protected  String fromStation;
    protected  String toStation;
    protected  String ticketNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected  BigInteger price;
    protected  ZonedDateTime departure;
    protected  ZonedDateTime arrival;
    protected  VehicleProviderDto vehicleProvider;

    public VehicleDto() {}

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


    public void setName(String name) {
        this.name = name;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public void setDeparture(ZonedDateTime departure) {
        this.departure = departure;
    }

    public void setArrival(ZonedDateTime arrival) {
        this.arrival = arrival;
    }

    public void setVehicleProvider(VehicleProviderDto vehicleProvider) {
        this.vehicleProvider = vehicleProvider;
    }

    public static final class VehicleDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        protected String name;
        protected VehicleType type;
        protected String fromStation;
        protected String toStation;
        protected String ticketNumber;
        protected BigInteger price;
        protected ZonedDateTime departure;
        protected ZonedDateTime arrival;
        protected VehicleProviderDto vehicleProvider;

        private VehicleDtoBuilder() {
        }

        public static VehicleDtoBuilder aVehicleDto() {
            return new VehicleDtoBuilder();
        }

        public VehicleDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public VehicleDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public VehicleDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public VehicleDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public VehicleDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public VehicleDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public VehicleDtoBuilder type(VehicleType type) {
            this.type = type;
            return this;
        }

        public VehicleDtoBuilder fromStation(String fromStation) {
            this.fromStation = fromStation;
            return this;
        }

        public VehicleDtoBuilder toStation(String toStation) {
            this.toStation = toStation;
            return this;
        }

        public VehicleDtoBuilder ticketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
            return this;
        }

        public VehicleDtoBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public VehicleDtoBuilder departure(ZonedDateTime departure) {
            this.departure = departure;
            return this;
        }

        public VehicleDtoBuilder arrival(ZonedDateTime arrival) {
            this.arrival = arrival;
            return this;
        }

        public VehicleDtoBuilder vehicleProvider(VehicleProviderDto vehicleProvider) {
            this.vehicleProvider = vehicleProvider;
            return this;
        }

        public VehicleDto build() {
            return new VehicleDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, type, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", VehicleDto.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("type=" + type)
                .add("fromStation='" + fromStation + "'")
                .add("toStation='" + toStation + "'")
                .add("ticketNumber='" + ticketNumber + "'")
                .add("price=" + price)
                .add("departure=" + departure)
                .add("arrival=" + arrival)
                .add("vehicleProvider=" + vehicleProvider)
                .toString();
    }
}
