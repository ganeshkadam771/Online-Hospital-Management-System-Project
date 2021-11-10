import React from 'react';
class AssignedPatient extends React.Component
{

    constructor(props) {
        super(props)

        this.state = {
            Patient:[],
            pid:"",
            fname:"",
            lname:"",
            did:"",
            flag: false
        }

    }
    handlechange = (e) => {
        const nm = e.target.name;
        const val = e.target.value;
        this.setState({ [nm]: val })
    }


    componentDidMount=()=>{

        const reqOptions = {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            }
        }
        alert(JSON.parse(localStorage.getItem("loggedinput")).did);
        fetch("http://localhost:8080/getassinedpatient?did=" + JSON.parse(localStorage.getItem("loggedinput")).did)

        .then(resp => resp.json())
        .then(data => {
            this.setState({Patient : data, success: true });
            alert(this.state.Patient.length)
        });
    }

    searchData = (e) => {
        e.preventDefault();
        const reqOptions = {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            }
        }
       
        fetch("http://localhost:8080/getassinedpatient?did=" +this.state.did, reqOptions)

            .then(resp => resp.json())
            .then(data => {
                this.setState({Patient : data, success: true });
                //alert(this.state.)
            });
    }


    render() {
        return (
            <div>
                
                <table className="table table-bordered table-striped">
                    {
                        this.state.Patient.map(
                            obj => {
                                return (
                                    <tr>
                                        <td>{obj.pid}</td>
                                        <td>{obj.fname}</td>
                                        <td>{obj.lname}</td>
                                    </tr>
                                )
                            }
                        )
                    }
                </table>
              
                <br /><br />
                </div>
                )
                }
}
export default AssignedPatient;