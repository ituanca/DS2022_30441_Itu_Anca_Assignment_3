import React from "react";
import {Link, Outlet} from "react-router-dom";
import "./Chat.css"
import {ChatServiceClient} from "../../output/generated1/src/grpc/protos/chat1_pb_service";
import {ChatMessage, MessageRequest} from "../../output/generated1/src/grpc/protos/chat1_pb";
import {useState} from "react";

function Chat(){

    const [user] = useState(JSON.parse(localStorage.getItem("user")));
    const [selectedAdminUsername] = useState(JSON.parse(localStorage.getItem("selectedAdmin")));

    const grpcCall = () => {
        // create our ChatMessage object
        let chatMessage = new ChatMessage();
        chatMessage.setFrom(user.username)
        chatMessage.setMsg('Hello there ' + selectedAdminUsername + "!")
        chatMessage.setTime(new Date().toString())

        // prepare the message request
        const request = new MessageRequest();
        request.setChatmessage(chatMessage);

        // create gRPC client that will call our java server
        new ChatServiceClient('http://localhost:8081')
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
                <h3>Chat with {selectedAdminUsername}</h3>
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