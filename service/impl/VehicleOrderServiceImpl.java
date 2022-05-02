package razarm.tosan.service.impl;

import razarm.tosan.controller.dto.transport.VehicleDto;
import razarm.tosan.controller.dto.transport.VehicleProviderDto;
import razarm.tosan.repository.domain.transport.VehicleType;
import razarm.tosan.service.VehicleOrderService;

import java.util.List;

public class VehicleOrderServiceImpl implements VehicleOrderService {
    @Override
    public VehicleProviderDto create(VehicleProviderDto vehicleProviderDto) {
        return null;
    }

    @Override
    public void update(VehicleProviderDto vehicleProviderDto) {

    }

    @Override
    public VehicleProviderDto findById(String s) {
        return null;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public List<VehicleProviderDto> findAll() {
        return null;
    }

    @Override
    public VehicleDto addVehicle(String vehicleProvider, VehicleDto vehicleDto) {
        return null;
    }

    @Override
    public void updateVehicle(String vehicleProvider, VehicleDto vehicleDto) {

    }

    @Override
    public void removeVehicle(String vehicleProvider, String vehicleId) {

    }

    @Override
    public VehicleDto findVehicleById(String vehicleProvider, String vehicleId) {
        return null;
    }

    @Override
    public VehicleDto findVehicleByName(String vehicleProvider, String vehicleName) {
        return null;
    }

    @Override
    public List<VehicleDto> findVehiclesByType(VehicleType type) {
        return null;
    }

    @Override
    public List<VehicleDto> findAllVehicles() {
        return null;
    }
}
