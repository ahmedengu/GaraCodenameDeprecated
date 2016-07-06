package com.g_ara.gara;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;

public class RequestsHandler {
    public RequestsHandler() {
    }

    public static void updateMemberLocationAsync(String id, double latitude, double longitude, String token) {
        ConnectionRequest request = new ConnectionRequest(RESTLinks.MEMBER + "/" + id, true);
        request.setHttpMethod("PUT");
        request.addArgument("longitude", String.valueOf(longitude));
        request.addArgument("latitude", String.valueOf(latitude));
        request.addArgument("token", token);
        request.setFailSilently(true);
        NetworkManager.getInstance().addToQueue(request);
    }

    public static ConnectionRequest loginAsync(String username, String password) {
        ConnectionRequest request = new ConnectionRequest(RESTLinks.LOGIN, true);

        request.addArgument("username", username);
        request.addArgument("password", password);

        request.setFailSilently(true);
        NetworkManager.getInstance().addToQueueAndWait(request);
        return request;
    }

    public static ConnectionRequest registerSync(String username, String name, String password, String phone, String email) {
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

    public static ConnectionRequest addUniversitySync(String name, String emailFormat, String url) {
        ConnectionRequest request = new ConnectionRequest(RESTLinks.UNIVERSITY, true);
        request.addArgument("name", name);
        request.addArgument("emailformat", emailFormat);
        request.addArgument("url", url);
        request.setFailSilently(true);
        request.setReadResponseForErrors(true);
        NetworkManager.getInstance().addToQueueAndWait(request);
        return request;
    }
}