package ru.aston.kovaleva.storage;

import ru.aston.kovaleva.banknotes.Banknote;

import java.util.List;

/**
 * Хранилище банкнот "Компоновщик" позволяет работать с коллекциями банкнот, а также с различными их номиналами
 */
public interface BanknoteStorage {

    void insertBanknote(Banknote banknote);

    Banknote pickBanknote(int nominal);

    List<Banknote> getBanknotesByNominal(int nominal);

    List<Integer> getNominals();

    int amount();
}
