package razarm.tosan.repository.domain;

import razarm.tosan.repository.domain.auth.User;
import razarm.tosan.repository.domain.tour.TourCategory;
import razarm.tosan.utility.AppCollections;

import java.time.Instant;
import java.util.Set;

public class Interest extends BaseEntity{
    private final String name;
    private final TourCategory tourCategory;

    private final Set<User> users ;


    public Interest(String id, Instant createdAt, Instant modifiedAt, String createdBy, String modifiedBy, String name, TourCategory tourCategory, Set<User> users) {
        super(id, createdAt, modifiedAt, createdBy, modifiedBy);
        this.name = name;
        this.tourCategory = tourCategory;
        this.users = AppCollections.unmodifiableSet(users);
    }

    public String getName() {
        return name;
    }

    public TourCategory getTourCategory() {
        return tourCategory;
    }

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public BaseEntity cloneWithId(String id) {
        return new Interest(id, createdAt, modifiedAt, createdBy, modifiedBy, name, tourCategory, users);
    }


    public static final class InterestBuilder {
        protected String id;
        protected Instant createdAt;
        protected Instant modifiedAt;
        protected String createdBy;
        protected String modifiedBy;
        private String name;
        private TourCategory tourCategory;
        private Set<User> users ;

        private InterestBuilder() {
        }

        public static InterestBuilder anInterest() {
            return new InterestBuilder();
        }

        public InterestBuilder id(String id) {
            this.id = id;
            return this;
        }

        public InterestBuilder createdAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public InterestBuilder modifiedAt(Instant modifiedAt) {
            this.modifiedAt = modifiedAt;
            return this;
        }

        public InterestBuilder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public InterestBuilder modifiedBy(String modifiedBy) {
            this.modifiedBy = modifiedBy;
            return this;
        }

        public InterestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public InterestBuilder tourCategory(TourCategory tourCategory) {
            this.tourCategory = tourCategory;
            return this;
        }

        public InterestBuilder users(Set<User> users) {
            this.users = users;
            return this;
        }

        public Interest build() {
            return new Interest(id, createdAt, modifiedAt, createdBy, modifiedBy, name, tourCategory, users);
        }
    }
}
