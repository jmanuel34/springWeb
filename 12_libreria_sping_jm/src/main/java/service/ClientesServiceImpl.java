package service;

import org.springframework.stereotype.Service;

import dao.ClientesDao;
import dtos.ClienteDto;
import entities.Cliente;
import mappers.Mapeador;
@Service("buscador")
public class ClientesServiceImpl implements ClientesService {
	ClientesDao clientesDao;
	Mapeador mapeador;
	
	public ClientesServiceImpl(ClientesDao clientesDao, Mapeador mapeador) {
		super();
		this.clientesDao = clientesDao;
		this.mapeador = mapeador;
	}

	@Override
	public boolean autenticar(String usuario, String password) {
		Cliente cliente=clientesDao.findByUsuario(usuario);
		return cliente!=null && cliente.getPassword().equals(password);
	}

	@Override
	public boolean registrar(ClienteDto cliente) {
		if(clientesDao.findByUsuario(cliente.getUsuario()) == null) {
			clientesDao.save(mapeador.clienteDtoToEntity(cliente));
			return true;
		}
		return false;
	}



}
