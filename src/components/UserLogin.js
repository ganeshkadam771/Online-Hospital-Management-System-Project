import React from 'react';
import mystore from './store';

class UserLogin extends React.Component {


    constructor(props) {
        super(props)
        this.state = {
            user_id1: "",
            password: "",
            doctor: {},
            staff: {},
            user: {},
            loginerror: ""

        }
    }
    handlechange = (e) => {
        const nm = e.target.name;
        const val = e.target.value;
        this.setState({ [nm]: val })



    }
    submitData = (e) => {
        e.preventDefault();
        const reqOptions = {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                useremail: this.state.user_id1,
                password: this.state.password

            })

        }
        console.log(reqOptions.body);
        fetch("http://localhost:8080/chechlogin", reqOptions)
            .then(resp => resp.text())
            .then(data => {
                console.log(data);
                if (data.length != 0) {
                    const json = JSON.parse(data);
                    // console.log(json.did);
                    //if(json.user_type="Doctor")
                    //if(data=="Doctor")
                    if (json.did) {
                        this.setState({ doctor: json });
                        localStorage.setItem("loggedinput", JSON.stringify(this.state.doctor));

                        mystore.dispatch({ type: 'LOGGEDIN' });
                        alert("redirecting to doctor home");
                        this.props.history.push("/DoctorHome");
                    }
                    //else if(json.user_type=="Staff")
                    //else if(data=="Staff")
                    else if (json.sid) {
                        this.setState({ staff: json });
                        localStorage.setItem("loggedinput", JSON.stringify(this.state.staff));

                        mystore.dispatch({ type: 'LOGGEDIN' });
                        alert("redirecting to staff home");
                        this.props.history.push("/StaffHome");
                    }
                    else if (json.user_id) {
                        this.setState({ user: json });
                        localStorage.setItem("loggedinput", JSON.stringify(this.state.user));

                        mystore.dispatch({ type: 'LOGGEDIN' });
                        alert("redirecting to Admin home");
                        this.props.history.push("/AdminLogin");
                    }

                }
                else {
                    this.setState({ loginerror: "Wrong ID/Pwd" });
                }
            })
    }
    render() {
        return (
            <div>
                   
                <h2>LOGIN PAGE</h2>

                <br/>
                <br/>
                <form>
                    <div class="form group">
                    Enter UserId : <input type="text" name="user_id1" placeholder="Enter User ID/Email" onChange={this.handlechange} /><br /><br/>
                    Enter Password : <input type="password" name="password" placeholder="Enter Password" onChange={this.handlechange} /><br /><br/>
                    </div>
                    {/*<input type="submit" value="Login" onClick={this.submitData} />*/}
                    <button type="submit" class="btn btn-primary" onClick={this.submitData}>LOGIN</button>
                    <br/>
                </form>

                {/*<p>{this.state.staff.staff_id}</p>
                <p>{this.state.doctor.doctor_id}</p>*/}
                <p>{this.state.loginerror}</p>
                <br/>
            </div>
        );
    }
}
export default UserLogin;