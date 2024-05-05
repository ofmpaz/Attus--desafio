    package com.desafioattus.service;

    import com.desafioattus.mapper.PessoaMapper;
    import com.desafioattus.model.Endereco;
    import com.desafioattus.model.Pessoa;
    import com.desafioattus.model.dto.EnderecoDTO;
    import com.desafioattus.model.dto.PessoaDTO;
    import com.desafioattus.repository.EnderecoRepository;
    import com.desafioattus.repository.PessoaRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    import java.util.List;

    import static com.desafioattus.mapper.PessoaMapper.enderecoMapper;


    @Service
    public class PessoaService {

        @Autowired
        PessoaRepository pessoaRepository;

        @Autowired
        PessoaMapper pessoaMapper;

        @Autowired
        EnderecoRepository enderecoRepository;

        @Autowired
        EnderecoService enderecoService;

        public PessoaDTO adicionarPessoa(PessoaDTO pessoaDTO) {
            Pessoa pessoa = pessoaMapper.paraPessoa(pessoaDTO);
            Pessoa registraPessoa = pessoaRepository.save(pessoa);
            PessoaDTO registrarPessoaDTO = pessoaMapper.paraPessoaDTO(registraPessoa);
            return registrarPessoaDTO;
        }

        public List<PessoaDTO> consultarPessoaPorNome(String nome) {
            return pessoaRepository.findDByNome(nome);
        }

        public PessoaDTO atualizarPessoa(String nome, PessoaDTO pessoaDTO) {
            List<Pessoa> pessoas = pessoaRepository.findByNome(nome);

            if (pessoas.isEmpty()) {
                throw new RuntimeException("Nenhuma pessoa encontrada com o nome: " + nome);
            }

            Pessoa pessoa = pessoas.get(0);
            pessoa.setNome(pessoaDTO.getNome());
            pessoa.setDataNascimento(pessoaDTO.getDataNascimento());

            Pessoa pessoaAtualizada = pessoaRepository.save(pessoa);
            return pessoaMapper.paraPessoaDTO(pessoaAtualizada);
        }

        public List<Pessoa> buscarTodasPessoas(){
            return pessoaRepository.findAll();
        }


    }


