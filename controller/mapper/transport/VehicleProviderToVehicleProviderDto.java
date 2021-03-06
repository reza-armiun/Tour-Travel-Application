package razarm.tosan.controller.mapper.transport;

import razarm.tosan.controller.dto.transport.VehicleProviderDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.controller.mapper.address.AddressToAddressDto;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.transport.VehicleProvider;

import java.time.ZoneId;

public class VehicleProviderToVehicleProviderDto implements Mapper<VehicleProvider, VehicleProviderDto> {
    private final AddressToAddressDto addressToAddressDto;
    private final VehicleToVehicleDto vehicleToVehicleDto;

    public VehicleProviderToVehicleProviderDto(AddressToAddressDto addressToAddressDto, VehicleToVehicleDto vehicleToVehicleDto) {
        this.addressToAddressDto = addressToAddressDto;
        this.vehicleToVehicleDto = vehicleToVehicleDto;
    }

    @Override
    public VehicleProviderDto convert(VehicleProvider vehicleProvider) {
        return VehicleProviderDto.VehicleProviderDtoBuilder.aVehicleProviderDto()
                                                           .id(vehicleProvider.getId())
                                                           .name(vehicleProvider.getName())
                                                           .phone(vehicleProvider.getPhone())
                                                           .email(vehicleProvider.getEmail())
                                                           .description(vehicleProvider.getDescription())
                                                           .address(vehicleProvider.getAddress() != null ? addressToAddressDto.convert(vehicleProvider.getAddress()) : null)
                                                           .createdAt(vehicleProvider.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                                                           .modifiedAt(vehicleProvider.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                                                           .createdBy(vehicleProvider.getCreatedBy())
                                                           .modifiedBy(vehicleProvider.getModifiedBy())
//                                                           .vehicles(vehicleProvider.getVehicles().stream().map(vehicleToVehicleDto::convert).collect(Collectors.toUnmodifiableSet()))
                                                           .build();
    }
}
