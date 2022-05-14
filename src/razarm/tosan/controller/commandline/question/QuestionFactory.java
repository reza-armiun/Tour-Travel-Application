package razarm.tosan.controller.commandline.question;

import razarm.tosan.controller.commandline.AppScanner;
import razarm.tosan.controller.dto.address.AddressDto;
import razarm.tosan.controller.dto.address.CityDto;
import razarm.tosan.controller.dto.address.CountryDto;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuestionFactory {
    public final static String ESC = "\u001B";
    public final static String GS = "\u001D";
    public final static String InitializePrinter = ESC + "@";
    //    public final static String BoldOn = ESC + "E" + "\u0001";
    public final static String BoldOn = "\033[0;1m";
    //    public final static String BoldOff = ESC + "E" + "\0";
    public final static String BoldOff ="\033[0;0m";
    public final static String DoubleOn = GS + "!" + "\u0011";  // 2x sized text (double-high + double-wide)
    public final static String DoubleOff = GS + "!" + "\0";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_PURPLE = "\u001B[35m";
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_WHITE = "\u001B[37m";

    protected QuestionFactory() {}


    public static void showSuccessMsg(String msg) {
        System.out.println(BoldOn + TEXT_GREEN + msg + BoldOff + TEXT_RESET);
    }


    public static Set<CityDto> getMockCities() {
        var iran  = CountryDto.CountryDtoBuilder.aCountryDto().name("Iran").build();
        var boushehr = CityDto.CityDtoBuilder.aCityDto().name("Boushehr").country(iran).build();
        var tehran= CityDto.CityDtoBuilder.aCityDto().name("Tehran").country(iran).build();
        var shiraz= CityDto.CityDtoBuilder.aCityDto().name("Shiraz").country(iran).build();

        var ukraine =  CountryDto.CountryDtoBuilder.aCountryDto().name("Ukraine").build();
        var Kyiv = CityDto.CityDtoBuilder.aCityDto().name("Kyiv").country(ukraine).build();
        var Kharkiv = CityDto.CityDtoBuilder.aCityDto().name("Kharkiv").country(ukraine).build();
        var Lviv = CityDto.CityDtoBuilder.aCityDto().name("Lviv").country(ukraine).build();

        var turkey =   CountryDto.CountryDtoBuilder.aCountryDto().name("Turkey").build();
        var Istanbul = CityDto.CityDtoBuilder.aCityDto().name("Istanbul").country(turkey).build();
        var Ankara = CityDto.CityDtoBuilder.aCityDto().name("Ankara").country(turkey).build();
        var Izmir = CityDto.CityDtoBuilder.aCityDto().name("Izmir").country(turkey).build();
        return Set.of(boushehr, tehran, shiraz, Kyiv, Kharkiv, Lviv, Istanbul, Ankara, Izmir);
    }

    public static String selectOptions(String [] options) {
        IntStream.range(0, options.length)
                .mapToObj(i ->  BoldOn + i + "." + BoldOff+ TEXT_YELLOW+  options[i].trim() + TEXT_WHITE + " ")
                .forEach(System.out::print);
        System.out.println();
        while (true) {
            try{
                var selected = Integer.valueOf(askSimpleQuestion());
                return options[selected];
            }catch (Exception e) {
                System.err.println("Please enter number value");
            }
        }
    }
    public static Integer selectOptionsIndex(String desc , String [] options) {
        System.out.println(BoldOn + TEXT_WHITE +  desc  + TEXT_WHITE+ BoldOff + TEXT_WHITE);

        IntStream.range(0, options.length)
                .mapToObj(i ->  BoldOn + i + "." + BoldOff+ TEXT_YELLOW+  options[i].trim() + TEXT_WHITE + " ")
                .forEach(System.out::print);
        System.out.println();
        while (true) {
            try{
                var selected = Integer.valueOf(askSimpleQuestion());
                return selected;
            }catch (Exception e) {
                System.err.println("Please enter number value");
            }
        }
    }

    public static boolean confirmationQuestion(String desc) {
        System.out.println(BoldOn + TEXT_YELLOW +  desc  + TEXT_WHITE+ " (Y/n)"+ BoldOff + TEXT_WHITE);
        var answer  = askSimpleQuestion();
        if("y".equals(answer.toLowerCase())) return true;
        return false;
    }

    public static OffsetDateTime createDate(String desc) {
        var scanner = AppScanner.getScanner();
        System.out.println(BoldOn + TEXT_YELLOW + "Enter "+ desc  + BoldOff + TEXT_WHITE);

        int sec = 0;
        int min = 0;
        int hr = 0;
        int day = 0;
        int month = 0;
        int year = 0;
        while (true) {
            try {
                System.out.println(BoldOn + TEXT_BLUE + "Enter year:" + BoldOff + TEXT_WHITE);
                year = scanner.nextInt();
                if (year >= 2100 || year < 1800) throw new IllegalArgumentException();

                System.out.println(BoldOn + TEXT_BLUE + "Enter month:" + BoldOff + TEXT_WHITE);
                month = scanner.nextInt();
                if (month >= 12 || month < 0) throw new IllegalArgumentException();

                System.out.println(BoldOn + TEXT_BLUE + "Enter day:" + BoldOff + TEXT_WHITE);
                day = scanner.nextInt();
                if (day >= 30 || day < 0) throw new IllegalArgumentException();

                System.out.println(BoldOn + TEXT_BLUE + "Enter hour:" + BoldOff + TEXT_WHITE);
                hr = scanner.nextInt();
                if (hr >= 24 || hr < 0) throw new IllegalArgumentException();

                System.out.println(BoldOn + TEXT_BLUE + "Enter minute:" + BoldOff + TEXT_WHITE);
                min = scanner.nextInt();
                if (min >= 60 || min < 0) throw new IllegalArgumentException();

                System.out.println(BoldOn + TEXT_BLUE + "Enter second:" + BoldOff + TEXT_WHITE);
                sec = scanner.nextInt();
                if (sec >= 60 || sec < 0) throw new IllegalArgumentException();
                var date = OffsetDateTime.of(year, month, day, hr, min, sec, 0, ZoneOffset.UTC);
                System.out.println(BoldOn + TEXT_YELLOW + desc + date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) + BoldOff + TEXT_WHITE);
                return date;
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid input");
            }
        }
    }

    public  static String askSimpleQuestion() {
        var scanner = AppScanner.getScanner();
        return scanner.next();
    }
    public  static String askSimpleQuestion(String desc) {
        System.out.println(BoldOn + TEXT_BLUE + desc + BoldOff + TEXT_WHITE);
        var scanner = AppScanner.getScanner();
        return scanner.next();
    }

    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public static Long askSimpleNumberQuestion() {
        String num = null;
        var scanner = AppScanner.getScanner();
        while (true){
                num =  scanner.next();
                if(!isNumeric(num)) {
                    System.err.println("Invalid number input");
                }
                else break;
        }
        return Long.valueOf(num);
    }


    public static AddressDto createAddress(String desc, Set<CityDto> cities ) {
       while(true) {
           try {
               System.out.println(BoldOn + TEXT_YELLOW + desc + BoldOff + TEXT_WHITE);

               System.out.println(BoldOn + TEXT_BLUE + "Select Country:" + BoldOff + TEXT_WHITE);
               List<CountryDto> countries = cities.stream().map(CityDto::getCountry).distinct().collect(Collectors.toUnmodifiableList());
               IntStream.range(0, countries.size())
                       .mapToObj(i ->  BoldOn + i + "." + BoldOff + TEXT_YELLOW + countries.get(i).getName() + TEXT_WHITE + " ")
                       .forEach(System.out::print);
               var selection = Integer.valueOf(askSimpleQuestion());
               var selectedCountry = countries.get(selection);
               var cityOptions = cities.stream().filter(cityDto -> cityDto.getCountry().getName().equals(selectedCountry.getName())).collect(Collectors.toUnmodifiableList());

               System.out.println("Select City: ");
               IntStream.range(0, cityOptions.size())
                       .mapToObj(i ->  BoldOn + i + "." + BoldOff + TEXT_YELLOW + cityOptions.get(i).getName() + TEXT_WHITE + " ")
                       .forEach(System.out::print);
               var citySelection = Integer.valueOf(askSimpleQuestion());
               var selectedCity = cityOptions.get(citySelection);

               System.out.println(BoldOn + TEXT_BLUE + "Enter Postal Code" + BoldOff + TEXT_WHITE);
               var postalCode = askSimpleQuestion();

               System.out.println(BoldOn + TEXT_BLUE + "Enter Street" + BoldOff + TEXT_WHITE);
               var street = askSimpleQuestion();
               return AddressDto.AddressDtoBuilder.anAddressDto()
                       .city(selectedCity)
                       .postalCode(postalCode)
                       .street(street)
                       .build();
           }catch (Exception e) {
               System.err.println("Invalid input");
           }
       }
    }




}
