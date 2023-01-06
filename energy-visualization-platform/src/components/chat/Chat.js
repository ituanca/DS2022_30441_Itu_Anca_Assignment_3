import React, {useEffect, useState} from "react";
import {Link, Outlet} from "react-router-dom";
import "./Chat.css"
import {ChatServiceClient} from "../../output/generated1/src/grpc/protos/chat1_pb_service";
import {ChatMessage, MessageRequest, MessageResponse} from "../../output/generated1/src/grpc/protos/chat1_pb";

function Chat(){

    const grpcCall = () => {

        // create our object
        let chatMessage = new ChatMessage();
        chatMessage.setFrom('Anca')
        chatMessage.setMsg('Hello there!')
        chatMessage.setTime(new Date().toString())

        // prepare the request
        const request = new MessageRequest();
        request.setChatmessage(chatMessage);

        // create gRPC client that will call ou java server
        const client = new ChatServiceClient('http://localhost:9090')
            .sendMsg(request, {}, (err, response) => {
                console.log({err, response});
            });
    }

    const render = () => {
        return (
            <div>
                <button className="users-button" onClick={grpcCall}>Click</button>
            </div>
        );
    };

    return (
        <div className="app">
            <div className="login-form">
                <h3>Chat with an admin</h3>
                {render()}
                <span>&nbsp;&nbsp;</span>
                <nav>
                    <Link to="/ClientActions">
                        <button className="go-back">Go back</button>
                    </Link>
                </nav>
                <Outlet />
            </div>
        </div>
    );
}

export default Chat;