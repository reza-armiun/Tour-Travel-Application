package razarm.tosan.repository.domain.transport;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Set;

public class Bus extends Vehicle{
    private final String busModel;
    private final VehicleType type = VehicleType.BUS;


    public Bus(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String fromStation, String toStation, String ticketNumber, BigInteger price, Instant departure, Instant arrival, VehicleProvider vehicleProvider, Set<VehicleOrder> vehicleOrders, String busModel) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, VehicleType.BUS, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider, vehicleOrders);
        this.busModel = busModel;
    }

    @Override
    public BigInteger calculatePrice() {
        return null;
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    @Override
    public Vehicle cloneWithId(String id) {
        return new Bus(id, createdAt, modifiedAt, createdBy, modifiedBy, name, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider, vehicleOrders, busModel);
    }


    public String getBusModel() {
        return busModel;
    }

    @Override
    public Long estimateTime() {
        return null;
    }


    public static final class BusBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        protected String name;
        protected String fromStation;
        protected String toStation;
        protected String ticketNumber;
        protected BigInteger price;
        protected Instant departure;
        protected Instant arrival;
        protected VehicleProvider vehicleProvider;
        protected Set<VehicleOrder> vehicleOrders;
        private String busModel;

        private BusBuilder() {
        }

        public static BusBuilder aBus() {
            return new BusBuilder();
        }

        public BusBuilder id(String id) {
            this.id = id;
            return this;
        }

        public BusBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public BusBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public BusBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public BusBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public BusBuilder busModel(String busModel) {
            this.busModel = busModel;
            return this;
        }

        public BusBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BusBuilder fromStation(String fromStation) {
            this.fromStation = fromStation;
            return this;
        }

        public BusBuilder toStation(String toStation) {
            this.toStation = toStation;
            return this;
        }

        public BusBuilder ticketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
            return this;
        }

        public BusBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public BusBuilder departure(Instant departure) {
            this.departure = departure;
            return this;
        }

        public BusBuilder arrival(Instant arrival) {
            this.arrival = arrival;
            return this;
        }

        public BusBuilder vehicleProvider(VehicleProvider vehicleProvider) {
            this.vehicleProvider = vehicleProvider;
            return this;
        }

        public BusBuilder vehicleOrders(Set<VehicleOrder> vehicleOrders) {
            this.vehicleOrders = vehicleOrders;
            return this;
        }

        public Bus build() {
            return new Bus(id, createdAt, modifiedAt, createdBy, modifiedBy, name, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider, vehicleOrders, busModel);
        }
    }
}
