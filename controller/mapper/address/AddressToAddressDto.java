package razarm.tosan.controller.mapper.address;

import razarm.tosan.controller.dto.address.AddressDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.location.Address;

public class AddressToAddressDto implements Mapper<Address, AddressDto> {
    private final CountryToCountryDto countryToCountryDto;
    private final CityToCityDto cityToCityDto;


    public AddressToAddressDto(CountryToCountryDto countryToCountryDto, CityToCityDto cityToCityDto) {
        this.countryToCountryDto = countryToCountryDto;
        this.cityToCityDto = cityToCityDto;
    }

    @Override
    public AddressDto convert(final Address address) {
        return AddressDto.AddressDtoBuilder.anAddressDto()
                .id(address.getId())
                .street(address.getStreet())
                .postalCode(address.getPostalCode())
                .city(address.getCity() != null ? this.cityToCityDto.convert(address.getCity()) : null)
                .build();
    }
}
