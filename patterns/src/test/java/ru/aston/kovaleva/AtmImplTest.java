package ru.aston.kovaleva;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.kovaleva.atm.Atm;
import ru.aston.kovaleva.atm.BanknoteDispenser;
import ru.aston.kovaleva.atm.BanknoteInserter;
import ru.aston.kovaleva.atm.BanknoteViewer;
import ru.aston.kovaleva.atm.AtmImpl;
import ru.aston.kovaleva.banknotes.Banknote;
import ru.aston.kovaleva.banknotes.FiveHundredBanknote;
import ru.aston.kovaleva.banknotes.FiveThousandBanknote;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AtmImplTest {

    private Atm atm;
    private BanknoteDispenser mockDispenser;
    private BanknoteInserter mockInserter;
    private BanknoteViewer mockViewer;

    @BeforeEach
    void setUp() {
        mockDispenser = mock(BanknoteDispenser.class);
        mockInserter = mock(BanknoteInserter.class);
        mockViewer = mock(BanknoteViewer.class);

        atm = new AtmImpl(mockDispenser, mockInserter, mockViewer);
    }

    @Test
    void shouldInsertBanknote() {
        Banknote banknote = new FiveHundredBanknote();

        atm.insert(banknote);

        verify(mockInserter).insert(banknote);
    }

    @Test
    void shouldReturnListOfBanknotesByAmount() {
        int amount = 5500;
        List<Banknote> expectedBanknotes = Arrays.asList(new FiveHundredBanknote(), new FiveThousandBanknote());

        when(mockDispenser.requestBanknoteByAmount(amount)).thenReturn(expectedBanknotes);

        List<Banknote> result = atm.requestBanknoteByAmount(amount);

        assertEquals(expectedBanknotes, result);
        verify(mockDispenser).requestBanknoteByAmount(amount);
    }

    @Test
    void shouldCheckBalance() {
        int expectedBalance = 500;

        when(mockViewer.balance()).thenReturn(expectedBalance);

        int result = atm.balance();

        assertEquals(expectedBalance, result);
        verify(mockViewer).balance();
    }
}
