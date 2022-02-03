package ru.job4j.ood.srp.reports;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * 2.5.2. OCP
 * 1. Поддержка форматом XML, JSON в генераторе отчетов. [#851]
 *
 * @author Dima_Nout
 * @since 04.02.2022
 */
public class JsonGenerator implements ReportGenerator<Employee, String> {
    @Override
    public String generator(List<Employee> list) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(list);
    }
}
