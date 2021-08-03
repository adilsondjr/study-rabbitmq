package br.com.adilsondjr.ms.estoquepreco.controller;

import br.com.adilsondjr.ms.estoquepreco.dto.EstoqueDto;
import br.com.adilsondjr.ms.estoquepreco.service.RabbitmqService;
import br.com.adilsondjr.ms.estoquepreco.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private RabbitmqService rabbitmqService;

    @PutMapping
    private ResponseEntity updateEstoque(@RequestBody EstoqueDto estoqueDto) {
        this.rabbitmqService.sendMessage(Constants.QUEUE_ESTOQUE, estoqueDto);

        return new ResponseEntity(HttpStatus.OK);
    }
}
