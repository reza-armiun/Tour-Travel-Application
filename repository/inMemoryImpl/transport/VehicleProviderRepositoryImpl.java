package razarm.tosan.repository.inMemoryImpl.transport;

import razarm.tosan.repository.VehicleProviderRepository;
import razarm.tosan.repository.data.transport.VehicleProviderData;
import razarm.tosan.repository.domain.transport.Vehicle;
import razarm.tosan.repository.domain.transport.VehicleProvider;
import razarm.tosan.repository.domain.transport.VehicleType;
import razarm.tosan.repository.inMemoryImpl.IdGenerator;
import razarm.tosan.repository.mapper.transport.VehicleProviderDataToVehicleProvider;
import razarm.tosan.repository.mapper.transport.VehicleProviderToVehicleProviderData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//public class VehicleProviderRepositoryImpl implements VehicleProviderRepository {
//    private Map<String , VehicleProviderData> vehicleProviderMap = new HashMap<>();
//
//
//    private final VehicleProviderToVehicleProviderData vehicleProviderToVehicleProviderData;
//    private final VehicleProviderDataToVehicleProvider vehicleProviderDataToVehicleProvider;
//
//    public VehicleProviderRepositoryImpl(VehicleProviderToVehicleProviderData vehicleProviderToVehicleProviderData, VehicleProviderDataToVehicleProvider vehicleProviderDataToVehicleProvider) {
//        this.vehicleProviderToVehicleProviderData = vehicleProviderToVehicleProviderData;
//        this.vehicleProviderDataToVehicleProvider = vehicleProviderDataToVehicleProvider;
//    }
//
//    @Override
//    public VehicleProvider save(VehicleProvider vehicleProvider) {
//        final var id = IdGenerator.generateId();
//        var vehicleData = this.vehicleProviderToVehicleProviderData.convert(vehicleProvider);
//        var newVehicleData = vehicleData.cloneWithId(id);
//        vehicleProviderMap.put(id, newVehicleData);
//        return vehicleProvider.cloneWithId(id);
//    }
//
//    @Override
//    public void update(VehicleProvider vehicleProvider) {
//        vehicleProviderMap.put(vehicleProvider.getId(), this.vehicleProviderToVehicleProviderData.convert(vehicleProvider));
//    }
//
//    @Override
//    public void deleteById(String s) {
//        vehicleProviderMap.remove(s);
//    }
//
//    @Override
//    public VehicleProvider findById(String s) {
//        return this.vehicleProviderDataToVehicleProvider.convert(vehicleProviderMap.get(s));
//    }
//
//    @Override
//    public List<VehicleProvider> findAll() {
//        return vehicleProviderMap.values().stream().map(vehicleProviderDataToVehicleProvider::convert).collect(Collectors.toUnmodifiableList());
//    }
//
//    @Override
//    public Vehicle addVehicle(String providerId, Vehicle vehicle) {
//        final var vehicleProvider= vehicleProviderMap.get(vehicle.getId());
//        final var id = UUID.randomUUID().toString();
//        final var newVehicle = vehicle.cloneWithId(id);
//        final var newVehicleProvider = VehicleProvider.VehicleProviderBuilder.aVehicleProvider()
//                                                                             .id(id)
//                                                                             .name(vehicleProvider.getName())
//                                                                             .phone(vehicleProvider.getPhone())
//                                                                             .email(vehicleProvider.getEmail())
//                                                                             .description(vehicleProvider.getDescription())
//                                                                             .address(vehicleProvider.getAddress())
//                                                                             .vehicles(vehicleProvider.getVehicles())
//                                                                             .createdAt(vehicleProvider.getCreatedAt())
//                                                                             .modifiedAt(vehicleProvider.getModifiedAt())
//                                                                             .createdBy(vehicleProvider.getCreatedBy())
//                                                                             .modifiedBy(vehicleProvider.getModifiedBy())
//                                                                             .vehicles(Stream.concat(vehicleProvider.getVehicles().stream()
//                                                                                     , Stream.of(newVehicle)).collect(Collectors.toUnmodifiableSet()))
//                                                                             .build();
//        vehicleProviderMap.put(vehicleProvider.getId(), newVehicleProvider);
//        return vehicle;
//    }
//
//    @Override
//    public void updateVehicle(String providerId, Vehicle vehicle) {
//        var vehicleProvider = vehicleProviderMap.get(providerId);
//        final var editedVehicleProvider = VehicleProvider.VehicleProviderBuilder.aVehicleProvider()
//                                                                             .id(vehicleProvider.getId())
//                                                                             .name(vehicleProvider.getName())
//                                                                             .phone(vehicleProvider.getPhone())
//                                                                             .email(vehicleProvider.getEmail())
//                                                                             .description(vehicleProvider.getDescription())
//                                                                             .address(vehicleProvider.getAddress())
//                                                                             .vehicles(vehicleProvider.getVehicles())
//                                                                             .createdAt(vehicleProvider.getCreatedAt())
//                                                                             .modifiedAt(vehicleProvider.getModifiedAt())
//                                                                             .createdBy(vehicleProvider.getCreatedBy())
//                                                                             .modifiedBy(vehicleProvider.getModifiedBy())
//                                                                             .vehicles(Stream.concat(vehicleProvider.getVehicles().stream(), Stream.of(vehicle)).collect(Collectors.toUnmodifiableSet()))
//                                                                             .build();
//        vehicleProviderMap.put(providerId, editedVehicleProvider);
//    }
//
//    @Override
//    public void removeVehicle(String providerId, String newVehicleProvider) {
//
//    }
//
//    @Override
//    public Vehicle findVehicleById(String providerId, String vehicleId) {
//        return null;
//    }
//
//    @Override
//    public Vehicle findVehicleByName(String providerId, String vehicleName) {
//        return null;
//    }
//
//    @Override
//    public List<Vehicle> findVehiclesByType(VehicleType type) {
//        return null;
//    }
//
//    @Override
//    public List<Vehicle> findAllVehicles() {
//        return null;
//    }
//}
