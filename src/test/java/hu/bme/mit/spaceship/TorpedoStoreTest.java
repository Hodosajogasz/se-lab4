package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
        assertEquals(0, store.getTorpedoCount());
    }

    @Test 
    void torpedo_Count(){
        TorpedoStore store = new TorpedoStore(5,0.0);
        boolean result = store.fire(1);
        assertEquals(true, result);
        assertEquals(4, store.getTorpedoCount());
    }

    @Test 
    void negative_Torpedo_Firing(){
        TorpedoStore store = new TorpedoStore(1,0.0);
        assertThrows(IllegalArgumentException.class,()->store.fire(-2) );
    }

    @Test 
    void more_Torpedo_Firing_Test(){
        TorpedoStore store = new TorpedoStore(2);
        assertThrows(IllegalArgumentException.class, ()->store.fire(3));
    }
    @Test 
    void firing_Failure(){
        TorpedoStore store = new TorpedoStore(1,1.0);
        boolean result = store.fire(1);
        assertEquals(false, result);
    }
    @Test 
    void isEmpty_Test(){
        TorpedoStore emptyStore = new TorpedoStore(0,0.0);
        TorpedoStore nonEmptyStore = new TorpedoStore(1,0.0);
        assertEquals(true, emptyStore.isEmpty());
        assertEquals(false, nonEmptyStore.isEmpty());
    }
}
