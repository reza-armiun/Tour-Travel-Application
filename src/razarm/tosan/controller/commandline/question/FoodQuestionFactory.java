package razarm.tosan.controller.commandline.question;

import razarm.tosan.controller.commandline.question.QuestionFactory;
import razarm.tosan.controller.dto.food.FoodDto;
import razarm.tosan.controller.dto.food.FoodOrderDto;
import razarm.tosan.controller.dto.food.FoodProviderDto;
import razarm.tosan.repository.domain.food.FoodType;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

public class FoodQuestionFactory  extends QuestionFactory {




    public static FoodOrderDto createFoodOrder() {

        return FoodOrderDto.FoodOrderDtoBuilder.aFoodOrderDto()
                .food(createFood())
                .build();

    }

    public static FoodOrderDto createFoodOrder(FoodDto foodDto) {
        System.out.println(BoldOn + TEXT_BLUE + "Create Food Order:" + BoldOff + TEXT_BLACK);

        return FoodOrderDto.FoodOrderDtoBuilder.aFoodOrderDto()
                .food(foodDto)
                .build();

    }

    public static FoodDto createFood() {
        System.out.println(BoldOn + TEXT_BLUE + "Enter Food Name:" + BoldOff + TEXT_BLACK);
        var foodName = askSimpleQuestion();
        System.out.println(BoldOn + TEXT_BLUE + "Select Food Type:" + BoldOff + TEXT_BLACK);
        var foodType = FoodType.valueOf(selectOptions((String[]) Arrays.stream(FoodType.values()).map(Enum::toString).toArray()));
        System.out.println(BoldOn + TEXT_BLUE + "Enter Ingredients(Separate by spaces):" + BoldOff + TEXT_BLACK);
        var ingredients = askSimpleQuestion().split(" ");
        System.out.println(BoldOn + TEXT_BLUE + "Enter Price:" + BoldOff + TEXT_BLACK);
        var price = new BigInteger(askSimpleQuestion());
        System.out.println(BoldOn + TEXT_BLUE + "Enter Cook Time" + BoldOff + TEXT_BLACK);
        var cookTime = Long.valueOf(askSimpleQuestion());


        var foodProvider = createFoodProvider();
        var newFood = FoodDto.FoodDtoBuilder.aFoodDto()
                .name(foodName)
                .type(foodType)
                .ingredients(ingredients)
                .price(price)
                .cookTime(cookTime)
                .provider(foodProvider)
                .build();

        return newFood;
    }

    public static FoodProviderDto createFoodProvider() {
        while (true) {
            try {
                System.out.println(BoldOn + TEXT_BLUE + "Create Food Provider:" + BoldOff + TEXT_BLACK);
                System.out.println(BoldOn + TEXT_BLUE + "Enter Provider Name:" + BoldOff + TEXT_BLACK);
                var name  = askSimpleQuestion();
                System.out.println(BoldOn + TEXT_BLUE + "Enter Provider Address:" + BoldOff + TEXT_BLACK);
                var address = askSimpleQuestion();
                System.out.println(BoldOn + TEXT_BLUE + "Enter Provider Phone:" + BoldOff + TEXT_BLACK);
                var phone = askSimpleQuestion();
                System.out.println(BoldOn + TEXT_BLUE + "Enter Provider Email:" + BoldOff + TEXT_BLACK);
                var email = askSimpleQuestion();
                System.out.println(BoldOn + TEXT_BLUE + "Enter Provider Description:" + BoldOff + TEXT_BLACK);
                var desc = askSimpleQuestion();
                return FoodProviderDto.FoodProviderDtoBuilder.aFoodProviderDto()
                        .name(name)
                        .address(address)
                        .phone(phone)
                        .email(email)
                        .description(desc)
                        .build();
            }catch (Exception e) {
                System.err.println("Invalid Provider Input Value");
            }
        }
    }
}
