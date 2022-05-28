package razarm.tosan.service.impl;

import org.springframework.stereotype.Service;
import razarm.tosan.controller.dto.address.AddressDto;
import razarm.tosan.controller.mapper.address.AddressDtoToAddress;
import razarm.tosan.controller.mapper.address.AddressToAddressDto;
import razarm.tosan.repository.AddressRepository;
import razarm.tosan.service.AddressService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressDtoToAddress addressDtoToAddress;
    private final AddressToAddressDto addressToAddressDto;

    public AddressServiceImpl(AddressRepository addressRepository, AddressDtoToAddress addressDtoToAddress, AddressToAddressDto addressToAddressDto) {
        this.addressRepository = addressRepository;
        this.addressDtoToAddress = addressDtoToAddress;
        this.addressToAddressDto = addressToAddressDto;
    }


    @Override
    public AddressDto create(AddressDto addressDto) {
        var address = this.addressDtoToAddress.convert(addressDto);
        return this.addressToAddressDto.convert(this.addressRepository.save(address));
    }

    @Override
    public void update( AddressDto addressDto) {
        if(addressDto.getId() == null) throw new NullPointerException("null address id");
        var address = this.addressDtoToAddress.convert(addressDto);
        this.addressRepository.update(address);
    }

    @Override
    public AddressDto findById(String id) {
        if(id == null) throw new NullPointerException("null address id");
        return this.addressToAddressDto.convert(this.addressRepository.findById(id));
    }

    @Override
    public void deleteById(String id) {
        if(id == null) throw new NullPointerException("null address id");
        this.addressRepository.deleteById(id);
    }

    @Override
    public List<AddressDto> findAll() {
        return this.addressRepository.findAll().stream()
                .map(addressToAddressDto::convert)
                .collect(Collectors.toUnmodifiableList());
    }
}
