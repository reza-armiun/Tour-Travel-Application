package razarm.tosan.controller.mapper.address;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.address.CityDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.location.City;

import java.time.ZoneId;
@Component
public class CityToCityDto implements Mapper<City, CityDto> {
    private final CountryToCountryDto countryToCountryDto;

    public CityToCityDto(CountryToCountryDto countryToCountryDto) {
        this.countryToCountryDto = countryToCountryDto;
    }

    @Override
    public CityDto convert(City city) {
        return CityDto.CityDtoBuilder.aCityDto()
            .id(city.getId())
            .name(city.getName())
            .zipCode(city.getZipCode())
            .country(countryToCountryDto.convert(city.getCountry()))
            .createdAt(city.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .modifiedAt(city.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .createdBy(city.getCreatedBy())
            .modifiedBy(city.getModifiedBy())
            .build();
    }


}
