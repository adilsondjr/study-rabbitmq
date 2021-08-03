package br.com.adilsondjr.ms.estoquepreco.dto;

import br.com.adilsondjr.ms.estoquepreco.service.RabbitmqService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Data
public class PrecoDto implements Serializable {

    @Autowired
    private RabbitmqService rabbitmqService;

    private String codeProduct;
    private double preco;
}
