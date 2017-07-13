package br.com.caparelli.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;


public class MessageUtils {

	//base-name do resource-bundle configurado no faces-config.xml
	private static final String MSG_FILE = "lang.msgs";

	private static final String INFO_TITLE = "Info:";
	private static final String WARN_TITLE = "Alerta:";
	private static final String ERROR_TITLE = "Erro:";
	private static final String FATAL_TITLE = "Fatal:";

	private static ResourceBundle msgs;

	/* i18n */

	public static void infoI18n(String messageKey) {
        addMessage(FacesMessage.SEVERITY_INFO, INFO_TITLE, msg(messageKey));
    }

    public static void warnI18n(String messageKey) {
    	addMessage(FacesMessage.SEVERITY_WARN, WARN_TITLE, msg(messageKey));
    }

    public static void errorI18n(String messageKey) {
    	addMessage(FacesMessage.SEVERITY_ERROR, ERROR_TITLE, msg(messageKey));
    }

	/* jsf */

    public static void info(String message) {
        addMessage(FacesMessage.SEVERITY_INFO, INFO_TITLE, message);
    }

    public static void warn(String message) {
    	addMessage(FacesMessage.SEVERITY_WARN, WARN_TITLE, message);
    }

    public static void error(String message) {
    	addMessage(FacesMessage.SEVERITY_ERROR, ERROR_TITLE, message);
    }

    public static void fatal(String message) {
    	addMessage(FacesMessage.SEVERITY_FATAL, FATAL_TITLE, message);
    }

    public static void info(String title, String message) {
    	addMessage(FacesMessage.SEVERITY_INFO, title, message);
    }

    public static void warn(String title, String message) {
    	addMessage(FacesMessage.SEVERITY_WARN, title, message);
    }

    public static void error(String title, String message) {
   		addMessage(FacesMessage.SEVERITY_ERROR, title, message);
    }

    public static void fatal(String title, String message) {
    	addMessage(FacesMessage.SEVERITY_FATAL, title, message);
    }

	private static void addMessage(Severity severity, String type, String summary) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, type, summary));
	}

	/* primefaces */

	public static void dialogInfo(String message) {
		dialog(FacesMessage.SEVERITY_INFO, INFO_TITLE, message);
    }

    public static void dialogWarn(String message) {
    	dialog(FacesMessage.SEVERITY_WARN, WARN_TITLE, message);
    }

    public static void dialogError(String message) {
    	dialog(FacesMessage.SEVERITY_ERROR, ERROR_TITLE, message);
    }

    public static void dialogFatal(String message) {
    	dialog(FacesMessage.SEVERITY_FATAL, FATAL_TITLE, message);
    }

    public static void dialog(Severity severity, String title, String text) {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(severity, title, text));
    }

	public static String msg(String key) {
		return msg(key, new String[]{});
	}

	public static String msg(String key, String param) {

		loadMsgResourceBundle();

		if(param == null || param.isEmpty()) return msgs.getString(key);

		MessageFormat   messageFormat = new MessageFormat(msgs.getString(key));
		String separator = ",";

		if(!param.isEmpty() && param.contains(separator)){

			String[] params = param.split(separator);

			for (int i = 0; i < params.length; i++) {
				try {

					String s = msgs.getString(params[i]);
					params[i] = s;

				} catch (Exception e) {
					//mantem o que o desenvolvedor escreveu
				}
			}

			return messageFormat.format(params);

		} else {
			return messageFormat.format(new String[] {param});
		}
	}

	public static String msg(String key, String[] params) {

		loadMsgResourceBundle();

		if(params == null || params.length == 0) return msgs.getString(key);

		for (int i = 0; i < params.length; i++) {
			try {

				String s = msgs.getString(params[i]);
				params[i] = s;

			} catch (Exception e) {
				//mantem o que o desenvolvedor escreveu
			}
		}

		return new MessageFormat(msgs.getString(key)).format(params);
	}

	private static void loadMsgResourceBundle() {
		if(msgs == null) msgs = ResourceBundle.getBundle(MSG_FILE);
	}
}
