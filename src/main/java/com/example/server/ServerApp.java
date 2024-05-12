package com.example.server;

import com.example.server.network.NetServer;
import com.example.utils.Constants;

public class ServerApp {

    public static void main(String[] args) throws Exception{
        new NetServer(Constants.PORT).run();
    }

}
