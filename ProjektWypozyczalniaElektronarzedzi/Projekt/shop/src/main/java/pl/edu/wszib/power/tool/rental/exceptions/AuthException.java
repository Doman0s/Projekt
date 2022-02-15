package pl.edu.wszib.power.tool.rental.exceptions;

public class AuthException extends RuntimeException{
    private String info;

    public AuthException(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
