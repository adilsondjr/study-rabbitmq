package br.com.adilsondjr.ms.estoquepreco.controller;

import br.com.adilsondjr.ms.estoquepreco.service.RabbitmqService;
import dto.PrecoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.Constants;

@RestController
@RequestMapping("/preco")
public class PrecoController {
    @Autowired
    private RabbitmqService rabbitmqService;

    @PutMapping
    private ResponseEntity updateEstoque(@RequestBody PrecoDto precoDto) {
        this.rabbitmqService.sendMessage(Constants.QUEUE_PRECO, precoDto);

        return new ResponseEntity(HttpStatus.OK);
    }
}
