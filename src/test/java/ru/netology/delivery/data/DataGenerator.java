package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{"Майкоп", "Горно-Алтайск", "Уфа", "Улан-Уде", "Махачкала", "Магас", "Нальчик",
                "Элиста", "Черкесск", "Петрозаводск", "Сывтывкар", "Симферопль", "Йошкор-Ола", "Саранск",
                "Якутск", "Владикавказ", "Казань", "Кызыл", "Ижевск", "Абакан", "грозный", "Чебоксары", "Барнаул",
                "Чита", "Петропавловск-Камчатский", "Краснодар", "Красноярск", "Пермь", "Владивосток", "Ставрополь",
                "Хабаровск", "Благовещенск", "Архангельск", "Астрахань", "белгород", "брянск", "Владимир",
                "Волгоград", "Вологда", "Воронеж", "Иваново", "Орёл", "Иркутск", "Калининград", "Калуга", "Кемерово",
                "Киров", "Кострома", "Курган", "Курск", "Санкт-Петербург", "Липецк", "Магадан", "Москва", "Мурманск",
                "Нижний Новгород", "Великий Новгород", "Новосибирск", "Омск", "Оренбург", "Пенза", "Псков",
                "Салехард", "Ростов-на-Дону", "Рязфнь", "Самара", "Саратов", "южно-Сахалинск", "Екатеринбург",
                "Смоленск", "тамбов", "тверь", "Томск", "Тула", "Тюмень", "Ульяновск", "Челябинск", "Ярославль",
                "Севастополь", "Биробиджан", "Нарьян-Мар", "Ханты-Мансийск", "Анадырь"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }


    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
