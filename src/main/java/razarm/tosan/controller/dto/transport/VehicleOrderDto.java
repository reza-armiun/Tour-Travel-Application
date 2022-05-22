package razarm.tosan.controller.dto.transport;

import com.fasterxml.jackson.annotation.JsonInclude;
import razarm.tosan.controller.dto.BaseEntityDto;

import java.time.ZonedDateTime;
import java.util.StringJoiner;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleOrderDto extends BaseEntityDto {
    private  String name;
    private  Integer discount;
    private  VehicleDto vehicle;

    public VehicleOrderDto() {}

    public VehicleOrderDto(String id, ZonedDateTime createdAt, ZonedDateTime modifiedAt, String createdBy, String modifiedBy, String name, Integer discount, VehicleDto vehicle) {
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

    public VehicleDto getVehicle() {
        return vehicle;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    public static final class VehicleOrderDtoBuilder {
        protected String id;
        protected ZonedDateTime createdAt;
        protected ZonedDateTime modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private Integer discount;
        private VehicleDto vehicle;

        private VehicleOrderDtoBuilder() {
        }

        public static VehicleOrderDtoBuilder aVehicleOrderDto() {
            return new VehicleOrderDtoBuilder();
        }

        public VehicleOrderDtoBuilder id(String id) {
            this.id = id;
            return this;
        }

        public VehicleOrderDtoBuilder createdAt(ZonedDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public VehicleOrderDtoBuilder modifiedAt(ZonedDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public VehicleOrderDtoBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public VehicleOrderDtoBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public VehicleOrderDtoBuilder name(String name) {
            this.name = name;
            return this;
        }

        public VehicleOrderDtoBuilder discount(Integer discount) {
            this.discount = discount;
            return this;
        }

        public VehicleOrderDtoBuilder vehicle(VehicleDto vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public VehicleOrderDto build() {
            return new VehicleOrderDto(id, createdAt, modifiedAt, createdBy, modifiedBy, name, discount, vehicle);
        }
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", VehicleOrderDto.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdAt=" + createdAt)
                .add("modifiedAt=" + modifiedAt)
                .add("createdBy='" + createdBy + "'")
                .add("modifiedBy='" + modifiedBy + "'")
                .add("name='" + name + "'")
                .add("discount=" + discount)
                .add("vehicle=" + vehicle)
                .toString();
    }
}
