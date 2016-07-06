package com.g_ara.gara;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;

public class RequestsHandler {
    public RequestsHandler() {
    }

    public ConnectionRequest loginAsync(String username, String password) {
        ConnectionRequest request = new ConnectionRequest(RESTLinks.LOGIN, true);

        request.addArgument("username", username);
        request.addArgument("password", password);

        request.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(request);
        return request;
    }

    public ConnectionRequest registerSync(String username, String name, String password, String phone, String email) {
        ConnectionRequest request = new ConnectionRequest(RESTLinks.REGISTER, true);
        request.addArgument("username", username);
        request.addArgument("password", password);
        request.addArgument("name", name);
        request.addArgument("phonenumber", phone);
        request.addArgument("studentemail", email);
        request.setFailSilently(true);
        request.setReadResponseForErrors(true);
        NetworkManager.getInstance().addToQueueAndWait(request);
        return request;
    }
}