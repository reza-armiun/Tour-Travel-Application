package razarm.tosan.repository.domain.food;

import razarm.tosan.repository.domain.BaseEntity;

import java.time.Instant;
import java.util.Set;

public class FoodProvider extends BaseEntity {
    private final String name;
    private final String address;
    private final String phone;
    private final String email;
    private final String description;

    private final Set<Food> foods;

    public FoodProvider(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, String address, String phone, String email, String description, Set<Food> foods) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.foods = foods;
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

    public Set<Food> getFoods() {
        return foods;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new FoodProvider(id, createdAt, modifiedAt, createdBy, modifiedBy, name, address, phone, email, description, foods);
    }


    public static final class FoodProviderBuilder {
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
        private Set<Food> foods;

        private FoodProviderBuilder() {
        }

        public static FoodProviderBuilder aFoodProvider() {
            return new FoodProviderBuilder();
        }

        public FoodProviderBuilder id(String id) {
            this.id = id;
            return this;
        }

        public FoodProviderBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public FoodProviderBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public FoodProviderBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public FoodProviderBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public FoodProviderBuilder name(String name) {
            this.name = name;
            return this;
        }

        public FoodProviderBuilder address(String address) {
            this.address = address;
            return this;
        }

        public FoodProviderBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public FoodProviderBuilder email(String email) {
            this.email = email;
            return this;
        }

        public FoodProviderBuilder description(String description) {
            this.description = description;
            return this;
        }

        public FoodProviderBuilder foods(Set<Food> foods) {
            this.foods = foods;
            return this;
        }

        public FoodProvider build() {
            return new FoodProvider(id, createdAt, modifiedAt, createdBy, modifiedBy, name, address, phone, email, description, foods);
        }
    }
}
