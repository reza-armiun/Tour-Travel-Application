package razarm.tosan.controller.servlet;

public enum MethodType {
    GET("GET"),
    PUT("PUT"),
    POST("POST"),
    DELETE("DELETE"),
    HEAD("HEAD");

    private String name;

    MethodType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



}
