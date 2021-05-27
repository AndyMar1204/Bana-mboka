package com.andy.bana_mboka.forms;

/**
 *
 * @author Ir Andy
 */


public class FormException extends Exception{

    public FormException(String string) {
        super(string);
    }

    public FormException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public FormException(Throwable thrwbl) {
        super(thrwbl);
    }
    
}
