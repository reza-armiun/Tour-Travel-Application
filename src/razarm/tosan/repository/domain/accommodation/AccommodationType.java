package razarm.tosan.repository.domain.accommodation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
public enum AccommodationType implements Serializable {
    @JsonProperty("HOTEL")
    HOTEL("HOTEL"),
    @JsonProperty("APARTMENT")
    APARTMENT("APARTMENT"),
    @JsonProperty("HOSTEL")
    HOSTEL("HOSTEL"),
    @JsonProperty("MOTEL")
    MOTEL("MOTEL"),
    @JsonProperty("CAMP")
    CAMP("CAMP");

    private String value;

    AccommodationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
