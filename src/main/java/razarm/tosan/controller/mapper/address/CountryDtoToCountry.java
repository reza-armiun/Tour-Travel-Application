package razarm.tosan.controller.mapper.address;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.address.CountryDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.location.Country;
@Component
public class CountryDtoToCountry implements Mapper<CountryDto, Country> {


    @Override
    public Country convert(CountryDto countryDto) {
        return Country.CountryBuilder.aCountry()
                .id(countryDto.getId())
                .name(countryDto.getName())
                .countryCode(countryDto.getCountryCode())
                .createdAt(countryDto.getCreatedAt().toInstant())
                .modifiedAt(countryDto.getModifiedAt().toInstant())
                .createdBy(countryDto.getCreatedBy())
                .modifiedBy(countryDto.getModifiedBy())
                .build();
    }
}
