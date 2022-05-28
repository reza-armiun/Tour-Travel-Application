package razarm.tosan.service.impl;

import org.springframework.stereotype.Service;
import razarm.tosan.controller.dto.accommodation.AccommodationOrderDto;
import razarm.tosan.controller.mapper.accommodation.AccOrderDtoToAccOrder;
import razarm.tosan.controller.mapper.accommodation.AccOrderToAccOrderDto;
import razarm.tosan.repository.AccommodationOrderRepository;
import razarm.tosan.service.AccommodationOrderService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccommodationOrderServiceImpl implements AccommodationOrderService {
    private final AccommodationOrderRepository accommodationOrderRepository;
    private final AccOrderToAccOrderDto accOrderToAccOrderDto;
    private final AccOrderDtoToAccOrder accOrderDtoToAccOrder;

    public AccommodationOrderServiceImpl(AccommodationOrderRepository accommodationOrderRepository, AccOrderToAccOrderDto accOrderToAccOrderDto, AccOrderDtoToAccOrder accOrderDtoToAccOrder) {
        this.accommodationOrderRepository = accommodationOrderRepository;
        this.accOrderToAccOrderDto = accOrderToAccOrderDto;
        this.accOrderDtoToAccOrder = accOrderDtoToAccOrder;
    }

    @Override
    public AccommodationOrderDto create(AccommodationOrderDto accommodationOrderDto) {
        final var accOrder = accOrderDtoToAccOrder.convert(accommodationOrderDto);
        final var savedOrder = accommodationOrderRepository.save(accOrder);
        return accOrderToAccOrderDto.convert(savedOrder);
    }

    @Override
    public void update(AccommodationOrderDto accommodationOrderDto) {
        final var accOrder = accOrderDtoToAccOrder.convert(accommodationOrderDto);
         accommodationOrderRepository.update(accOrder);
    }

    @Override
    public AccommodationOrderDto findById(String s) {
        return accOrderToAccOrderDto.convert(accommodationOrderRepository.findById(s));
    }

    @Override
    public void deleteById(String s) {
        accommodationOrderRepository.deleteById(s);
    }

    @Override
    public List<AccommodationOrderDto> findAll() {
        return accommodationOrderRepository.findAll().stream()
            .map(accOrderToAccOrderDto::convert)
            .collect(Collectors.toUnmodifiableList());
    }
}
