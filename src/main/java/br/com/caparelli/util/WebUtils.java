package br.com.caparelli.util;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;


public class WebUtils {

	private static final List<SelectItem> listaStatus = new LinkedList<SelectItem>();

	public static List<SelectItem> getListastatus() {
		return listaStatus;
	}

	@Deprecated
	public static void setObjectInSession(String name, Object object) {
		getSession().setAttribute(name, object);
	}

	public static Object getObjectFromSession(String name) {
		return (getSession().getAttribute(name));
	}

	public static void removeObjectFromSession(String name) {
		getSession().removeAttribute(name);
	}

	//-- Metodos uteis do JSF

	public static UIComponent findComponent(String id) {
		return facesInstance().getViewRoot().findComponent(id);
	}

	public static Application application() {
		return facesInstance().getApplication();
	}

	public static NavigationHandler navigation() {
		return application().getNavigationHandler();
	}

	public static FacesContext facesInstance() {
		return FacesContext.getCurrentInstance();
	}

	public static RequestContext primeContext() {
		return RequestContext.getCurrentInstance();
	}

	public static ExternalContext context() {
		return facesInstance().getExternalContext();
	}

	public static String getParameterFromRequest(String parameterName)
	{
		Map<String,String> map = context().getRequestParameterMap();
		return map.get(parameterName);
	}

	public static Integer getIntegerParameterFromRequest(String parameterName)
	{
		if(getParameterFromRequest(parameterName) != null)
			return Integer.valueOf(getParameterFromRequest(parameterName));

		return null;
	}

	public static Long getLongParameterFromRequest(String parameterName)
	{
		if(getParameterFromRequest(parameterName) != null)
			return Long.valueOf(getParameterFromRequest(parameterName));

		return null;
	}

	public static Boolean getBooleanParameterFromRequest(String parameterName)
	{
		if(getParameterFromRequest(parameterName) != null)
			return Boolean.valueOf(getParameterFromRequest(parameterName));

		return null;
	}

	public static Double getDoubleParameterFromRequest(String parameterName)
	{
		if(getParameterFromRequest(parameterName) != null)
			return Double.valueOf(getParameterFromRequest(parameterName));

		return null;
	}

	public static BigDecimal getBigDecimalParameterFromRequest(String parameterName)
	{
		if(getParameterFromRequest(parameterName) != null)
			return new BigDecimal(Double.valueOf(getParameterFromRequest(parameterName)));

		return null;
	}

	public static Date getDateTimeParameterFromRequest(String parameterName)
	{
		SimpleDateFormat sdf = new SimpleDateFormat();
	    sdf.setLenient(false);
	    String pattern = "dd/MM/yyyy HH:mm:ss";

	    try
	    {
	    	if(getParameterFromRequest(parameterName) != null)
	    	{
	    		sdf.applyPattern(pattern);
	    		return (sdf.parse(getParameterFromRequest(parameterName)));
	    	}
	    	else
	    	{
	    		return null;
	    	}
	    }
	    catch (Exception e)
	    {
	        return null;
	    }
	}

	public static Date getDateParameterFromRequest(String parameterName)
	{
		SimpleDateFormat sdf = new SimpleDateFormat();
	    sdf.setLenient(false);
	    String pattern = "dd/MM/yyyy";

	    try
	    {
	    	if(getParameterFromRequest(parameterName) != null)
	    	{
	    		sdf.applyPattern(pattern);
	    		return (sdf.parse(getParameterFromRequest(parameterName)));
	    	}
	    	else
	    	{
	    		return null;
	    	}
	    }
	    catch (Exception e)
	    {
	        return null;
	    }
	}

	public static void goTo(String origem, String destino) {
		navigation().handleNavigation(FacesContext.getCurrentInstance(), origem, destino);
	}

	public static HttpServletRequest getRequest(){
		return (HttpServletRequest) context().getRequest();
	}

	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) context().getResponse();
	}

	public static HttpSession getSession(){
		return (HttpSession) context().getSession(true);
	}

	public static String getProtocol() {
		String protocol = getRequest().getProtocol();
		return ((protocol == null) ? "http:" : protocol) + "//";
	}

	public static String getServerName() {
		return getRequest().getServerName();
	}

	public static Integer getServerPort() {
		return getRequest().getServerPort();
	}

	public static String getContextPath() {
		return getRequest().getContextPath();
	}

	/*public static String getURLSistema() {
		Integer porta   = getServerPort();
		String contextPath = context().getApplicationContextPath();
		return "http://" + getServerName() + ((porta != null && porta > 0) ? ":" + porta : "") + contextPath;
	}*/

	public static String getURLSistema(String sistema) {
		if(sistema.indexOf("/") != 0) sistema = "/" + sistema;
		Integer porta   = getServerPort();
		return "http://" + getServerName() + ((porta != null && porta > 0) ? ":" + porta : "") + sistema;
	}


	public static void writeResponseJson(String content) throws IOException {

		ExternalContext ctx = WebUtils.context();
        //seta o cabecalho do Json
		ctx.setResponseContentType("application/json");
        ctx.setResponseCharacterEncoding("UTF-8");
        //obtem o response writer
        Writer writer = ctx.getResponseOutputWriter();
        //escreve...
        writer.write(content);
        //fecha o response...
        facesInstance().responseComplete();
	}

	public static Date getStringAsDate(String value) throws Exception{
		//-- Formato de datas utilizado para as datas Inicial e final
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.parse(value);
	}

}
