package ru.job4j.ood.dip.simple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 2.5.5. DIP
 * 0. Принцип инверсии зависимостей [#4917]
 * Задание. Пример нарушения DIP.
 * Класс учета студентов на факультете.
 * Нарушение DIP.
 * 1.	Использование поля типа Map, в качестве хранилище. Решение завести абстрактное хранилище и принимать его в конструкторе, с целью хранить данные в базе данных в файле.
 * 2.	Все выводы и исключения в методе remove и print заменить на абстракцию типа Log4j или Slf4j, так как они связаны с консолью.
 * 3.	Так же метод print нарушает DIP так как привязан к выводу на консоль. Решение переопределить интерфейс и принимать его для вывода, для возможного вывода на консоль в файл принтер.
 * В целом класс так же нарушает SRP.
 * По модели данных так же можно создать абстракцию для учета как студентов так и поступающих, или пойти шире и осуществить учет преподавателей.
 *
 * @author Dmitry Stepanov, user Dmitry
 * @since 15.02.2022
 */
public class DepartmentSimpleFoulDIP {
    /**
     * Хранилище.
     */
    private Map<Integer, StudentSimpleFoulDIP> storage = new HashMap<>();

    /**
     * Добавление студентов
     *
     * @param student StudentSimpleFoulDIP
     * @return StudentSimpleFoulDIP
     */
    public StudentSimpleFoulDIP add(StudentSimpleFoulDIP student) {
        return storage.put(student.getId(), student);
    }

    /**
     * Удаление студента.
     *
     * @param student StudentSimpleFoulDIP
     * @return StudentSimpleFoulDIP
     */
    public StudentSimpleFoulDIP remove(StudentSimpleFoulDIP student) {
        StudentSimpleFoulDIP result = storage.remove(student.getId());
        if (result == null) {
            System.out.println("Student not exist.");
            throw new NoSuchElementException("Student is not exist");
        }
        return storage.remove(student.getId());
    }

    /**
     * Поиск студента.
     *
     * @param predicate Predicate.
     * @return List
     */
    public List<StudentSimpleFoulDIP> findStudent(Predicate<StudentSimpleFoulDIP> predicate) {
        return storage.keySet().stream()
                .filter(k -> predicate.test(storage.get(k)))
                .map(k -> storage.get(k))
                .collect(Collectors.toList());
    }

    /**
     * Вывод студента.
     *
     * @param student StudentSimpleFoulDIP.
     */
    public void print(StudentSimpleFoulDIP student) {
        if (student == null) {
            System.out.println("Student is empty");
            throw new IllegalArgumentException("Student is empty");
        }
        System.out.println(student);
    }
}
