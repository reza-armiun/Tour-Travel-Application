package razarm.tosan.service;


import razarm.tosan.controller.dto.transport.VehicleDto;
import razarm.tosan.controller.dto.transport.VehicleProviderDto;
import razarm.tosan.repository.domain.transport.VehicleType;

import java.util.List;

public interface VehicleOrderService extends CrudService<VehicleProviderDto, String>  {

    VehicleDto addVehicle(String providerId, VehicleDto vehicleDto);
    void updateVehicle(String providerId, VehicleDto vehicleDto);
    void removeVehicle(String providerId, String vehicleId);
    VehicleDto findVehicleById(String providerId, String vehicleId);
    VehicleDto findVehicleByName(String providerId, String vehicleName);

    List<VehicleDto> findVehiclesByType(VehicleType type);
    List<VehicleDto> findAllVehicles();

}
