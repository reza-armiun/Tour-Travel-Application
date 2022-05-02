package razarm.tosan.repository.domain.payment;

import razarm.tosan.repository.domain.BaseEntity;

import java.math.BigInteger;
import java.time.Instant;

public class Payment extends BaseEntity {
    private final BigInteger amount;
    private final Instant date;
    private final String details;
    private final PaymentType type;

    public Payment(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, BigInteger amount, Instant date, String details, PaymentType type) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.amount = amount;
        this.date = date;
        this.details = details;
        this.type = type;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public Instant getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }

    public PaymentType getType() {
        return type;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new Payment(id, createdAt, modifiedAt, createdBy, modifiedBy, amount, date, details, type);
    }


    public static final class PaymentBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private BigInteger amount;
        private Instant date;
        private String details;
        private PaymentType type;

        private PaymentBuilder() {
        }

        public static PaymentBuilder aPayment() {
            return new PaymentBuilder();
        }

        public PaymentBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PaymentBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PaymentBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public PaymentBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public PaymentBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public PaymentBuilder amount(BigInteger amount) {
            this.amount = amount;
            return this;
        }

        public PaymentBuilder date(Instant date) {
            this.date = date;
            return this;
        }

        public PaymentBuilder details(String details) {
            this.details = details;
            return this;
        }

        public PaymentBuilder type(PaymentType type) {
            this.type = type;
            return this;
        }

        public Payment build() {
            return new Payment(id, createdAt, modifiedAt, createdBy, modifiedBy, amount, date, details, type);
        }
    }
}
