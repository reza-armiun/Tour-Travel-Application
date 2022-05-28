package razarm.tosan.repository.mapper.transport;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.transport.VehicleProviderData;
import razarm.tosan.repository.domain.transport.VehicleProvider;

@Component
public class VehicleProviderDataToVehicleProvider implements Mapper<VehicleProviderData, VehicleProvider> {
    @Override
    public VehicleProvider convert(VehicleProviderData vehicleProviderData) {
        return VehicleProvider.VehicleProviderBuilder.aVehicleProvider()
                                                     .id(vehicleProviderData.getId())
                                                     .name(vehicleProviderData.getName())
                                                     .phone(vehicleProviderData.getPhone())
                                                     .email(vehicleProviderData.getEmail())
                                                     .description(vehicleProviderData.getDescription())
                                                     .createdAt(vehicleProviderData.getCreatedAt())
                                                     .modifiedAt(vehicleProviderData.getModifiedAt())
                                                     .createdBy(vehicleProviderData.getCreatedBy())
                                                     .modifiedBy(vehicleProviderData.getModifiedBy())
                                                     .build();
    }
}
