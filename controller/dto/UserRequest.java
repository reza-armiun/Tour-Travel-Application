package razarm.tosan.controller.dto;

public abstract class UserRequest {
    protected String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
