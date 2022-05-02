package razarm.tosan.repository.data.transport;

import razarm.tosan.repository.data.BaseEntityData;

import java.time.Instant;


public class VehicleOrderData extends BaseEntityData {
    private final String name;
    private final Integer discount;
    private final VehicleData vehicle;

    public VehicleOrderData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, Integer discount, VehicleData vehicle) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.discount = discount;
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public Integer getDiscount() {
        return discount;
    }

    public VehicleData getVehicle() {
        return vehicle;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new VehicleOrderData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, discount, vehicle);
    }


    public static final class VehicleOrderDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private Integer discount;
        private VehicleData vehicle;

        private VehicleOrderDataBuilder() {
        }

        public static VehicleOrderDataBuilder aVehicleOrderData() {
            return new VehicleOrderDataBuilder();
        }

        public VehicleOrderDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public VehicleOrderDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public VehicleOrderDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public VehicleOrderDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public VehicleOrderDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public VehicleOrderDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public VehicleOrderDataBuilder discount(Integer discount) {
            this.discount = discount;
            return this;
        }

        public VehicleOrderDataBuilder vehicle(VehicleData vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public VehicleOrderData build() {
            return new VehicleOrderData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, discount, vehicle);
        }
    }
}
