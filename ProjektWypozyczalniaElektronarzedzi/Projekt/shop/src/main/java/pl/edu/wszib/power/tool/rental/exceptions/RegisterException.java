package pl.edu.wszib.power.tool.rental.exceptions;

public class RegisterException extends RuntimeException{
    private String info;

    public RegisterException(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
