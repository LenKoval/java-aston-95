package ru.aston.kovaleva.atm;

import lombok.AllArgsConstructor;
import ru.aston.kovaleva.banknotes.Banknote;
import ru.aston.kovaleva.storage.BanknoteStorage;

@AllArgsConstructor
public class BanknoteInserterImpl implements BanknoteInserter {

    private final BanknoteStorage banknoteStorage;

    @Override
    public void insert(Banknote banknote) {
        banknoteStorage.insertBanknote(banknote);
    }
}
