package razarm.tosan.repository.domain.transport;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum VehicleType {
    @JsonProperty("BUS")
    BUS,
    @JsonProperty("CAR")
    CAR,
    @JsonProperty("PLANE")
    PLANE,
    @JsonProperty("TRAIN")
    TRAIN
}
