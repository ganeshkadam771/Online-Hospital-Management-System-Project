import React from 'react';
class PrescribeTests extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            Treatement: [],
            tid: "",
            tname: "",
            success:false

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
                tid: this.state.tid,
                tname: this.state.tname})
        }
        // console.log(reqOptions.body);
        fetch("http://localhost:8080/getbytreatement")

            .then(resp => resp.json())
            .then(data => {
                this.setState({ Treatement: data,success: true });
                alert(this.state.Treatement.length)
            });
    }


    render() {
        return (
            <div>
                <h2> Treatment List </h2>
                <table className="table table-bordered table-striped">
                    {
                        this.state.Treatement.map(
                            obj => {
                                return (
                                    <tr>
                                        <td>{obj.tid}</td>
                                        <td>{obj.tname}</td>

                                    </tr>
                                )
                            }
                        )
                    }
                </table>
                <form>
                    <div class="form group">
                        <input type="text" name="pid" placeholder="Enter Patient ID" onChange={this.handlechange} />
                
                        <input type="text" name="tid" placeholder="Enter Treatment ID" onChange={this.handlechange} />
                        <br />
                        <br />
                    </div>
                    {/*<input type="submit" value="Add Treatment" onClick={this.submitData} />*/}
                    <button type="submit" class="btn btn-primary" onClick={this.searchData}>ADD TREATMENT</button>
                </form>
            </div>
        )
    }
}
export default PrescribeTests;