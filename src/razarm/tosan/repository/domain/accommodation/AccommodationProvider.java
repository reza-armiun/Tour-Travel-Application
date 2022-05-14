package razarm.tosan.repository.domain.accommodation;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.location.Address;
import razarm.tosan.utility.AppCollections;

import java.time.Instant;
import java.util.Set;

public class AccommodationProvider extends BaseEntity {
    private final String name;
    private final String description;
    private final String email;
    private final String phone;
    private final Address address;
    private final Set<Accommodation> accommodations;

    public AccommodationProvider(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String description, String email, String phone, Address address, Set<Accommodation> accommodations) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.description = description;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.accommodations = AppCollections.unmodifiableSet(accommodations);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    public Set<Accommodation> getAccommodations() {
        return accommodations;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new AccommodationProvider(id, createdAt, modifiedAt, createdBy, modifiedBy, name, description, email, phone, address, accommodations);
    }


    public static final class AccommodationProviderBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String description;
        private String email;
        private String phone;
        private Address address;
        private Set<Accommodation> accommodations;

        private AccommodationProviderBuilder() {
        }

        public static AccommodationProviderBuilder anAccommodationProvider() {
            return new AccommodationProviderBuilder();
        }

        public AccommodationProviderBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AccommodationProviderBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccommodationProviderBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public AccommodationProviderBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AccommodationProviderBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public AccommodationProviderBuilder name(String name) {
            this.name = name;
            return this;
        }

        public AccommodationProviderBuilder description(String description) {
            this.description = description;
            return this;
        }

        public AccommodationProviderBuilder email(String email) {
            this.email = email;
            return this;
        }

        public AccommodationProviderBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public AccommodationProviderBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public AccommodationProviderBuilder accommodations(Set<Accommodation> accommodations) {
            this.accommodations = accommodations;
            return this;
        }

        public AccommodationProvider build() {
            return new AccommodationProvider(id, createdAt, modifiedAt, createdBy, modifiedBy, name, description, email, phone, address, accommodations);
        }
    }
}
