package com.danielqueiroz.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.danielqueiroz.api.exception.PessoaInexistenteOuInativaException;
import com.danielqueiroz.api.model.Lancamento;
import com.danielqueiroz.api.model.Pessoa;
import com.danielqueiroz.api.repository.LancamentoRepository;
import com.danielqueiroz.api.repository.filter.LancamentoFilter;
import com.danielqueiroz.api.repository.projection.ResumoLancamento;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private PessoaService pessoaService;
	
	public Page<Lancamento> listarLancamentos(LancamentoFilter lancamentoFilter, Pageable pageable){
		return lancamentoRepository.filtrar(lancamentoFilter, pageable);
	}
	
	public Optional<Lancamento> buscarLancamentoPeloCodigo(Long codigo) {
		return lancamentoRepository.findById(codigo);
	}

	public Lancamento salvar(Lancamento lancamento) {
		Optional<Pessoa> pessoa = pessoaService.buscarPessoaPeloCodigo(lancamento.getPessoa().getCodigo());
		if (!pessoa.isPresent() || pessoa.get().isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		
		return lancamentoRepository.save(lancamento);
	}

	public void deletarPorId(Long codigo) {
		lancamentoRepository.deleteById(codigo);
	}

	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable) {
		return lancamentoRepository.resumir(lancamentoFilter, pageable);
	}

}
