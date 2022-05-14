package razarm.tosan.repository.mapper.location;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.location.AddressData;
import razarm.tosan.repository.domain.location.Address;

public class AddressToAddressData implements Mapper<Address, AddressData> {
    private final CityToCityData cityToCityData;

    public AddressToAddressData(CityToCityData cityToCityData) {
        this.cityToCityData = cityToCityData;
    }

    @Override
    public AddressData convert(Address address) {
        return AddressData.AddressDataBuilder.anAddressData()
                .id(address.getId())
                .street(address.getStreet())
                .postalCode(address.getPostalCode())
                .city(cityToCityData.convert(address.getCity()))
                .createdAt(address.getCreatedAt())
                .modifiedAt(address.getModifiedAt())
                .createdBy(address.getCreatedBy())
                .modifiedBy(address.getModifiedBy())
                .build();
    }
}
