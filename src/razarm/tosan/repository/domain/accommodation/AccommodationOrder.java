package razarm.tosan.repository.domain.accommodation;


import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.Orderable;

import java.math.BigInteger;
import java.time.Instant;
import java.util.StringJoiner;

public class AccommodationOrder extends BaseEntity implements Orderable {
    private final Instant date;
    private final Integer discount;
    private final  Accommodation accommodation;


    public AccommodationOrder(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, Instant date, Integer discount, Accommodation accommodation) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.date = date;
        this.discount = discount;
        this.accommodation = accommodation;
    }

    public Instant getDate() {
        return date;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    @Override
    public BigInteger calculatePrice() {
        return accommodation.getPrice() != null ? accommodation.getPrice() : new BigInteger("0");
    }

    @Override
    public Integer discountRate() {
        return discount;
    }

    @Override
    public Integer countItems() {
        return null;
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
    public AccommodationOrder cloneWithId(String id) {
        return new AccommodationOrder(id, createdAt, modifiedAt, createdBy, modifiedBy, date, discount, accommodation);
    }

    public Integer getDiscount() {
        return discount;
    }

    public static final class AccommodationOrderBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private Instant date;
        private Integer discount;
        private Accommodation accommodation;

        private AccommodationOrderBuilder() {
        }

        public static AccommodationOrderBuilder anAccommodationOrder() {
            return new AccommodationOrderBuilder();
        }

        public AccommodationOrderBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AccommodationOrderBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccommodationOrderBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public AccommodationOrderBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AccommodationOrderBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AccommodationOrderBuilder date(Instant date) {
            this.date = date;
            return this;
        }

        public AccommodationOrderBuilder discount(Integer discount) {
            this.discount = discount;
            return this;
        }

        public AccommodationOrderBuilder accommodation(Accommodation accommodation) {
            this.accommodation = accommodation;
            return this;
        }

        public AccommodationOrder build() {
            return new AccommodationOrder(id, createdAt, modifiedAt, createdBy, modifiedBy, date, discount, accommodation);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AccommodationOrder.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("createdAt=" + createdAt)
                .add("modifiedAt=" + modifiedAt)
                .add("createdBy='" + createdBy + "'")
                .add("modifiedBy='" + modifiedBy + "'")
                .add("date=" + date)
                .add("discount=" + discount)
                .add("accommodation=" + accommodation)
                .toString();
    }
}
