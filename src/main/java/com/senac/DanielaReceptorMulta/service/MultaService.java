package com.senac.DanielaReceptorMulta.service;

import com.senac.DanielaReceptorMulta.entities.Multa;
import com.senac.DanielaReceptorMulta.exceptions.MultaNotFoundException;
import com.senac.DanielaReceptorMulta.repository.MultaRepository;
import jakarta.transaction.Transactional;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MultaService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final MultaRepository multaRepository;

    public MultaService(MultaRepository multaRepository) {
        this.multaRepository = multaRepository;
    }

    @Transactional
    public Multa createMulta(Multa multa) {
        multa = new Multa();
        rabbitTemplate.convertAndSend("remover-multa", multa);
        return multaRepository.save(multa);
    }

    public List<Multa> getAllMultas() {
        return multaRepository.getAllMultas();
    }

    public Multa getMultaById(int id) {
        return multaRepository.getMultaAtivaById(id).orElseThrow(()-> new MultaNotFoundException("Multa não encontrada"));
    }

    @Transactional
    public Multa updateMulta(int id, Multa multa) {
        multa = this.getMultaById(id);
        return multaRepository.save(multa);

    }

    public void deleteMulta(int id) {
        this.getMultaById(id);
        multaRepository.markAsDeleteMulta(id);
    }

    @RabbitListener(queues = "remover-multa")
    public void processarRemocao(int multaId) {
        System.out.println("Recebendo ID da multa para remoção: " + multaId);
        deleteMulta(multaId);
        System.out.println("Multa com ID " + multaId + " deletada com sucesso.");
    }


}