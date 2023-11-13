package services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @Test
    void readLotDescription() {
        String desc = FileManager.readLotDescription("no.txt");
        assertEquals(desc, "no desc");
    }
}