import React, {useEffect} from "react";
import {Link, Outlet} from "react-router-dom";
import "./ChatPage.css"
import {ChatMessage, MessageRequest, Empty} from "../../../output/generated1/src/grpc/protos/chat1_pb";
import {useState} from "react";
import Chat from "../Chat";
import {ChatServiceClient} from "../../../output/generated1/src/grpc/protos/chat1_pb_service";

const client = new ChatServiceClient('http://localhost:8081');

export default function ChatPage(){

    const [user] = useState(JSON.parse(localStorage.getItem("user")));
    const [selectedAdminUsername] = useState(JSON.parse(localStorage.getItem("selectedAdmin")));
    const [msgList, setMsgList] = useState([]);
    const [pageLoaded, setPageLoaded] = useState(false);

    useEffect(() => {
        if(!pageLoaded){
            const request = new Empty();

            const chatStream = client.receiveMsg(request, {});
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

            setPageLoaded(true);
        }
    }, [])

    function sendMessage(message) {
        let chatMessage = new ChatMessage();
        chatMessage.setFrom(user.username)
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

    return (
        <div className="app">
            <div className="login-form">
                <h3>Chat with {selectedAdminUsername}</h3>
                <div className="chatpage">
                    <div className="chatpage-section">
                        <Chat msgList={msgList} sendMessage={sendMessage} />
                        <span>&nbsp;&nbsp;</span>
                        <nav>
                            <Link to="/AdminSelection">
                                <button className="go-back">Go back</button>
                            </Link>
                        </nav>
                        <Outlet />
                    </div>
                </div>
            </div>
        </div>
    );
}
