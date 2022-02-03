package ru.job4j.ood.srp.reports;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

/**
 * 2.5.2. OCP
 * 1. Поддержка форматом XML, JSON в генераторе отчетов. [#851]
 *
 * @author Dima_Nout
 * @since 04.02.2022
 */
public class XmlGenerator implements ReportGenerator<Employee, String> {
    @Override
    public String generator(List<Employee> list) {
        String result = "";
        try (StringWriter writer = new StringWriter()) {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(new Employees(list), writer);
            result = writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
