package ru.aston.kovaleva.atm;

import lombok.AllArgsConstructor;
import ru.aston.kovaleva.banknotes.Banknote;
import ru.aston.kovaleva.exception.InsufficientFundsException;
import ru.aston.kovaleva.storage.BanknoteStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public class BanknoteDispenserImpl implements BanknoteDispenser {

    private final BanknoteStorage banknoteStorage;

    @Override
    public List<Banknote> requestBanknoteByAmount(int amount) {
        if (banknoteStorage.amount() < amount) {
            throw new InsufficientFundsException("Insufficient banknotes to complete the operation.");
        }

        var nominals = new ArrayList<>(banknoteStorage.getNominals());
        nominals.sort(Collections.reverseOrder());
        List<Banknote> result = new ArrayList<>();
        for (int nominal : nominals) {
            while (amount >= nominal && !banknoteStorage.getBanknotesByNominal(nominal).isEmpty()) {
                Banknote banknote = banknoteStorage.pickBanknote(nominal);
                result.add(banknote);
                amount -= nominal;
            }
        }

        if (amount > 0) {
            for (Banknote banknote : result) {
                banknoteStorage.insertBanknote(banknote);
            }
            throw new InsufficientFundsException("Unable to dispense the requested amount with available banknotes.");
        }

        return result;
    }
}
