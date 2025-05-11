package com.miempresa.clientepersona.service;

import com.miempresa.clientepersona.entity.Cliente;
import com.miempresa.clientepersona.repository.ClienteRepository;
import com.miempresa.clientepersona.service.impl.ClienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Test
    void crearClienteDebeGuardarYRetornarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan Perez");
        cliente.setDireccion("Quito");
        cliente.setTelefono("0991234567");
        cliente.setContrasena("1234");
        cliente.setGenero("M");
        cliente.setEdad(30);
        cliente.setEstado(true);

        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente resultado = clienteService.crearCliente(cliente);

        assertNotNull(resultado);
        assertEquals("Juan Perez", resultado.getNombre());
        verify(clienteRepository, times(1)).save(cliente);
    }

    @Test
    void obtenerClientePorIdDebeRetornarClienteSiExiste() {
        Cliente cliente = new Cliente();
        cliente.setClienteId(1L);
        cliente.setNombre("Maria Lopez");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> resultado = clienteService.obtenerClientePorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Maria Lopez", resultado.get().getNombre());
        verify(clienteRepository, times(1)).findById(1L);
    }
}
