package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * 2.1.5. Map
 * 2. Без переопределения equals и hashCode[#1005#127225]
 *
 * @author Dmitry
 * @version 1
 * @since 02.11.2021
 */
public class UserMap {
    public static void main(String[] args) {
        User user1 = new User("Petr", 2, new GregorianCalendar(1985, Calendar.NOVEMBER, 25));
        User user2 = new User("Petr", 2, new GregorianCalendar(1985, Calendar.NOVEMBER, 25));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map.keySet());
    }
}
