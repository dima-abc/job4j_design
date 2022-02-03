package ru.job4j.ood.srp.reports;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * 2.5.2. OCP
 * 1. Поддержка форматом XML, JSON в генераторе отчетов. [#851]
 *
 * @author Dima_Nout
 * @since 04.02.2022
 */
public class DateAdapter extends XmlAdapter<String, Calendar> {
    private static final String CUSTOM_FORMAT_STRING = "E MMM dd HH:mm:ss zzz yyyy";

    @Override
    public Calendar unmarshal(String v) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(CUSTOM_FORMAT_STRING, Locale.ENGLISH).parse(v));
        return calendar;
    }

    @Override
    public String marshal(Calendar v) throws Exception {
        return new SimpleDateFormat(CUSTOM_FORMAT_STRING, Locale.ENGLISH).format(v.getTime());
    }
}
