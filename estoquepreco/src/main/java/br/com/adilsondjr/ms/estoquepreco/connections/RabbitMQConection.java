package br.com.adilsondjr.ms.estoquepreco.connections;

import br.com.adilsondjr.ms.estoquepreco.utils.Constants;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RabbitMQConection {
    private AmqpAdmin amqpAdmin;

    public RabbitMQConection(AmqpAdmin amqpAdmin) {
        this.amqpAdmin = amqpAdmin;
    }

    private Queue queue(String queueName) {
        return new Queue(queueName, true, false, false);
    }

    private DirectExchange exchange() {
        return new DirectExchange(Constants.EXCHANGE_NAME);
    }

    private Binding related(Queue queue, DirectExchange exchange) {
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(),
                queue.getName(), null);
    }

    @PostConstruct
    private void addQueue() {
        Queue queueEstoque = this.queue(Constants.QUEUE_ESTOQUE);
        Queue queuePreco = this.queue(Constants.QUEUE_PRECO);

        DirectExchange exchange = this.exchange();

        Binding relatedEstoque = this.related(queueEstoque, exchange);
        Binding relatedPreco = this.related(queuePreco, exchange);

        this.amqpAdmin.declareQueue(queueEstoque);
        this.amqpAdmin.declareQueue(queuePreco);

        this.amqpAdmin.declareExchange(exchange);

        this.amqpAdmin.declareBinding(relatedEstoque);
        this.amqpAdmin.declareBinding(relatedPreco);
    }
}
