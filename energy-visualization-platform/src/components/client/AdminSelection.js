import React from "react";
import {Link, Outlet} from "react-router-dom";
import "./AdminSelection.css"
import {useEffect, useState} from "react";
import axios from "axios";

function AdminSelection(){

    const [, setIsSubmitted] = useState(false);
    const [admin, setAdmin] = useState({
        id: "",
        name: "",
        username: "",
        address: "",
        age: "",
        type: ""
    });
    const [user, setUser] = useState(JSON.parse(localStorage.getItem("user")));
    const [admins, setAdmins] = useState( [] );

    useEffect(() => {
        setUser(JSON.parse(localStorage.getItem("user")));

        axios
            .get('http://localhost:8080/person/admins', {
                params: {
                    username: user.username
                }
            })
            .then((response) => {
                if(response.data!==null && response.data.length > 0){
                    setAdmins(response.data);
                    setAdmin(response.data[0])
                    localStorage.setItem("selectedRecipient", JSON.stringify(response.data[0].username));
                }
            })
            .catch((error) => {
                console.log(error);
            });
    }, []);

    function handleSubmit(event) {
        event.preventDefault()
        // localStorage.setItem("client", JSON.stringify(client))
        setIsSubmitted(true)
    }

    const render = () => {
        if(admins!==null && admins.length > 0){
            return (
                <div>
                    <form onSubmit={handleSubmit} className="form-user">
                        <div className="input-container-col">
                            <label>Select an admin:</label>
                            <select className="select-device" onChange={event => {
                                for(let i = 0; i < admins.length; i++){
                                    if (event.target.value === admins.at(i).username){
                                        setAdmin(admins.at(i))
                                        localStorage.setItem("selectedRecipient", JSON.stringify(admins.at(i).username));
                                    }
                                }
                            }}>
                                {admins.map(({id, username}) => (
                                    <option key={id} value={username}>
                                        {username}
                                    </option>
                                ))}
                            </select>
                        </div>
                        <nav>
                            <Link to="/ChatPageClient">
                                <button className="users-button">Chat with {admin.username}</button>
                            </Link>
                        </nav>
                    </form>
                </div>
            );
        }
    };

    return (
        <div className="app">
            <div className="login-form">
                <h3>Chat with an admin</h3>
                <div className="container">
                    <main className="main">
                        {render()}
                    </main>
                </div>
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

export default AdminSelection;