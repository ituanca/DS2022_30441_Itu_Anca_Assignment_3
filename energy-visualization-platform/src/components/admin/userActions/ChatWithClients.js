import React, {useEffect, useState} from "react";
import {Link, Outlet} from "react-router-dom";
import "./ChatWithClients.css"
import {ChatServiceClient} from "../../../output/generated1/src/grpc/protos/chat1_pb_service";
import {ChatMessage, Empty, MessageRequest} from "../../../output/generated1/src/grpc/protos/chat1_pb";
import ChatAdmin from "../../chat/ChatAdmin";

const client = new ChatServiceClient('http://localhost:8081');

export default function ChatWithClients(){

    const [user] = useState(JSON.parse(localStorage.getItem("user")));
    const [clients, setClients] = useState([]);
    const [msgList, setMsgList] = useState([]);

    useEffect(() => {
        const request = new Empty();

        const chatStream = client.receiveMsg(request, {});
        chatStream.on("data", (response) => {
            const from = response.getFrom()
            const to = response.getTo()
            const msg = response.getMsg()
            const time = response.getTime()
            console.log("from: " + from + " to: " + to + " msg: " + msg + " time: " + time)

            if (from === user.username) {
                setMsgList((oldArray) => [...oldArray, { from, to, msg, time, mine: true }]);
            } else if (to === user.username){
                setClients((oldArray) => [...oldArray, from ]);
                setMsgList((oldArray) => [...oldArray, { from, to, msg, time, mine: false }]);
            }
        })

        chatStream.on("status", function (status) {
            console.log(status.code, status.details, status.metadata);
        });

        chatStream.on("end", () => {
            console.log("Stream ended.");
        });

    }, []);

    function sendMessage(message, localRecipient) {
        let chatMessage = new ChatMessage();
        chatMessage.setFrom(user.username)
        chatMessage.setTo(localRecipient)
        chatMessage.setMsg(message)

        const now = new Date();
        const formattedDate =  now.getHours() + ":" + now.getMinutes() + ":" + now.getSeconds() + ", " +
            now.getFullYear() + '-' + (now.getMonth() + 1) + '-' + now.getDate();
        chatMessage.setTime(formattedDate)

        const request = new MessageRequest();
        request.setChatmessage(chatMessage);

        client
            .sendMsg(request, null, (err, response) => {
                console.log(response);
            });
    }

    console.log("clients " + clients)

    const render = () => (
        <form>
            <div className="container-multiple-cols">
                <div className="input-container-col">
                    {(clients.length === 0) ?
                        <label>You have no messages</label>
                    :
                        <div>
                            <label>You have messages from the following clients:</label>
                            {Array.from(new Set(clients)).map((item) => (
                                <li> {item} </li>
                            ))}
                        </div>
                    }

                </div>
            </div>
        </form>
    );

    return (
        <div>
            <div className="app">
                <div className="login-form">
                    <h3>Chat with clients</h3>
                    <span>&nbsp;&nbsp;</span>
                    <div className="container">
                        {render()}
                    </div>
                    <span>&nbsp;&nbsp;</span>
                    <nav>
                        <Link to="/AdminActions">
                            <button className="go-back">Go back</button>
                        </Link>
                    </nav>
                    <Outlet />
                </div>
            </div>

            { Array.from(new Set(clients)).length > 0 && msgList.length > 0 ?
                <div>
                    {Array.from(new Set(clients)).map((recipient) => (
                        <div className="app">
                            <div className="login-form">
                                <h3>Chat with {recipient}</h3>
                                <div className="chatpage">
                                    <div className="chatpage-section">
                                        <ChatAdmin msgList={msgList} sendMessage={sendMessage} client={recipient} />
                                        <span>&nbsp;&nbsp;</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
                : null
            }
        </div>

    );
}
