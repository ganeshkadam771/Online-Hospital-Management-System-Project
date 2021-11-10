import React from "react";

export default class RegisterStaff extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            useremail: "",
            password: "",
            fname: "",
            lname: "",
            mobile: "",
            gender: "",
            user_type: "",
            user: {},
            success: false
        }
    }

    handleChange = (e) => {
        const nm = e.target.name;
        const val = e.target.value;
        this.setState({ [nm]: val });
    }

    submitData = (e) => {
        e.preventDefault();
        const reqOptions = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                useremail: this.state.useremail,
                password: this.state.password,
                fname: this.state.fname,
                lname: this.state.lname,
                mobile: this.state.mobile,
                gender: this.state.gender,
                user_type: this.state.user_type
            })
        }
        fetch("http://localhost:8080/staffregisteruser", reqOptions)
            .then(res => res.json())
            .then(data => this.setState({ user: data, success: true }));
    }
    render() {
        return (
            <div>
                <h5>HOSPITAL STAFF REGISTRATION</h5>
                <br />
                <form> 
                    
                        <table>

                            <tr>
                                <td >Enter First name : </td> <td><input type="text" name="fname" onChange={this.handleChange} /></td>
                            </tr>
                            <tr>
                                <td>Enter Last name : </td> <td><input type="text" name="lname" onChange={this.handleChange} /></td>
                            </tr>

                            <tr>
                                <td> Enter Mobile No. : </td><td> <input type="text" name="mobile" onChange={this.handleChange} /></td>
                            </tr>

                            <tr>
                                <td>Enter Emaid ID : </td><td> <input type="text" name="useremail" onChange={this.handleChange} /></td>
                            </tr>

                            <tr>
                                <td>Select Gender : </td><td> <input type="text" name="gender" onChange={this.handleChange} /></td>
                            </tr>

                            <tr>
                                <td>Select User Type : </td><td>  <input type="text" name="user_type" onChange={this.handleChange} /></td>
                            </tr>

                            <tr>
                                <td>Enter Passsword : </td><td><input type="text" name="password" onChange={this.handleChange} /></td>
                            </tr>
                       
                   
                   
                    {/* <input type="submit" value="Register" onClick={this.submitData}/>*/}
                   <tr>
                       <td></td>
                       <td> <button type="submit" class="btn btn-primary" onClick={this.submitData}>REGISTER</button></td>
                   </tr>
                    </table>
                </form>
                <p style={{ display: this.state.success ? 'block' : 'none' }}> User  {this.state.user.useremail}  registered successfully</p>
            <br/>
            </div>
        )
    }
}