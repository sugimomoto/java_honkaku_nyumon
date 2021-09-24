package chapter_6_2_5;

import java.util.Arrays;

public class ApplicationException extends Exception {

    private String id;
    private Object[] params;
    
    public ApplicationException(String id, Object... params){
        super();
        this.id = id;
        this.params = Arrays.copyOf(params, params.length);
    }

    public ApplicationException(String id, Throwable cause, Object...params){
        super();
        this.id = id;
        this.params = Arrays.copyOf(params, params.length);
    }

    public String getId(){
        return id;
    }

    public Object[] getParams(){
        return Arrays.copyOf(params, params.length);
    }
}
