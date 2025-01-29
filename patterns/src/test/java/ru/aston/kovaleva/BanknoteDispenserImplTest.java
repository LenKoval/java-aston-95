package ru.aston.kovaleva;

import org.junit.jupiter.api.Test;
import ru.aston.kovaleva.atm.BanknoteDispenserImpl;
import ru.aston.kovaleva.banknotes.FiveHundredBanknote;
import ru.aston.kovaleva.exception.InsufficientFundsException;
import ru.aston.kovaleva.storage.BanknoteStorage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BanknoteDispenserImplTest {

    @Test
    void shouldCheckThatRequestBanknoteByAmountInsufficientFundsException() {
        BanknoteStorage mockStorage = mock(BanknoteStorage.class);
        when(mockStorage.amount()).thenReturn(100);
        BanknoteDispenserImpl dispenser = new BanknoteDispenserImpl(mockStorage);

        InsufficientFundsException exception = assertThrows(
                InsufficientFundsException.class,
                () -> dispenser.requestBanknoteByAmount(200)
        );

        assertEquals("Insufficient banknotes to complete the operation.", exception.getMessage());
    }

    @Test
    void shouldCheckThatRequestBanknoteByAmountUnableToDispenseException() {
        BanknoteStorage mockStorage = mock(BanknoteStorage.class);
        when(mockStorage.amount()).thenReturn(100);
        when(mockStorage.getNominals()).thenReturn(List.of(500, 500));
        when(mockStorage.getBanknotesByNominal(500)).thenReturn(List.of(new FiveHundredBanknote()));
        when(mockStorage.pickBanknote(500)).thenReturn(new FiveHundredBanknote());
        BanknoteDispenserImpl dispenser = new BanknoteDispenserImpl(mockStorage);

        InsufficientFundsException exception = assertThrows(
                InsufficientFundsException.class,
                () -> dispenser.requestBanknoteByAmount(2)
        );

        assertEquals("Unable to dispense the requested amount with available banknotes.", exception.getMessage());
    }
}
