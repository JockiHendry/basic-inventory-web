package com.jocki.inventory.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@FacesConverter("localDateConverter")
public class LocalDateConverter implements Converter {
    
    private DateTimeFormatter formatter = DateTimeFormat.forPattern("dd-MM-YYYY");
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {        
        return LocalDate.parse(value, formatter);        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {        
        return formatter.print((LocalDate) value);
    }

}
