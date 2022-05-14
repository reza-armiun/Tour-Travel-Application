package razarm.tosan.repository.data.transport;

import razarm.tosan.repository.data.BaseEntityData;
import razarm.tosan.repository.domain.transport.VehicleType;

import java.math.BigInteger;
import java.time.Instant;

public class PlaneData extends VehicleData{
    private final Integer allowedLuggage;
    private final String cabinClass;
    private final Long planeNumber;
    private final VehicleType type = VehicleType.PLANE;

    public PlaneData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String fromStation, String toStation, String ticketNumber, BigInteger price, Instant departure, Instant arrival, VehicleProviderData vehicleProvider, Integer allowedLuggage, String cabinClass, Long planeNumber) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, VehicleType.PLANE, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider);
        this.allowedLuggage = allowedLuggage;
        this.cabinClass = cabinClass;
        this.planeNumber = planeNumber;
    }

    public Integer getAllowedLuggage() {
        return allowedLuggage;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public Long getPlaneNumber() {
        return planeNumber;
    }

    @Override
    public VehicleType getType() {
        return type;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new PlaneData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider, allowedLuggage, cabinClass, planeNumber);
    }


    public static final class PlaneDataBuilder {
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
        private Integer allowedLuggage;
        private String cabinClass;
        private Long planeNumber;
        private VehicleType type = VehicleType.PLANE;

        private PlaneDataBuilder() {
        }

        public static PlaneDataBuilder aPlaneData() {
            return new PlaneDataBuilder();
        }

        public PlaneDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PlaneDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PlaneDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public PlaneDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public PlaneDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public PlaneDataBuilder allowedLuggage(Integer allowedLuggage) {
            this.allowedLuggage = allowedLuggage;
            return this;
        }

        public PlaneDataBuilder cabinClass(String cabinClass) {
            this.cabinClass = cabinClass;
            return this;
        }

        public PlaneDataBuilder planeNumber(Long planeNumber) {
            this.planeNumber = planeNumber;
            return this;
        }

        public PlaneDataBuilder type(VehicleType type) {
            this.type = type;
            return this;
        }

        public PlaneDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlaneDataBuilder fromStation(String fromStation) {
            this.fromStation = fromStation;
            return this;
        }

        public PlaneDataBuilder toStation(String toStation) {
            this.toStation = toStation;
            return this;
        }

        public PlaneDataBuilder ticketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
            return this;
        }

        public PlaneDataBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public PlaneDataBuilder departure(Instant departure) {
            this.departure = departure;
            return this;
        }

        public PlaneDataBuilder arrival(Instant arrival) {
            this.arrival = arrival;
            return this;
        }

        public PlaneDataBuilder vehicleProvider(VehicleProviderData vehicleProvider) {
            this.vehicleProvider = vehicleProvider;
            return this;
        }

        public PlaneData build() {
            return new PlaneData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider, allowedLuggage, cabinClass, planeNumber);
        }
    }
}
