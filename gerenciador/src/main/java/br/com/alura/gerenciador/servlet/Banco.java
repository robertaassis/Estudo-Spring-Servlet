package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Modelos
public class Banco {
	
	private static List<Empresa> lista = new ArrayList<Empresa>(); // lista de empresas
	private static Integer chaveSequencial=1;
	
//	static {
//		Empresa empresa = new Empresa();
//		empresa.setNome("Alura");
//	}
	
	public void adiciona(Empresa empresa) { // adiciona na lista essa empresa
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){ // devolve a lista
		return Banco.lista; // nao pode usar this pq é private static, tem que usar Banco que é o objeto
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) { // enquanto tiver um proximo elemento na lista de Empresa; percorre a lista
			Empresa emp = it.next(); // emp recebe o proximo elemento
			
			if(emp.getId()==id){ // se o id desse elemento for o id q eu quero deletar
				it.remove(); // remove ele da lista
			}
			
		}
		
		
	}

	public Empresa buscaEmpresaPorId(Integer id) { // devolve a empresa solicitada para edita-la
		for(Empresa empresa : lista) {
			if(empresa.getId()==id) return empresa;
		}
		return null;
	}

}
