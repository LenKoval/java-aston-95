package ru.aston.kovaleva.atm;

import ru.aston.kovaleva.banknotes.Banknote;

import java.util.List;

/**
 * Общий интерфейс для работы с банкоматом. Реализует паттерн State, где каждый метод работает с отдельным
 * классом в зависимости от ожидаемого поведения
 */
public interface Atm {

    void insert(Banknote banknote);

    List<Banknote> requestBanknoteByAmount(int amount);

    int balance();
}
