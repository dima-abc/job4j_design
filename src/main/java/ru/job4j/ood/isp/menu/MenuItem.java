package ru.job4j.ood.isp.menu;

import java.util.List;

/**
 * 2.5.4. ISP
 * 1. Создать меню.
 * MenuItem интерфейс описывает пункт меню.
 *
 * @author Dima_Nout
 * @since 13.02.2022.
 */
public interface MenuItem {

    String getName();

    List<MenuItem> getChildren();

    ActionDelegate getActionDelegate();
}
