package br.com.fiap.gs2.gs2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




import br.com.fiap.gs2.gs2.dtos.PowerCreate;
import br.com.fiap.gs2.gs2.dtos.PowerResponse;
import br.com.fiap.gs2.gs2.dtos.PowerUpdate;
import br.com.fiap.gs2.gs2.mapper.PowerMapper;
import br.com.fiap.gs2.gs2.repository.PowerRepository;
import br.com.fiap.gs2.gs2.service.PowerService;
import br.com.fiap.gs2.gs2.views.PowerFullView;
import br.com.fiap.gs2.gs2.views.PowerSimpleView;
import br.com.fiap.gs2.gs2.views.PowerViewType;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/baterias")
@RequiredArgsConstructor
public class PowerController {    
    
    private final PowerService powerService = new PowerService();
    private final PowerMapper powerMapper = new PowerMapper();
    private final PowerRepository powerRepository = null;

    @GetMapping
    public ResponseEntity<List<PowerResponse>> list() {
        List<PowerResponse> dtos = powerService.list()
            .stream()
            .map(e -> powerMapper.toDto(e))
            .toList();
        
        return ResponseEntity.ok().body(dtos);
    }

    @PostMapping
    public ResponseEntity<PowerResponse> create(@RequestBody PowerCreate dto) {        

        return ResponseEntity
        		.status(HttpStatus.CREATED)
        		.body(
        			powerMapper.toDto(
        					powerService.save(powerMapper.toModel(dto)))
        			);
    }

    @PutMapping("{id}")
    public ResponseEntity<PowerResponse> update(
                        @PathVariable Long id, 
                        @RequestBody PowerUpdate dto) {
        if (! powerService.existsById(id)){
            throw new RuntimeException("Id inexistente");
        }                
        return ResponseEntity.ok()
        		.body(
        			powerMapper.toDto(
        				powerService.save(powerMapper.toModel(id, dto)))
        		);
    }
    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! powerService.existsById(id)){
        	throw new RuntimeException("Id inexistente");
        }

        powerService.delete(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<PowerResponse> findById(@PathVariable Long id) {    	
    	return ResponseEntity.ok()
    			.body(
    				powerService
    					.findById(id)
    					.map(e -> powerMapper.toDto(e))
    					.orElseThrow(() -> new RuntimeException("Id inexistente"))
    			);    	  		     
    }
    
    @GetMapping("/find")
    public  ResponseEntity<?> findByNome(
                @RequestParam String nome, 
                PowerViewType type) { 

        switch (type) {
            case FULL:
                return ResponseEntity.ok().body(powerRepository.findAllByNomeContains(nome, PowerFullView.class));                
            case SIMPLE:
                return ResponseEntity.ok().body(powerRepository.findAllByNomeContains(nome, PowerSimpleView.class));            
        }
        return ResponseEntity.noContent().build();
    }
}
