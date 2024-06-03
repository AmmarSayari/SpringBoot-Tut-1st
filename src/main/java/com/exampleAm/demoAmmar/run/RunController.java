package com.exampleAm.demoAmmar.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }
    private final RunRepository runRepository;

    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("{id}")
    Run findById(@PathVariable Integer id){
        Optional<Run> run = runRepository.findById(id);
        if(run.isPresent()){
            return run.get();
        }
        throw new RunNotFoundException();
    }

    //create
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Run run){
        runRepository.create(run);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}")
    void update(@Valid @PathVariable Integer id, @RequestBody Run run){
        Optional<Run> existingRun = runRepository.findById(id);
        if(existingRun.isPresent()){
            runRepository.update(run, id);
        }else{
            throw new RunNotFoundException();
        }
    }

    //delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable Integer id){
        Optional<Run> existingRun = runRepository.findById(id);
        if(existingRun.isPresent()){
            runRepository.delete(id);
        }else{
            throw new RunNotFoundException();
        }
    }
}
