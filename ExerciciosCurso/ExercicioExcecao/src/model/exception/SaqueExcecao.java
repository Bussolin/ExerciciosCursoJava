package model.exception;

public class SaqueExcecao extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public SaqueExcecao( String msg ){
        super(msg);
    }
}
