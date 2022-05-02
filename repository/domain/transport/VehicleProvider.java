package razarm.tosan.repository.domain.transport;

import razarm.tosan.repository.domain.BaseEntity;
import razarm.tosan.repository.domain.location.Address;
import razarm.tosan.utility.AppCollections;

import java.time.Instant;
import java.util.Set;

public class VehicleProvider extends BaseEntity {
    private final String name;
    private final String phone;
    private final String email;
    private final String description;
    private final Address address;

    private final Set<Vehicle> vehicles;

    public VehicleProvider(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String phone, String email, String description, Address address, Set<Vehicle> vehicles) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.address = address;
        this.vehicles = AppCollections.unmodifiableSet(vehicles);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Address getAddress() {
        return address;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    @Override
    public VehicleProvider cloneWithId(String id) {
        return new VehicleProvider(id, createdAt, modifiedAt, createdBy, modifiedBy, name, phone, email, description, address, vehicles);
    }


    public static final class VehicleProviderBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String phone;
        private String email;
        private String description;
        private Address address;
        private Set<Vehicle> vehicles;

        private VehicleProviderBuilder() {
        }

        public static VehicleProviderBuilder aVehicleProvider() {
            return new VehicleProviderBuilder();
        }

        public VehicleProviderBuilder id(String id) {
            this.id = id;
            return this;
        }

        public VehicleProviderBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public VehicleProviderBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public VehicleProviderBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public VehicleProviderBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public VehicleProviderBuilder name(String name) {
            this.name = name;
            return this;
        }

        public VehicleProviderBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public VehicleProviderBuilder email(String email) {
            this.email = email;
            return this;
        }

        public VehicleProviderBuilder description(String description) {
            this.description = description;
            return this;
        }

        public VehicleProviderBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public VehicleProviderBuilder vehicles(Set<Vehicle> vehicles) {
            this.vehicles = vehicles;
            return this;
        }

        public VehicleProvider build() {
            return new VehicleProvider(id, createdAt, modifiedAt, createdBy, modifiedBy, name, phone, email, description, address, vehicles);
        }
    }
}
