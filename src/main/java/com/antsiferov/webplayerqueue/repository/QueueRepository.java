package com.antsiferov.webplayerqueue.repository;

import com.antsiferov.webplayerqueue.entity.Queue;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QueueRepository extends CrudRepository<Queue, Long> {

    List<Queue> findAll();
}
