package pl.edu.wszib.power.tool.rental.exceptions;

public class LoginUsedException extends RuntimeException{
    private String info;

    public LoginUsedException(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
