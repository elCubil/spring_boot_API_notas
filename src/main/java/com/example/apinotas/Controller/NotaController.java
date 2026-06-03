package com.example.apinotas.Controller;


import com.example.apinotas.DTO.*;
import com.example.apinotas.Service.NotaService;
import com.example.apinotas.model.Nota;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nota")
public class NotaController {
    private final NotaService notaService;

    public NotaController(NotaService notaService){
        this.notaService=notaService;
    }

    @PostMapping
    public ResponseEntity<ResponseCreacionNotaDTO> crearNota(
            @Valid @RequestBody RequestCreacionNotaDTO dto){
        ResponseCreacionNotaDTO answer=notaService.crearNota(dto);
        return ResponseEntity.ok(answer);
    }

    @GetMapping
    public ResponseEntity<List<ResponseListarNotasDTO>> listarNotas(){
        List<ResponseListarNotasDTO> rpta=notaService.listarNotas();
        return ResponseEntity.ok(rpta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseBusquedaId> buscarPorId(@PathVariable Long id){
        ResponseBusquedaId rpta=notaService.buscarPorId(id);
        return ResponseEntity.ok(rpta);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id){
        notaService.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseModificarNotaDTO> actualizarNota(@PathVariable Long id,@RequestBody @Valid RequestModificarNotaDTO dto){
        Nota rpta=notaService.modificarNota(dto,id);
        ResponseModificarNotaDTO answer=new ResponseModificarNotaDTO();
        answer.setId(rpta.getId());
        answer.setTitle(rpta.getTitle());
        answer.setContent(rpta.getContent());
        return ResponseEntity.ok(answer);
    }







}
