package com.example.client;

import com.example.client.controller.ClientController;
import com.example.client.network.NetClient;
import com.example.client.view.ClientView;
import com.example.utils.Constants;

public class ClientApp {

    public static void main(String[] args) throws Exception{
        ClientView view = new ClientView();
        NetClient netClient = new NetClient(
                Constants.HOST,
                Constants.PORT
        );

        new ClientController(view, netClient).runApp();
    }

}
