package br.com.syscam.rest;

import br.com.syscam.model.Movimentacao;
import br.com.syscam.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;



    @GetMapping("/{protocolo}")
    public @ResponseBody Optional<Movimentacao> buscar(@PathVariable("protocolo") int protocolo){
        return movimentacaoService.buscar(protocolo);
    }

    @GetMapping
    public @ResponseBody List<Movimentacao> listar(){
       return movimentacaoService.listar();
    }

    @GetMapping("/buscar")
    public @ResponseBody List<Movimentacao> buscarPorIntervalo(@RequestParam("inicio") String inicio,
                                                               @RequestParam("fim") String fim){
        try {
            return movimentacaoService.buscarPorIntervalo(inicio,fim);
        } catch (ParseException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }



}