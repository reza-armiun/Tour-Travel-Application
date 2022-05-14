package razarm.tosan.repository.mapper.location;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.location.AddressData;
import razarm.tosan.repository.domain.location.Address;

public class AddressDataToAddress implements Mapper<AddressData, Address> {
    private final CityDataToCity cityDataToCity;

    public AddressDataToAddress(CityDataToCity cityDataToCity) {
        this.cityDataToCity = cityDataToCity;
    }

    @Override
    public Address convert(AddressData addressData) {
        return Address.AddressBuilder.anAddress()
                .id(addressData.getId())
                .street(addressData.getStreet())
                .postalCode(addressData.getPostalCode())
                .city(cityDataToCity.convert(addressData.getCity()))
                .createdAt(addressData.getCreatedAt())
                .modifiedAt(addressData.getModifiedAt())
                .createdBy(addressData.getCreatedBy())
                .modifiedBy(addressData.getModifiedBy())
                .build();
    }
}
