package razarm.tosan.repository.domain.transport;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.Orderable;
import razarm.tosan.repository.domain.tour.SchedulePlan;

import java.math.BigInteger;
import java.time.Instant;

public class VehicleOrder extends BaseEntity implements Orderable {
    private final String name;
    private final Integer discount;
    private final Vehicle vehicle;
    private final SchedulePlan schedulePlan;

    public VehicleOrder(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, Integer discount, Vehicle vehicle, SchedulePlan schedulePlan) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.discount = discount;
        this.vehicle = vehicle;
        this.schedulePlan = schedulePlan;
    }

    public String getName() {
        return name;
    }



    public Vehicle getVehicle() {
        return vehicle;
    }

    public SchedulePlan getSchedulePlan() {
        return schedulePlan;
    }

    @Override
    public BigInteger calculatePrice() {
        return vehicle.getPrice() != null ? vehicle.getPrice() : new BigInteger("0");
    }

    @Override
    public Integer countItems() {
        return null;
    }

    @Override
    public Integer discountRate() {
        return discount;
    }

    @Override
    public BigInteger calculateTaxPrice(int tax) {
        return null;
    }

    @Override
    public Long estimateTime() {
        return null;
    }

    @Override
    public VehicleOrder cloneWithId(String id) {
        return new VehicleOrder(id, createdAt, modifiedAt, createdBy, modifiedBy, name, discount, vehicle, schedulePlan);
    }

    public Integer getDiscount() {
        return discount;
    }

    public static final class VehicleOrderBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private Integer discount;
        private Vehicle vehicle;
        private SchedulePlan schedulePlan;

        private VehicleOrderBuilder() {
        }

        public static VehicleOrderBuilder aVehicleOrder() {
            return new VehicleOrderBuilder();
        }

        public VehicleOrderBuilder id(String id) {
            this.id = id;
            return this;
        }

        public VehicleOrderBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public VehicleOrderBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public VehicleOrderBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public VehicleOrderBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public VehicleOrderBuilder name(String name) {
            this.name = name;
            return this;
        }

        public VehicleOrderBuilder discount(Integer discount) {
            this.discount = discount;
            return this;
        }

        public VehicleOrderBuilder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public VehicleOrderBuilder schedulePlan(SchedulePlan schedulePlan) {
            this.schedulePlan = schedulePlan;
            return this;
        }

        public VehicleOrder build() {
            return new VehicleOrder(id, createdAt, modifiedAt, createdBy, modifiedBy, name, discount, vehicle, schedulePlan);
        }
    }

    @Override
    public String toString() {
        return "VehicleOrder{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", createdBy='" + createdBy + '\'' +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", name='" + name + '\'' +
                ", discount=" + discount +
                ",\n\t vehicle=" + vehicle +
                '}';
    }
}
