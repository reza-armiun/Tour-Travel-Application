package razarm.tosan.repository.data.food;


import razarm.tosan.repository.data.BaseEntityData;

import java.time.Instant;

public class FoodProviderData extends BaseEntityData {
    private final String name;
    private final String address;
    private final String phone;
    private final String email;
    private final String description;


    public FoodProviderData(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String address, String phone, String email, String description) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
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

    @Override
    public BaseEntityData cloneWithId(String id) {
        return new FoodProviderData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, address, phone, email, description);
    }


    public static final class FoodProviderDataBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private String address;
        private String phone;
        private String email;
        private String description;

        private FoodProviderDataBuilder() {
        }

        public static FoodProviderDataBuilder aFoodProviderData() {
            return new FoodProviderDataBuilder();
        }

        public FoodProviderDataBuilder id(String id) {
            this.id = id;
            return this;
        }

        public FoodProviderDataBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public FoodProviderDataBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public FoodProviderDataBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public FoodProviderDataBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public FoodProviderDataBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FoodProviderDataBuilder address(String address) {
            this.address = address;
            return this;
        }

        public FoodProviderDataBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public FoodProviderDataBuilder email(String email) {
            this.email = email;
            return this;
        }

        public FoodProviderDataBuilder description(String description) {
            this.description = description;
            return this;
        }

        public FoodProviderData build() {
            return new FoodProviderData(id, createdAt, modifiedAt, createdBy, modifiedBy, name, address, phone, email, description);
        }
    }
}
