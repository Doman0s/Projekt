package pl.edu.wszib.power.tool.rental.exceptions;

public class AddProductException extends RuntimeException{
    private String info;

    public AddProductException(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
