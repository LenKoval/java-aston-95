package ru.aston.kovaleva.atm;

import ru.aston.kovaleva.banknotes.Banknote;

import java.util.List;

/**
 * выдача банкнот
 */
public interface BanknoteDispenser {

    List<Banknote> requestBanknoteByAmount(int amount);
}
