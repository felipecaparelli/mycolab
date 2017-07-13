package br.com.caparelli.converter;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import br.com.caparelli.bo.ColaboradorBO;
import br.com.caparelli.dto.DetalheColaboradorDTO;

/**
 * <b>Definicao</b>: Converter para a entidade Colaborador
 *
 * <br><h1>Projeto: MyColab JSF</h1><br>
 *
 * @author 	Felipe Caparelli
 * @date	12 de jul de 2017
 *
 */
@ManagedBean
@RequestScoped
public class ColaboradorConverter implements Converter {

	@EJB
	private ColaboradorBO colaboradorBO;

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
		if (modelValue == null) {
            return "";
        }

        if (modelValue instanceof DetalheColaboradorDTO) {
            return String.valueOf(((DetalheColaboradorDTO) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(modelValue + " n\u00e3o \u00e9 um DetalheColaboradorDTO"));
        }
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
		if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            return colaboradorBO.findById(Integer.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(submittedValue + " n\u00e3o \u00e9 um ID v\u00e1lido"));
        }
	}

}
