package razarm.tosan.controller.mapper.address;

import razarm.tosan.controller.dto.address.CityDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.location.City;

public class CityDtoToCity implements Mapper<CityDto, City> {
    @Override
    public City convert(CityDto cityDto) {
        return City.CityBuilder.aCity()
                               .id(cityDto.getId())
                               .name(cityDto.getName())
                               .zipCode(cityDto.getZipCode())
                               .build();
    }
}
