package br.com.adilsondjr.ms.consumerestoque.consumer;

import dto.EstoqueDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import utils.Constants;

@Component
public class EstoqueConsumer {

    @RabbitListener(queues = Constants.QUEUE_ESTOQUE)
    private void consumidor(EstoqueDto estoqueDto){
        System.out.println(estoqueDto.getCodeProduct());
        System.out.println(estoqueDto.getQuantidade());
        System.out.println("------------------------------------");
    }
}