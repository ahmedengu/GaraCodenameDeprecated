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
}