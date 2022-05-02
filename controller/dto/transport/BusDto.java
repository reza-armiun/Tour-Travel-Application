package razarm.tosan.controller.dto.transport;

import razarm.tosan.repository.domain.transport.VehicleType;

import java.math.BigInteger;
import java.time.ZonedDateTime;


public class BusDto extends VehicleDto{
    private final Integer allowedLuggage;
    private final String cabinClass;
    private final Long planeNumber;
    private final VehicleType type = VehicleType.PLANE;

    public BusDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, String fromStation, String toStation, String ticketNumber, BigInteger price, ZonedDateTime departure, ZonedDateTime arrival, VehicleProviderDto vehicleProvider, Integer allowedLuggage, String cabinClass, Long planeNumber) {
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


    public static final class BusDtoBuilder {
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
        private Integer allowedLuggage;
        private String cabinClass;
        private Long planeNumber;

        private BusDtoBuilder() {
        }

        public static BusDtoBuilder aBusDto() {
            return new BusDtoBuilder();
        }

        public BusDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public BusDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public BusDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public BusDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public BusDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public BusDtoBuilder allowedLuggage(Integer allowedLuggage) {
            this.allowedLuggage = allowedLuggage;
            return this;
        }

        public BusDtoBuilder cabinClass(String cabinClass) {
            this.cabinClass = cabinClass;
            return this;
        }

        public BusDtoBuilder planeNumber(Long planeNumber) {
            this.planeNumber = planeNumber;
            return this;
        }

        public BusDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public BusDtoBuilder type(VehicleType type) {
            this.type = type;
            return this;
        }

        public BusDtoBuilder fromStation(String fromStation) {
            this.fromStation = fromStation;
            return this;
        }

        public BusDtoBuilder toStation(String toStation) {
            this.toStation = toStation;
            return this;
        }

        public BusDtoBuilder ticketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
            return this;
        }

        public BusDtoBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public BusDtoBuilder departure(ZonedDateTime departure) {
            this.departure = departure;
            return this;
        }

        public BusDtoBuilder arrival(ZonedDateTime arrival) {
            this.arrival = arrival;
            return this;
        }

        public BusDtoBuilder vehicleProvider(VehicleProviderDto vehicleProvider) {
            this.vehicleProvider = vehicleProvider;
            return this;
        }

        public BusDto build() {
            return new BusDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider, allowedLuggage, cabinClass, planeNumber);
        }
    }
}
