package razarm.tosan.repository.data.accommodation;

import razarm.tosan.repository.data.BaseEntityData;

import java.io.Serializable;
import java.time.Instant;

public class AccommodationOrderData extends BaseEntityData  implements Serializable {
    private final Instant date;
    private final Integer discount;
    private final AccommodationData accommodation;

    public AccommodationOrderData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, Instant date, Integer discount, AccommodationData accommodation) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.date = date;
        this.discount = discount;
        this.accommodation = accommodation;
    }

    public Instant getDate() {
        return date;
    }

    public Integer getDiscount() {
        return discount;
    }

    public AccommodationData getAccommodation() {
        return accommodation;
    }

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new AccommodationOrderData(id, createdAt, modifiedAt, createdBy, modifiedBy, date, discount, accommodation);
    }

    public static final class AccommodationOrderDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private Instant date;
        private Integer discount;
        private AccommodationData accommodation;

        private AccommodationOrderDataBuilder() {
        }

        public static AccommodationOrderDataBuilder anAccommodationOrderData() {
            return new AccommodationOrderDataBuilder();
        }

        public AccommodationOrderDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AccommodationOrderDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccommodationOrderDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public AccommodationOrderDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AccommodationOrderDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AccommodationOrderDataBuilder date(Instant date) {
            this.date = date;
            return this;
        }

        public AccommodationOrderDataBuilder discount(Integer discount) {
            this.discount = discount;
            return this;
        }

        public AccommodationOrderDataBuilder accommodation(AccommodationData accommodation) {
            this.accommodation = accommodation;
            return this;
        }

        public AccommodationOrderData build() {
            return new AccommodationOrderData(id, createdAt, modifiedAt, createdBy, modifiedBy, date, discount, accommodation);
        }
    }
}
