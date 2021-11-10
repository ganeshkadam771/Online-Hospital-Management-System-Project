import React from "react";

export default class RegisterPatient extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            fname: "",
            lname: "",
            blood_group: "",
            email: "",
            mobile: "",
            address: "",
            gender: "",
            patient: {},
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

                fname: this.state.fname,
                lname: this.state.lname,
                blood_group: this.state.blood_group,
                email: this.state.email,
                mobile: this.state.mobile,
                address: this.state.address,
                gender: this.state.gender

            })
        }
        fetch("http://localhost:8080/pregister", reqOptions)
            .then(res => res.json())
            .then(data => this.setState({ user: data, success: true }));
    }
    render() {
        return (
            <div>
                <h5>PATIENT REGISTRATION</h5>
                <form >

                    <table>
                        <tr>
                            <td>Enter First name : </td> <td> <input type="text" name="fname" onChange={this.handleChange} /> </td>
                        </tr>
                        <tr>
                            <td>Enter Last name : </td> <td> <input type="text" name="lname" onChange={this.handleChange} /></td>
                        </tr>
                        <tr>
                            <td>Enter Blood Group : </td><td> <input type="text" name="blood_group" onChange={this.handleChange} /></td>
                        </tr>
                        <tr>
                            <td>Enter Emaid ID : </td><td> <input type="text" name="email" onChange={this.handleChange} /></td>
                        </tr>
                        <tr>
                            <td>Enter Mobile No.: </td><td><input type="text" name="mobile" onChange={this.handleChange} /></td>
                        </tr>
                        <tr>
                            <td>Enter Adress : </td> <td> <input type="text" name="address" onChange={this.handleChange} /></td>
                        </tr>
                        <tr>
                            <td>Select Gender : </td><td>  <input type="text" name="gender" onChange={this.handleChange} /></td>
                        </tr>
                        <tr>
                            {/*<input type="submit" value="Register" onClick={this.submitData}/>*/}
                            <td></td>
                            <td>
                                <button type="submit" class="btn btn-primary" onClick={this.submitData}>REGISTER</button></td>
                        </tr>
                    </table>
                </form>
                <p style={{ display: this.state.success ? 'block' : 'none' }}> Patient registered successfully</p>
                <br/>
            </div>
        )
    }
}