import React from 'react';
import AssignedPatient from './AssignedPatient';
import PrescribeTests from './PrescribeTests';
import mystore from './store';
import { BrowserRouter, Link, Route, Switch } from 'react-router-dom';
class DoctorHome extends React.Component
{

    constructor(props) {
        super(props)
        this.state = {
            flag: false,
            user:"",
            fname:"",
            did:""
        }
    }

    render() {
        mystore.subscribe(() => { this.setState({ flag: mystore.getState().loggedin }) })
        
        return (
            <div><h5>WELCOME DOCTOR</h5> {/*{JSON.parse(localStorage.getItem("loggedin")).fname}</h1>*/}
            <BrowserRouter>
                
                    
                    <ul className="nav nav-tabs">
                        <li className="nav-item"><Link className="nav-link" to="/assignedpatient">Search Assigned Patient</Link></li>
                        <li className="nav-item"><Link className="nav-link" to="/prescribetreatment">Add Treatment</Link></li>
                    </ul>
                   
                    <div>
                        <Switch>
                            <Route path='/assignedpatient' component={AssignedPatient} />
                            <Route path='/prescribetreatment' component={PrescribeTests} />
                        </Switch>
                        
                    </div>
                    
            </BrowserRouter> 
            
           </div>
        )
    }
}
export default DoctorHome;