package razarm.tosan.service.impl;

import razarm.tosan.controller.dto.food.FoodOrderDto;
import razarm.tosan.controller.mapper.food.FoodOrderDtoToFoodOrder;
import razarm.tosan.controller.mapper.food.FoodOrderToFoodOrderDto;
import razarm.tosan.repository.FoodOrderRepository;
import razarm.tosan.service.FoodOrderService;

import java.util.List;
import java.util.stream.Collectors;

public class FoodOrderServiceImpl implements FoodOrderService {
    private final FoodOrderRepository foodOrderRepository;
    private final FoodOrderToFoodOrderDto foodOrderToFoodOrderDto;
    private final FoodOrderDtoToFoodOrder foodOrderDtoToFoodOrder;

    public FoodOrderServiceImpl(FoodOrderRepository foodOrderRepository, FoodOrderToFoodOrderDto foodOrderToFoodOrderDto, FoodOrderDtoToFoodOrder foodOrderDtoToFoodOrder) {
        this.foodOrderRepository = foodOrderRepository;
        this.foodOrderToFoodOrderDto = foodOrderToFoodOrderDto;
        this.foodOrderDtoToFoodOrder = foodOrderDtoToFoodOrder;
    }

    @Override
    public FoodOrderDto create(FoodOrderDto foodOrderDto) {
        final var  foodOrder = foodOrderDtoToFoodOrder.convert(foodOrderDto);
        final var savedOrder = foodOrderRepository.save(foodOrder);
        return foodOrderToFoodOrderDto.convert(savedOrder);
    }

    @Override
    public void update(FoodOrderDto foodOrderDto) {
        final var  foodOrder = foodOrderDtoToFoodOrder.convert(foodOrderDto);
        foodOrderRepository.update(foodOrder);
    }

    @Override
    public FoodOrderDto findById(String s) {
        return foodOrderToFoodOrderDto.convert(foodOrderRepository.findById(s));
    }

    @Override
    public void deleteById(String s) {
        foodOrderRepository.deleteById(s);
    }

    @Override
    public List<FoodOrderDto> findAll() {
        return foodOrderRepository.findAll().stream()
            .map(foodOrderToFoodOrderDto::convert)
            .collect(Collectors.toUnmodifiableList());
    }
}
