import React from "react";
import "./ChatClient.css"
import {useState} from "react";

export default function ChatClient({ msgList, sendMessage }) {

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
        <form onSubmit={handleSend}>
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
                        <input type="submit" value="Send"/>
                    </div>
                </div>
            </div>
        </form>

    );
}

function ChatCard({chat}) {
    return (
        <div className={chat.mine ? "chatcard chatcard-mine" : "chatcard chatcard-friend"}>
            <div className="chatcard-msg">
                {chat.msg}
            </div>
            <div className="chatcard-time">
                {chat.time}
            </div>
        </div>
    )
}
