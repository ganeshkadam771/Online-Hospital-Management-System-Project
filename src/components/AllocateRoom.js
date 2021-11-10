
import React from 'react';
export default class AllocateRoom extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            Room: [],
            status: "",
            rname: "",
            pid:"",
            rid:"",
            did: "",
            dateofadmission: "",
            Admission: {},
            success: false
        }
    }
    handlechange = (e) => {
        const nm = e.target.name;
        const val = e.target.value;
        this.setState({ [nm]: val })
    }
    searchData = (e) => {
        e.preventDefault();
        const reqOptions = {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                status: this.state.status

            })

        }
        // console.log(reqOptions.body);


        fetch("http://localhost:8080/getbyroom?status=" + this.state.status)

            .then(resp => resp.json())
            .then(data => {
                this.setState({ Room: data, success: true });
                alert(this.state.Room.length)
            });
    }

    submitData = (e) => {
       // e.preventDefault();
        const reqOptions = {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                
                pid: this.state.pid,
                rid: this.state.rid,
                did: this.state.did,
                dateofadmission: this.state.dateofadmission
            })
        }
       
        fetch("http://localhost:8080/admission", reqOptions)

            .then(resp => resp.json())
            .then(data => {
                this.setState({Admission : data, success: true });
                alert("Room Allocated Successfully.")
                //alert(this.state.)
            });
    }
    render() {
        return (
            <div>
                <h5> ROOM LIST </h5>
                <form>
                    {/*<div class="form group">*/}
                    <input type='text' name="status" placeholder="Enter Vaccant or Occupied" onChange={this.handlechange} /><br />
                   {/* <input type="submit" value="Search" onClick={this.searchData} />*/}
       
        <button type="submit" class="btn btn-primary" onClick={this.searchData}>SEARCH</button>
                </form>
                
                <table className="table table-bordered table-striped">
                    {
                        this.state.Room.map(
                            obj => {
                                return (
                                    <tr>
                                        <td>{obj.rid}</td>
                                        <td>{obj.rname}</td>
                                        <td>{obj.status}</td>
                                    </tr>
                                )
                            }
                        )
                    }
                </table>
                <br /><br />
{/*<div class="form-group form check">*/}
            <form class="form-inline">
                    <table  border="0" align="centre">
                        <tr>
                            <td> <h5>Enter Patient Id: </h5></td>
                            <td><input type="text" name="pid" placeholder="Enter patient Id" onChange={this.handlechange} /></td><td></td>
                            <td><h5> Select Room Number: </h5></td>
                            <td> <input type="text" name="rid" placeholder="Enter room number" onChange={this.handlechange} /></td><td></td>
                            <td><h5> Select Date: </h5></td>
                            <td> <input type="date" name="dateofadmission" placeholder="Select date" onChange={this.handlechange} /></td><td></td>
                            <td><h5> Select Doctor:</h5> </td>
                            <td> <input type="text" name="did" placeholder="Enter Doctor" onChange={this.handlechange} /></td><td></td>
                            <td><button type="button" class="btn btn-primary" onClick={this.submitData} >ALLOCATE</button></td>
                        </tr>
                    </table>
                </form>
                <br/>
            </div>
        )
    }
}
