/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciotienda;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author Luis Gil Barrios
 */
@WebService(serviceName = "serviciotienda")
@Stateless()
public class serviciotienda {

    private final static String QUEUE_NAME = "hello";
    /**
     * Web service operation
     */
    @WebMethod(operationName = "hacerpedido")
    public String hacerpedido(@WebParam(name = "producto") String producto, @WebParam(name = "cantidad") String cantidad) throws IOException, TimeoutException {
        //TODO write your implementation code here:}
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();Channel channel = connection.createChannel()) 
        {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = producto + " - "+cantidad;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        }
    
        
        
        String respuesta = "Pedido almacenado";
        return respuesta;
    }
}
