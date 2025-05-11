package com.miempresa.clientepersona.service.impl;

import com.miempresa.clientepersona.entity.Cliente;
import com.miempresa.clientepersona.repository.ClienteRepository;
import com.miempresa.clientepersona.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.miempresa.clientepersona.dto.Cuenta;



import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente actualizarCliente(Long id, Cliente cliente) {
        Cliente existente = clienteRepository.findById(id).orElseThrow();
        existente.setNombre(cliente.getNombre());
        existente.setGenero(cliente.getGenero());
        existente.setEdad(cliente.getEdad());
        existente.setIdentificacion(cliente.getIdentificacion());
        existente.setDireccion(cliente.getDireccion());
        existente.setTelefono(cliente.getTelefono());
        existente.setContrasena(cliente.getContrasena());
        existente.setEstado(cliente.isEstado());
        return clienteRepository.save(existente);
    }

    @Override
    public void eliminarCliente(Long idCliente) {
    if (tieneCuentasAsociadas(idCliente)) {
        throw new RuntimeException("No se puede eliminar el cliente porque tiene cuentas asociadas.");
    }
    clienteRepository.deleteById(idCliente);
}

private boolean tieneCuentasAsociadas(Long idCliente) {
    String url = "http://cuenta-movimiento-service:8080/cuentas/cliente/" + idCliente;
    ResponseEntity<Cuenta[]> response = new RestTemplate().getForEntity(url, Cuenta[].class);
    Cuenta[] cuentas = response.getBody();
    return cuentas != null && cuentas.length > 0;
}


}
