package razarm.tosan.repository.mapper.transport;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.transport.VehicleData;
import razarm.tosan.repository.domain.transport.Vehicle;

public class VehicleToVehicleData implements Mapper<Vehicle, VehicleData> {
    @Override
    public VehicleData convert(Vehicle vehicle) {
        return null;
    }
}
