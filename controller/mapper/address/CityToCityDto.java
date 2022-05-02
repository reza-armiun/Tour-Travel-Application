package razarm.tosan.controller.mapper.address;

import razarm.tosan.controller.dto.address.CityDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.location.City;

import java.time.ZoneId;

public class CityToCityDto implements Mapper<City, CityDto> {
    @Override
    public CityDto convert(City city) {
        return CityDto.CityDtoBuilder.aCityDto()
                                     .id(city.getId())
                                     .name(city.getName())
                                     .zipCode(city.getZipCode())
                                     .createdAt(city.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                                     .modifiedAt(city.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                                     .createdBy(city.getCreatedBy())
                                     .modifiedBy(city.getModifiedBy())
                                     .build();
    }


}
