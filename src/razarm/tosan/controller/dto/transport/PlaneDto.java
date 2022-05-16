package razarm.tosan.controller.dto.transport;


import razarm.tosan.repository.domain.transport.VehicleType;

import java.math.BigInteger;
import java.time.ZonedDateTime;

public class PlaneDto extends VehicleDto{
    private  Integer allowedLuggage;
    private  String cabinClass;
    private  Long planeNumber;
    private  VehicleType type = VehicleType.PLANE;

    public PlaneDto() {}
    public PlaneDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, String fromStation, String toStation, String ticketNumber, BigInteger price, ZonedDateTime departure, ZonedDateTime arrival, VehicleProviderDto vehicleProvider, Integer allowedLuggage, String cabinClass, Long planeNumber) {
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

    public void setAllowedLuggage(Integer allowedLuggage) {
        this.allowedLuggage = allowedLuggage;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public void setPlaneNumber(Long planeNumber) {
        this.planeNumber = planeNumber;
    }

    @Override
    public void setType(VehicleType type) {
        this.type = type;
    }

    public static final class PlaneDtoBuilder {
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

        private PlaneDtoBuilder() {
        }

        public static PlaneDtoBuilder aPlaneDto() {
            return new PlaneDtoBuilder();
        }

        public PlaneDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PlaneDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PlaneDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public PlaneDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public PlaneDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public PlaneDtoBuilder allowedLuggage(Integer allowedLuggage) {
            this.allowedLuggage = allowedLuggage;
            return this;
        }

        public PlaneDtoBuilder cabinClass(String cabinClass) {
            this.cabinClass = cabinClass;
            return this;
        }

        public PlaneDtoBuilder planeNumber(Long planeNumber) {
            this.planeNumber = planeNumber;
            return this;
        }

        public PlaneDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlaneDtoBuilder type(VehicleType type) {
            this.type = type;
            return this;
        }

        public PlaneDtoBuilder fromStation(String fromStation) {
            this.fromStation = fromStation;
            return this;
        }

        public PlaneDtoBuilder toStation(String toStation) {
            this.toStation = toStation;
            return this;
        }

        public PlaneDtoBuilder ticketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
            return this;
        }

        public PlaneDtoBuilder price(BigInteger price) {
            this.price = price;
            return this;
        }

        public PlaneDtoBuilder departure(ZonedDateTime departure) {
            this.departure = departure;
            return this;
        }

        public PlaneDtoBuilder arrival(ZonedDateTime arrival) {
            this.arrival = arrival;
            return this;
        }

        public PlaneDtoBuilder vehicleProvider(VehicleProviderDto vehicleProvider) {
            this.vehicleProvider = vehicleProvider;
            return this;
        }

        public PlaneDto build() {
            PlaneDto planeDto = new PlaneDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, fromStation, toStation, ticketNumber, price, departure, arrival, vehicleProvider, allowedLuggage, cabinClass, planeNumber);
            return planeDto;
        }
    }
}
