package razarm.tosan.controller.mapper.transport;

import razarm.tosan.controller.dto.transport.VehicleProviderDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.AddressDtoToAddress;
import razarm.tosan.repository.domain.transport.VehicleProvider;

public class VehicleProviderDtoToVehicleProvider implements Mapper<VehicleProviderDto, VehicleProvider> {
    private final AddressDtoToAddress addressDtoToAddress;

    public VehicleProviderDtoToVehicleProvider(AddressDtoToAddress addressDtoToAddress) {
        this.addressDtoToAddress = addressDtoToAddress;
    }

    @Override
    public VehicleProvider convert(VehicleProviderDto vehicleProviderDto) {
        return VehicleProvider.VehicleProviderBuilder.aVehicleProvider()
                .id(vehicleProviderDto.getId())
                .name(vehicleProviderDto.getName())
                .email(vehicleProviderDto.getEmail())
                .phone(vehicleProviderDto.getPhone())
                .description(vehicleProviderDto.getDescription())
                .address(vehicleProviderDto.getAddress() != null ? addressDtoToAddress.convert(vehicleProviderDto.getAddress()) : null)
                .createdAt(vehicleProviderDto.getCreatedAt().toInstant())
                .modifiedAt(vehicleProviderDto.getModifiedAt().toInstant())
                .createdBy(vehicleProviderDto.getCreatedBy())
                .modifiedBy(vehicleProviderDto.getModifiedBy())
                .build();
    }
}
