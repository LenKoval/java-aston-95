package ru.aston.kovaleva.atm;

import lombok.AllArgsConstructor;
import ru.aston.kovaleva.storage.BanknoteStorage;

@AllArgsConstructor
public class BanknoteViewerImpl implements BanknoteViewer {

    private final BanknoteStorage banknoteStorage;

    @Override
    public int balance() {
        return banknoteStorage.amount();
    }
}
