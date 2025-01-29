package ru.aston.kovaleva.atm;

import lombok.AllArgsConstructor;
import ru.aston.kovaleva.banknotes.Banknote;

import java.util.List;

@AllArgsConstructor
public class AtmImpl implements Atm {

    private final BanknoteDispenser dispenser;

    private final BanknoteInserter inserter;

    private final BanknoteViewer viewer;

    @Override
    public void insert(Banknote banknote) {
        inserter.insert(banknote);
    }

    @Override
    public List<Banknote> requestBanknoteByAmount(int amount) {
        return dispenser.requestBanknoteByAmount(amount);
    }

    @Override
    public int balance() {
        return viewer.balance();
    }
}
