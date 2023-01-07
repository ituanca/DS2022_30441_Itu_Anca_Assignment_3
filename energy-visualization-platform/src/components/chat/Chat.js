import React from "react";
import "./Chat.css"
import {useState} from "react";

export default function Chat({ msgList, sendMessage }) {

    const [message, setMessage] = useState("");

    function handleSend() {
        sendMessage(message);
        setMessage("");
    }

    const handleTextareaInput = event => {
        const value = event.target.value;
        setMessage(value);
    }

    return (
        <div className="chat">
            <div className="chat-list">
                {msgList.map((chat, i) => (
                    <ChatCard chat={chat} key={i} />
                ))}
            </div>
            <div className="chat-input">
                <div style={{flex: "3 1 90%"}}>
                    <textarea
                        value={message}
                        name="message" required
                        onChange={handleTextareaInput}
                        id="message"/>
                </div>
                <div
                    style={{
                        padding: "5px",
                        marginLeft: "5px",
                        display: "flex",
                        alignItems: "center",
                        justifyContent: "flex-end",
                    }}
                >
                    <button onClick={handleSend}>Send</button>
                </div>
            </div>
        </div>
    );
}

function ChatCard({chat}) {
    return (
        <div>
            <div className={chat.mine ? "chatcard chatcard-mine" : "chatcard chatcard-friend"}>
                <div className="chatcard-msg">
                    <span>{chat.msg}</span>
                </div>
                <div className="chatcard-time">
                    <span>{chat.time}</span>
                </div>
            </div>
        </div>
    )
}
