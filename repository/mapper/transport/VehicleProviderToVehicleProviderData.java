package razarm.tosan.repository.mapper.transport;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.transport.VehicleProviderData;
import razarm.tosan.repository.domain.transport.VehicleProvider;

public class VehicleProviderToVehicleProviderData implements Mapper<VehicleProvider, VehicleProviderData> {
    @Override
    public VehicleProviderData convert(VehicleProvider vehicleProvider) {
        return VehicleProviderData.VehicleProviderDataBuilder.aVehicleProviderData()
                                                             .id(vehicleProvider.getId())
                                                             .name(vehicleProvider.getName())
                                                             .phone(vehicleProvider.getPhone())
                                                             .email(vehicleProvider.getEmail())
                                                             .description(vehicleProvider.getDescription())
                                                             .addressId(vehicleProvider.getAddress() != null ?vehicleProvider.getAddress().getId() : null)
                                                             .createdAt(vehicleProvider.getCreatedAt())
                                                             .modifiedAt(vehicleProvider.getModifiedAt())
                                                             .createdBy(vehicleProvider.getCreatedBy())
                                                             .modifiedBy(vehicleProvider.getModifiedBy())
                                                             .build();
    }
}
