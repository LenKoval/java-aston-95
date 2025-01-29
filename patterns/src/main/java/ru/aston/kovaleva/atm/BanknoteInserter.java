package ru.aston.kovaleva.atm;

import ru.aston.kovaleva.banknotes.Banknote;

/**
 * приемка банкнот
 */
public interface BanknoteInserter {

    void insert(Banknote banknote);
}
