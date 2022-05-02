package razarm.tosan.repository;

import razarm.tosan.repository.domain.transport.Vehicle;
import razarm.tosan.repository.domain.transport.VehicleProvider;
import razarm.tosan.repository.domain.transport.VehicleType;

import java.util.List;

public interface VehicleProviderRepository extends CrudRepository<VehicleProvider , String>{

    Vehicle addVehicle(String providerId ,Vehicle vehicle);
    void updateVehicle(String providerId, Vehicle vehicle);
    void removeVehicle(String providerId, String vehicleId);
    Vehicle findVehicleById(String providerId, String vehicleId);
    Vehicle findVehicleByName(String providerId, String vehicleName);

    List<Vehicle> findVehiclesByType(VehicleType type);
    List<Vehicle> findAllVehicles();
}
