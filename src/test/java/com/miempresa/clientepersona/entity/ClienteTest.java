package com.miempresa.clientepersona.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void testClienteGettersAndSetters() {
        Cliente cliente = new Cliente();

        cliente.setClienteId(1L);
        cliente.setContrasena("clave123");
        cliente.setEstado(true);

        // Métodos heredados de Persona
        cliente.setNombre("María");
        cliente.setGenero("F");
        cliente.setEdad(28);
        cliente.setIdentificacion("1234567890");
        cliente.setDireccion("Calle 123");
        cliente.setTelefono("0999999999");

        assertEquals(1L, cliente.getClienteId());
        assertEquals("clave123", cliente.getContrasena());
        assertTrue(cliente.isEstado());

        assertEquals("María", cliente.getNombre());
        assertEquals("F", cliente.getGenero());
        assertEquals(28, cliente.getEdad());
        assertEquals("1234567890", cliente.getIdentificacion());
        assertEquals("Calle 123", cliente.getDireccion());
        assertEquals("0999999999", cliente.getTelefono());
    }
}
