package com.example.client.controller;

import com.example.client.network.NetClient;
import com.example.client.view.ClientView;

public class ClientController {

    public final ClientView view;
    public final NetClient netClient;

    public ClientController(ClientView view, NetClient netClient) {
        this.view = view;
        this.netClient = netClient;
    }

    public void runApp() throws Exception{
        netClient.connect(view.getUserData());
    }

}
