package razarm.tosan.controller.mapper.address;

import razarm.tosan.controller.dto.address.AddressDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.location.Address;

public class AddressDtoToAddress implements Mapper<AddressDto , Address> {
    private final CityDtoToCity cityDtoToCity;

    public AddressDtoToAddress(CityDtoToCity cityDtoToCity) {
        this.cityDtoToCity = cityDtoToCity;
    }

    @Override
    public  Address convert(AddressDto addressDto) {
        return Address.AddressBuilder.anAddress()
                .id(addressDto.getId())
                .street(addressDto.getStreet())
                .postalCode(addressDto.getPostalCode())
                .city(this.cityDtoToCity.convert(addressDto.getCity()))
                .build();
    }
}
