package razarm.tosan.repository.data.transport;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.domain.transport.VehicleType;

import java.math.BigInteger;
import java.time.Instant;


public class BusData extends VehicleData {
    private final String busModel;
    private final VehicleType type = VehicleType.BUS;

    public BusData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String fromStation, String toStation, String ticketNumber, BigInteger price, Instant departure, Instant arrival, VehicleProviderData vehicleProvider, String busModel) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, VehicleType.BUS, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider);
        this.busModel = busModel;
    }

    public String getBusModel() {
        return busModel;
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new BusData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider, busModel);
    }


    public static final class BusDataBuilder {
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
        protected VehicleProviderData vehicleProvider;
        private String busModel;
        private VehicleType type = VehicleType.BUS;

        private BusDataBuilder() {
        }

        public static BusDataBuilder aBusData() {
            return new BusDataBuilder();
        }

        public BusDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public BusDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public BusDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public BusDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public BusDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public BusDataBuilder busModel(String busModel) {
            this.busModel = busModel;
            return this;
        }

        public BusDataBuilder type(VehicleType type) {
            this.type = type;
            return this;
        }

        public BusDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BusDataBuilder fromStation(String fromStation) {
            this.fromStation = fromStation;
            return this;
        }

        public BusDataBuilder toStation(String toStation) {
            this.toStation = toStation;
            return this;
        }

        public BusDataBuilder ticketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
            return this;
        }

        public BusDataBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public BusDataBuilder departure(Instant departure) {
            this.departure = departure;
            return this;
        }

        public BusDataBuilder arrival(Instant arrival) {
            this.arrival = arrival;
            return this;
        }

        public BusDataBuilder vehicleProvider(VehicleProviderData vehicleProvider) {
            this.vehicleProvider = vehicleProvider;
            return this;
        }

        public BusData build() {
            return new BusData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider, busModel);
        }
    }
}
