package razarm.tosan.repository.inMemoryImpl.location;

import razarm.tosan.repository.AddressRepository;
import razarm.tosan.repository.data.location.AddressData;
import razarm.tosan.repository.domain.location.Address;
import razarm.tosan.repository.mapper.location.AddressDataToAddress;
import razarm.tosan.repository.mapper.location.AddressToAddressData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AddressRepositoryImpl implements AddressRepository {
    private Map<String , AddressData> addressDataMap = new HashMap<>();

    private final AddressToAddressData addressToAddressData;
    private final AddressDataToAddress addressDataToAddress;

    public AddressRepositoryImpl(AddressToAddressData addressToAddressData, AddressDataToAddress addressDataToAddress) {
        this.addressToAddressData = addressToAddressData;
        this.addressDataToAddress = addressDataToAddress;
    }


    @Override
    public Address save(Address address) {
        final var addressData = addressToAddressData.convert(address);
        addressDataMap.put(addressData.getId() , addressData);
        return address.cloneWithId(addressData.getId());
    }

    @Override
    public void update(Address address) {
        final var addressData = addressToAddressData.convert(address);
        addressDataMap.put(addressData.getId() , addressData);
    }

    @Override
    public void deleteById(String s) {
        addressDataMap.remove(s);
    }

    @Override
    public Address findById(String s) {
        final var address = addressDataMap.get(s);
        return addressDataToAddress.convert(address);
    }

    @Override
    public List<Address> findAll() {
        return addressDataMap.values().stream()
            .map(addressDataToAddress::convert)
            .collect(Collectors.toUnmodifiableList());
    }
}
