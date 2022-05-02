package razarm.tosan.service.impl;

import razarm.tosan.controller.dto.food.FoodDto;
import razarm.tosan.controller.dto.food.FoodProviderDto;
import razarm.tosan.controller.mapper.food.FoodDtoToFood;
import razarm.tosan.controller.mapper.food.FoodProviderDtoToFoodProvider;
import razarm.tosan.controller.mapper.food.FoodProviderToFoodProviderDto;
import razarm.tosan.controller.mapper.food.FoodToFoodDto;
import razarm.tosan.repository.FoodProviderRepository;
import razarm.tosan.repository.domain.food.FoodProvider;
import razarm.tosan.service.ServeFoodService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ServeFoodServiceImpl implements ServeFoodService {

    private final FoodProviderRepository foodProviderRepository;
    private final FoodDtoToFood foodDtoToFood;
    private final FoodToFoodDto foodToFoodDto;
    private final FoodProviderDtoToFoodProvider foodProviderDtoToFoodProvider;
    private final FoodProviderToFoodProviderDto foodProviderToFoodProviderDto;

    public ServeFoodServiceImpl(FoodProviderRepository foodProviderRepository, FoodDtoToFood foodDtoToFood, FoodToFoodDto foodToFoodDto
            , FoodProviderDtoToFoodProvider foodProviderDtoToFoodProvider, FoodProviderToFoodProviderDto foodProviderToFoodProviderDto) {
        this.foodProviderRepository = foodProviderRepository;
        this.foodDtoToFood = foodDtoToFood;
        this.foodToFoodDto = foodToFoodDto;
        this.foodProviderDtoToFoodProvider = foodProviderDtoToFoodProvider;
        this.foodProviderToFoodProviderDto = foodProviderToFoodProviderDto;
    }

    @Override
    public FoodProviderDto create(FoodProviderDto foodProviderDto) {
        var provider = this.foodProviderDtoToFoodProvider.convert(foodProviderDto);
        return this.foodProviderToFoodProviderDto.convert(this.foodProviderRepository.save(provider));
    }

    @Override
    public void update(FoodProviderDto foodProviderDto) {
        if(foodProviderDto == null || foodProviderDto.getId() == null) throw new NullPointerException("null food provider value");
        var provider = this.foodProviderDtoToFoodProvider.convert(foodProviderDto);

        this.foodProviderRepository.update(provider);
    }

    @Override
    public FoodProviderDto findById(String s) {
        if(s == null) throw new NullPointerException("null food provider id");
        return this.foodProviderToFoodProviderDto.convert(this.foodProviderRepository.findById(s));
    }

    @Override
    public void deleteById(String s) {
        if(s == null) throw new NullPointerException("null food provider id");

        this.foodProviderRepository.deleteById(s);
    }

    @Override
    public List<FoodProviderDto> findAll() {
        return this.foodProviderRepository.findAll().stream()
                .map(foodProviderToFoodProviderDto::convert)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<FoodDto> findAllAvailableFoods() {
        return this.foodProviderRepository.findAll().stream()
                .map(FoodProvider::getFoods)
                .flatMap(Collection::stream)
                .map(foodToFoodDto::convert)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<FoodDto> findFoodsByName(String name) {
        if(name == null) throw new NullPointerException("null food provider name");

        return this.foodProviderRepository.findAll().stream()
                                          .map(FoodProvider::getFoods)
                                          .flatMap(Collection::stream)
                                          .filter(food -> food.getName().equals(name))
                                          .map(foodToFoodDto::convert)
                                          .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<FoodProviderDto> findAllFoodProviders() {
        return this.foodProviderRepository.findAll().stream()
                .map(foodProviderToFoodProviderDto::convert)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public FoodProviderDto findByName(String name) {
        if(name == null) throw new NullPointerException("null food provider name");

        return foodProviderToFoodProviderDto.convert(this.foodProviderRepository.findByName(name));
    }

    @Override
    public FoodDto addFood(String providerId, FoodDto foodDto) {
        if(providerId == null || foodDto == null) throw new NullPointerException("null value");
        var food = this.foodDtoToFood.convert(foodDto);

        return this.foodToFoodDto.convert(this.foodProviderRepository.addFood(providerId, food));
    }

    @Override
    public void updateFood(String providerId, FoodDto foodDto) {
        if(providerId == null || foodDto == null) throw new NullPointerException("null value");

        var food = this.foodDtoToFood.convert(foodDto);
        this.foodProviderRepository.updateFood(providerId, food);
    }

    @Override
    public void removeFood(String providerId, String foodId) {
        if(providerId == null || foodId == null) throw new NullPointerException("null value");
        this.foodProviderRepository.removeFood(providerId, foodId);
    }

    @Override
    public List<FoodDto> findProviderFoodList(String providerId) {
        if(providerId == null ) throw new NullPointerException("null food provider id");

        var provider = this.foodProviderRepository.findById(providerId);

        return provider.getFoods().stream()
                .map(foodToFoodDto::convert)
                .collect(Collectors.toUnmodifiableList());
    }
}
