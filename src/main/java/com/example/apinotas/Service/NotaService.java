package com.example.apinotas.Service;


import com.example.apinotas.DTO.*;
import com.example.apinotas.Excepciones.IdNoEncontradoException;
import com.example.apinotas.Excepciones.TituloRepetidoException;
import com.example.apinotas.Repository.NotaRepository;
import com.example.apinotas.model.Nota;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.aspectj.weaver.ast.Not;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    private final NotaRepository repository;
    private final ModelMapper modelMapper;

    public NotaService(NotaRepository notaRepository,
                       ModelMapper modelMapper){
        this.repository=notaRepository;
        this.modelMapper=modelMapper;
    }

    public ResponseCreacionNotaDTO crearNota(RequestCreacionNotaDTO dto){
        if(repository.existsByTitle(dto.getTitle())){
            throw new TituloRepetidoException("ya existe una nota con este titulo");
        }
        else{
            Nota var_nota=modelMapper.map(dto,Nota.class);
            var_nota.setCreatedAt(LocalDateTime.now());
            Nota rpta=repository.save(var_nota);
            ResponseCreacionNotaDTO answer= modelMapper.map(rpta,ResponseCreacionNotaDTO.class);
            return answer;
        }

    }

    public List<ResponseListarNotasDTO> listarNotas(){
        List<ResponseListarNotasDTO> answer=new ArrayList<>();
        for(Nota elemento:repository.findAll()){
            ResponseListarNotasDTO var_nota=new ResponseListarNotasDTO();
            var_nota.setId(elemento.getId());
            var_nota.setTitle(elemento.getTitle());
            var_nota.setContent(elemento.getContent());
            answer.add(var_nota);
        }
        return answer;
    }

    public ResponseBusquedaId buscarPorId(Long id){
        Optional<Nota> optionalNota=repository.findById(id);
        if(optionalNota.isPresent()){
            ResponseBusquedaId answer=new ResponseBusquedaId();
            Nota var_answer=optionalNota.get();
            answer.setId(var_answer.getId());
            answer.setTitle(var_answer.getTitle());
            answer.setContent(var_answer.getContent());
            return answer;
        }
        else{
            throw new IdNoEncontradoException("id no encontradomijo");
        }
    }

    public Optional<ResponseBusquedaId> buscarPorId2(Long id){
        Optional<Nota> varNota=repository.findById(id);
        if(varNota.isPresent()){
            ResponseBusquedaId answer=new ResponseBusquedaId();
            Nota var_answer=varNota.get();
            answer.setId(var_answer.getId());
            answer.setTitle(var_answer.getTitle());
            answer.setContent(var_answer.getContent());
            return Optional.of(answer);
        }
        else {
            return Optional.empty();
        }
    }

    public void eliminarPorId(Long id){
        Optional<Nota> varNota=repository.findById(id);
        if(varNota.isPresent()){
            repository.deleteById(id);
        }
        else{
            throw new IdNoEncontradoException("no se pudo eliminar, id no encontrado");
        }
    }

    public Nota modificarNota(RequestModificarNotaDTO dto,Long id){
        Optional<Nota> var_optional = repository.findById(id);

        if(var_optional.isPresent()){
            Nota respuesta=var_optional.get();

            if(dto.getTitle()!=null && !dto.getTitle().isBlank()){
                respuesta.setTitle(dto.getTitle());


            }
            if(dto.getContent()!=null && !dto.getContent().isBlank()){
                respuesta.setContent(dto.getContent());


            }
            repository.save(respuesta);


            return respuesta;
        }

        else{
            throw new IdNoEncontradoException("id para modificacion no existe");
        }


    }










}
