import React, {useEffect, useState} from "react";
import {Link, Outlet} from "react-router-dom";
import "./Chat.css"
import axios from "axios";
import {ChatServiceClient} from "../../output/generated1/src/grpc/protos/chat1_pb_service";
import {ChatMessage, MessageRequest, MessageResponse} from "../../output/generated1/src/grpc/protos/chat1_pb";

function Chat(){

    const grpcCall = () => {

        // create our greeting object
        let chatMessage = new ChatMessage();
        chatMessage.setFrom('Anca')
        chatMessage.setMsg('Hello there!')
        chatMessage.setTime(new Date().toString())

        // prepare the greet request
        const request = new MessageRequest();
        request.setChatmessage(chatMessage);

        // create gRPC client that will call ou java server
        const client = new ChatServiceClient('http://localhost:9090')
            .sendMsg(request, {}, (err, response) => {
                console.log({err, response});
            });
    }

    return (
        <div>
            <button onClick={grpcCall}>Click</button>
        </div>
    );
}

export default Chat;