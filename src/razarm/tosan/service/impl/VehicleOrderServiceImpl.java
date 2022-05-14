package razarm.tosan.service.impl;

import razarm.tosan.controller.dto.transport.VehicleOrderDto;
import razarm.tosan.controller.mapper.transport.VehicleOrderDtoToVehicleOrder;
import razarm.tosan.controller.mapper.transport.VehicleOrderToVehicleOrderDto;
import razarm.tosan.repository.VehicleOrderRepository;
import razarm.tosan.service.VehicleOrderService;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleOrderServiceImpl implements VehicleOrderService {
    private final VehicleOrderRepository vehicleOrderRepository;
    private final VehicleOrderDtoToVehicleOrder vehicleOrderDtoToVehicleOrder;
    private final VehicleOrderToVehicleOrderDto vehicleOrderToVehicleOrderDto;

    public VehicleOrderServiceImpl(VehicleOrderRepository vehicleOrderRepository, VehicleOrderDtoToVehicleOrder vehicleOrderDtoToVehicleOrder, VehicleOrderToVehicleOrderDto vehicleOrderToVehicleOrderDto) {
        this.vehicleOrderRepository = vehicleOrderRepository;
        this.vehicleOrderDtoToVehicleOrder = vehicleOrderDtoToVehicleOrder;
        this.vehicleOrderToVehicleOrderDto = vehicleOrderToVehicleOrderDto;
    }


    @Override
    public VehicleOrderDto create(VehicleOrderDto vehicleOrderDto) {
        final var vehicleOrder = vehicleOrderDtoToVehicleOrder.convert(vehicleOrderDto);
        final var savedOrder = vehicleOrderRepository.save(vehicleOrder);

        return this.vehicleOrderToVehicleOrderDto.convert(savedOrder);
    }

    @Override
    public void update(VehicleOrderDto vehicleOrderDto) {
        final var vehicleOrder = vehicleOrderDtoToVehicleOrder.convert(vehicleOrderDto);
        vehicleOrderRepository.update(vehicleOrder);
    }

    @Override
    public VehicleOrderDto findById(String s) {
        return vehicleOrderToVehicleOrderDto.convert(vehicleOrderRepository.findById(s));
    }

    @Override
    public void deleteById(String s) {
        vehicleOrderRepository.deleteById(s);
    }

    @Override
    public List<VehicleOrderDto> findAll() {
        return vehicleOrderRepository.findAll().stream()
            .map(vehicleOrderToVehicleOrderDto::convert)
            .collect(Collectors.toUnmodifiableList());
    }
}
