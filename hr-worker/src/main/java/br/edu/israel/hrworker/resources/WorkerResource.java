package br.edu.israel.hrworker.resources;

import br.edu.israel.hrworker.entities.Worker;
import br.edu.israel.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static final Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private WorkerRepository repository;

    @Autowired
    private Environment env;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workerList = repository.findAll();
        return ResponseEntity.ok(workerList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        logger.info("PORT: {}" , env.getProperty("local.server.port"));
        var worker = repository.findById(id);
        return ResponseEntity.ok(worker.get());
    }


}
