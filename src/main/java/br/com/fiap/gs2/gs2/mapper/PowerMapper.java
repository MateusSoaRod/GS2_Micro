package br.com.fiap.gs2.gs2.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import br.com.fiap.gs2.gs2.dtos.PowerCreate;
import br.com.fiap.gs2.gs2.dtos.PowerResponse;
import br.com.fiap.gs2.gs2.dtos.PowerUpdate;
import br.com.fiap.gs2.gs2.model.Power;

@Component
public class PowerMapper {
    @Autowired
    private ModelMapper modelMapper;

    public PowerResponse toDto(Power power){
        return modelMapper.map(power, PowerResponse.class);
    }

    public Power toModel(PowerCreate dto) {
        return modelMapper.map(dto, Power.class);
    }

    public Power toModel(Long id, PowerUpdate dto) {
        Power result = modelMapper.map(dto, Power.class);
        result.setId(id);
        return result;
    } 
}
