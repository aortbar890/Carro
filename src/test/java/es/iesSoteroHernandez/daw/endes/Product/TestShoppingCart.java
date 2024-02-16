package es.iesSoteroHernandez.daw.endes.Product;

import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.*;

public class TestShoppingCart {
    
    private Product producto1;
    private Product producto2;
    private ShoppingCart carro;
    
    @BeforeEach
    public void setUp() {
        producto1 = new Product("Producto 1", 10.00);
        producto2 = new Product("Producto 2", 20.00);
        carro = new ShoppingCart();
    }
    
    @Test
    public void testInicialItemCount() {
        assertEquals(0, carro.getItemCount());
    }
    
    @Test
    public void testCarroVacioItemCount() {
        carro.empty();
        assertEquals(0, carro.getItemCount());
    }
    
    @Test
    public void testAgregarItem() {
        carro.addItem(producto1);
        assertEquals(1, carro.getItemCount());
    }
    
    @Test
    public void testAgregarVariosItemsBalance() {
        carro.addItem(producto1);
        carro.addItem(producto2);
        assertEquals(30.00, carro.getBalance());
    }
    
    @Test
    public void testEliminaItem() throws ProductNotFoundException {
        carro.addItem(producto1);
        carro.removeItem(producto1);
        assertEquals(0, carro.getItemCount());
    }
    
    @Test
    public void testEliminaItemNoCarro() {        
        try {
            carro.removeItem(producto1);
            fail("Se esperaba que lanzara ProductNotFoundException.");
        } catch (ProductNotFoundException e) {
            assertTrue(true);
        }
    }
}

