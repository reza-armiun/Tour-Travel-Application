package razarm.tosan.utility;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

public class AppJsonMapper {
    private static final PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                                                                .allowIfSubType("razarm.tosan.controller.dto.accommodation.AccommodationDto")
                                                                .allowIfSubType("razarm.tosan.controller.dto.transport.VehicleDto")
                                                                .allowIfSubType("java.util.ArrayList")
                                                                .build();
    private static final ObjectMapper objectMapper = JsonMapper.builder()
                                                               .addModule(new ParameterNamesModule())
                                                               .addModule(new Jdk8Module())
                                                               .addModule(new JavaTimeModule())
                                                               .build();

    private AppJsonMapper() {
    }


    public static ObjectMapper getAppJsonMapper() {
        return  objectMapper;
    }
}
