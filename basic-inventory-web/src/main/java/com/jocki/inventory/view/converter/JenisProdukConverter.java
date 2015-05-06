package com.jocki.inventory.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.jocki.inventory.domain.DomainClass;
import com.jocki.inventory.repository.JenisProdukRepository;

@Component
public class JenisProdukConverter implements Converter {

    @Inject
    private JenisProdukRepository jenisProdukRepository;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            return jenisProdukRepository.findOne(Long.valueOf(value));
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((DomainClass) value).getId());
    }


}
