package com.antsiferov.webplayerqueue.services;

import com.antsiferov.webplayerqueue.entity.Queue;
import com.antsiferov.webplayerqueue.repository.QueueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QueueService {

    private QueueRepository queueRepository;

    public List<Queue> getCurrentQueue() {
        return queueRepository.findAll();
    }

    public void put(Queue queue) {
        queueRepository.save(queue);
    }

    public void skip() {
        Long id = queueRepository.findAll().get(0).getId();
        queueRepository.deleteById(id);
    }
}
