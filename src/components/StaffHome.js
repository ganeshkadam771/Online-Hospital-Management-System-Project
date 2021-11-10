import React from 'react';
import { BrowserRouter, Link, Route, Switch } from 'react-router-dom';
import RegisterPatient from './RegisterPatient';
import AllocateRoom from './AllocateRoom';
import mystore from './store';

class StaffHome extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            flag: false
        }
    }

    render() {
        mystore.subscribe(() => { this.setState({ flag: mystore.getState().loggedin }) })
        return (
            <div><h5>WELCOME HOSPITAL STAFF</h5>
            <BrowserRouter>
                
                    
                    <ul className="nav nav-tabs">
                        <li className="nav-item"><Link className="nav-link" to="/patientreg">Register Patient</Link></li>
                        <li className="nav-item"><Link className="nav-link" to="/roomallocate">Allocate Room</Link></li>
                    </ul>
                   
                    <div>
                        <Switch>
                            <Route path='/patientreg' component={RegisterPatient} />
                            <Route path='/roomallocate' component={AllocateRoom} />
                        </Switch>
                    </div>
               
            </BrowserRouter> 
            
           </div>
        )
    }
}
export default StaffHome;