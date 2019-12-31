package com.pierre.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pierre.cursomc.domain.Categoria;
import com.pierre.cursomc.domain.Cidade;
import com.pierre.cursomc.domain.Cliente;
import com.pierre.cursomc.domain.Endereco;
import com.pierre.cursomc.domain.Estado;
import com.pierre.cursomc.domain.Produto;
import com.pierre.cursomc.domain.enums.TipoCliente;
import com.pierre.cursomc.repositories.CategoriaRepository;
import com.pierre.cursomc.repositories.CidadeRepository;
import com.pierre.cursomc.repositories.ClienteRepository;
import com.pierre.cursomc.repositories.EnderecoRepository;
import com.pierre.cursomc.repositories.EstadoRepository;
import com.pierre.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
    @Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1  = new Produto(null, "Computador", 2000.00);
		Produto p2  = new Produto(null, "Impressora", 800.00);
		Produto p3  = new Produto(null, "Mouse", 80.00);
		//associando as listas do produtos
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
				
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia",est1);
		Cidade c2 = new Cidade(null, "São Paulo",est2);
		Cidade c3 = new Cidade(null, "Campinas",est2);
		// creation object
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		// save
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "maria silva","maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
        cli1.getTelefone().addAll(Arrays.asList("27633323","93838393"));
        
        Endereco e1 = new Endereco(null,"Rua Flores","300","Ap 303","Jardim","38220834",cli1,c1);
        Endereco e2 = new Endereco(null,"Av Matos","105","sala 800","centro","38220834",cli1,c2);
        cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
        
        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(e1,e2));

		
	}

}
