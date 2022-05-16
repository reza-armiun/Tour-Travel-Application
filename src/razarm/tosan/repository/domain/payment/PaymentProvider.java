package razarm.tosan.repository.domain.payment;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.location.Address;
import razarm.tosan.utility.AppCollections;

import java.time.Instant;
import java.util.Set;

public class PaymentProvider extends BaseEntity {
    private final String name;
    private final Address address;
    private final String description;
    private final String phone;
    private final String email;
    private final Set<Payment> payments;

    public PaymentProvider(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, Address address, String description, String phone, String email, Set<Payment> payments) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.address = address;
        this.description = description;
        this.phone = phone;
        this.email = email;
        this.payments = AppCollections.unmodifiableSet(payments);
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new PaymentProvider(id, createdAt, modifiedAt, createdBy, modifiedBy, name, address, description, phone, email, payments);
    }


    public static final class PaymentProviderBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private Address address;
        private String description;
        private String phone;
        private String email;
        private Set<Payment> payments;

        private PaymentProviderBuilder() {
        }

        public static PaymentProviderBuilder aPaymentProvider() {
            return new PaymentProviderBuilder();
        }

        public PaymentProviderBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PaymentProviderBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PaymentProviderBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public PaymentProviderBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public PaymentProviderBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public PaymentProviderBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PaymentProviderBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public PaymentProviderBuilder description(String description) {
            this.description = description;
            return this;
        }

        public PaymentProviderBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public PaymentProviderBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PaymentProviderBuilder payments(Set<Payment> payments) {
            this.payments = payments;
            return this;
        }

        public PaymentProvider build() {
            return new PaymentProvider(id, createdAt, modifiedAt, createdBy, modifiedBy, name, address, description, phone, email, payments);
        }
    }
}
