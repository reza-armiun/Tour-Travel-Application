package razarm.tosan.repository.domain.transport;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Set;

public class Plane extends  Vehicle{
    private final Integer allowedLuggage;
    private final String cabinClass;
    private final Long planeNumber;
    private final VehicleType type = VehicleType.PLANE;


    public Plane(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String fromStation, String toStation, String ticketNumber, BigInteger price, Instant departure, Instant arrival, VehicleProvider vehicleProvider, Set<VehicleOrder> vehicleOrders, Integer allowedLuggage, String cabinClass, Long planeNumber) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy, name, VehicleType.PLANE, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider, vehicleOrders);
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
    public BigInteger calculatePrice() {
        return null;
    }

    @Override
    public Plane cloneWithId(String id) {
        return new Plane(id, createdAt, modifiedAt, createdBy, modifiedBy, name, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider, vehicleOrders, allowedLuggage, cabinClass, planeNumber);
    }

    @Override
    public Long estimateTime() {
        return null;
    }


    public static final class PlaneBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        protected String name;
        protected VehicleType type;
        protected String fromStation;
        protected String toStation;
        protected String ticketNumber;
        protected BigInteger price;
        protected Instant departure;
        protected Instant arrival;
        protected VehicleProvider vehicleProvider;
        protected Set<VehicleOrder> vehicleOrders;
        private Integer allowedLuggage;
        private String cabinClass;
        private Long planeNumber;

        private PlaneBuilder() {
        }

        public static PlaneBuilder aPlane() {
            return new PlaneBuilder();
        }

        public PlaneBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PlaneBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PlaneBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public PlaneBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public PlaneBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public PlaneBuilder allowedLuggage(Integer allowedLuggage) {
            this.allowedLuggage = allowedLuggage;
            return this;
        }

        public PlaneBuilder cabinClass(String cabinClass) {
            this.cabinClass = cabinClass;
            return this;
        }

        public PlaneBuilder planeNumber(Long planeNumber) {
            this.planeNumber = planeNumber;
            return this;
        }

        public PlaneBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlaneBuilder type(VehicleType type) {
            this.type = type;
            return this;
        }

        public PlaneBuilder fromStation(String fromStation) {
            this.fromStation = fromStation;
            return this;
        }

        public PlaneBuilder toStation(String toStation) {
            this.toStation = toStation;
            return this;
        }

        public PlaneBuilder ticketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
            return this;
        }

        public PlaneBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public PlaneBuilder departure(Instant departure) {
            this.departure = departure;
            return this;
        }

        public PlaneBuilder arrival(Instant arrival) {
            this.arrival = arrival;
            return this;
        }

        public PlaneBuilder vehicleProvider(VehicleProvider vehicleProvider) {
            this.vehicleProvider = vehicleProvider;
            return this;
        }

        public PlaneBuilder vehicleOrders(Set<VehicleOrder> vehicleOrders) {
            this.vehicleOrders = vehicleOrders;
            return this;
        }

        public Plane build() {
            return new Plane(id, createdAt, modifiedAt, createdBy, modifiedBy, name, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider, vehicleOrders, allowedLuggage, cabinClass, planeNumber);
        }
    }
}
