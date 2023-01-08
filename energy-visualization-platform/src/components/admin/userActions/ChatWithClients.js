import React, {useEffect, useState} from "react";
import {Link, Outlet} from "react-router-dom";
import "./ChatWithClients.css"
import {ChatServiceClient} from "../../../output/generated1/src/grpc/protos/chat1_pb_service";
import {Empty} from "../../../output/generated1/src/grpc/protos/chat1_pb";

const client = new ChatServiceClient('http://localhost:8081');

export default function ChatWithClients(){

    const [user] = useState(JSON.parse(localStorage.getItem("user")));
    const [isSelected, setIsSelected] = useState(false);
    const [selectedClient, setSelectedClient] = useState("");
    const [clients, setClients] = useState([]);
    const [clientsPopulated, setClientsPopulated] = useState(false);

    useEffect(() => {
        const request = new Empty();

        const chatStream = client.receiveMsg(request, {});
        chatStream.on("data", (response) => {
            const from = response.getFrom()
            const to = response.getTo()
            const msg = response.getMsg()
            const time = response.getTime()
            console.log("from: " + from + " to: " + to + " msg: " + msg + " time: " + time)

            if (to === user.username) {
                setClients((oldArray) => [...oldArray, { from } ]);
                if(selectedClient === ""){
                    setSelectedClient(from)
                    localStorage.setItem("selectedRecipient", JSON.stringify(from));
                }
            }
        })

        chatStream.on("status", function (status) {
            console.log(status.code, status.details, status.metadata);
        });

        chatStream.on("end", () => {
            console.log("Stream ended.");
        });

        setClients(Array.from(new Set(clients)))

        setClientsPopulated(true);
    }, []);

    const render = () => (
        <form>
            <div className="container-multiple-cols">
                <div className="input-container-col">
                    <label>You have messages from the following clients:</label>
                    <select className="select-user" onChange={event => {
                        for (let i = 0; i < clients.length; i++) {
                            if (event.target.value === clients.at(i).from) {
                                setSelectedClient(clients.at(i).from)
                                localStorage.setItem("selectedRecipient", JSON.stringify(clients.at(i).from));
                            }
                        }
                        setIsSelected(true);
                    }}>
                        {clients.map(({from}) => (
                            <option value={from}>
                                {from}
                            </option>
                        ))}
                    </select>
                </div>
                <div  style={{
                    marginLeft: "30px",
                    display: "flex",
                    justifyContent: "flex-end",
                }} className="input-container-col">
                    <nav>
                        <Link to="/ChatPage">
                            <button className="users-button">Chat with {selectedClient}</button>
                        </Link>
                    </nav>
                </div>
            </div>
        </form>
    );

    return (
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
    );
}
