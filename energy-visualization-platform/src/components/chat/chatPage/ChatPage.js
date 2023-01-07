import React, {useEffect} from "react";
import {Link, Outlet} from "react-router-dom";
import "./ChatPage.css"
import {ChatMessage, MessageRequest, Empty} from "../../../output/generated1/src/grpc/protos/chat1_pb";
import {useState} from "react";
import Chat from "../Chat";
import {ChatServiceClient} from "../../../output/generated1/src/grpc/protos/chat1_pb_service";

export default function ChatPage(){

    const [user] = useState(JSON.parse(localStorage.getItem("user")));
    const [selectedAdminUsername] = useState(JSON.parse(localStorage.getItem("selectedAdmin")));
    const [msgList, setMsgList] = useState([]);

    // const grpcSendMessage = () => {
    //     let chatMessage = new ChatMessage();
    //     chatMessage.setFrom(user.username)
    //     chatMessage.setMsg('Hello there ' + selectedAdminUsername + "!")
    //     chatMessage.setTime(new Date().toString())
    //
    //     const request = new MessageRequest();
    //     request.setChatmessage(chatMessage);
    //
    //     // create gRPC client that will call our java server
    //     client.sendMsg(request, {}, (err, response) => {
    //         console.log({err, response});
    //     });
    // }

    useEffect(() => {
        const request = new Empty();

        const chatStream = new ChatServiceClient('http://localhost:8081').receiveMsg(request, {});
        chatStream.on("data", (response) => {
            const from = response.getFrom()
            const msg = response.getMsg()
            const time = response.getTime()
            console.log("from: " + from + " msg: " + msg + " time: " + time)

            if (from === user.username) {
                setMsgList((oldArray) => [...oldArray, { from, msg, time, mine: true },]);
            } else {
                setMsgList((oldArray) => [...oldArray, { from, msg, time, mine: false }]);
            }
        })

        chatStream.on("status", function (status) {
            console.log(status.code, status.details, status.metadata);
        });

        chatStream.on("end", () => {
            console.log("Stream ended.");
        });

        console.log("client in receive: " + chatStream)
    })

    function sendMessage(message) {
        let chatMessage = new ChatMessage();
        chatMessage.setFrom(user.username)
        chatMessage.setMsg(message)
        chatMessage.setTime(new Date().toString())

        const request = new MessageRequest();
        request.setChatmessage(chatMessage);

        new ChatServiceClient('http://localhost:8081')
            .sendMsg(request, null, (err, response) => {
                console.log(response);
            });
    }

    // const render = () => {
    //     return (
    //         <div>
    //             <button className="users-button" onClick={grpcSendMessage}>Send message</button>
    //             <button className="users-button" onClick={grpcReceiveMessage}>Receive message</button>
    //         </div>
    //     );
    // };

    // return (
    //     <div className="app">
    //         <div className="login-form">
    //             <h3>Chat with {selectedAdminUsername}</h3>
    //             {render()}
    //             <span>&nbsp;&nbsp;</span>
    //             <nav>
    //                 <Link to="/ClientActions">
    //                     <button className="go-back">Go back</button>
    //                 </Link>
    //             </nav>
    //             <Outlet />
    //         </div>
    //     </div>
    // );

    return (
        <div className="app">
            <div className="login-form">
                <h3>Chat with {selectedAdminUsername}</h3>
                <div className="chatpage">
                    <div className="chatpage-section">
                        <Chat msgList={msgList} sendMessage={sendMessage} />
                    </div>
                </div>
                {/*{render()}*/}
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
