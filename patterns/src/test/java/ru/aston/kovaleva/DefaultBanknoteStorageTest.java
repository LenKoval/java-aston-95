package ru.aston.kovaleva;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.aston.kovaleva.banknotes.Banknote;
import ru.aston.kovaleva.banknotes.HundredBanknote;
import ru.aston.kovaleva.exception.NotFoundNominal;
import ru.aston.kovaleva.storage.DefaultBanknoteStorage;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DefaultBanknoteStorageTest {

    private DefaultBanknoteStorage storage;

    @BeforeEach
    void setUp() {
        storage = new DefaultBanknoteStorage();
    }

    @Test
    void shouldCheckThatPickBanknoteNotFoundExceptionWithWrongNominal() {
        int nominal = 150;

        NotFoundNominal exception = assertThrows(
                NotFoundNominal.class,
                () -> storage.pickBanknote(nominal)
        );

        assertEquals("Not found banknote in storage by nominal:" + nominal, exception.getMessage());
    }

    @Test
    void shouldCheckPickBanknoteWithExistingNominal() {
        int nominal = 100;
        Banknote expectedBanknote = new HundredBanknote();

        storage.insertBanknote(expectedBanknote);

        Banknote result = storage.pickBanknote(nominal);

        assertNotNull(result);
        assertEquals(expectedBanknote, result);
    }
}
