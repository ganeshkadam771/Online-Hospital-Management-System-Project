import DoctorHome from './DoctorHome';
import StaffHome from './StaffHome';
import Register from './Register';
import RegisterStaff from './RegisterStaff';
import React from 'react';
import { BrowserRouter, Link, Route, Switch } from 'react-router-dom';
//import Home from "./components";
import mystore from './store';
class AdminLogin extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            flag: false
        }
    }
    render() {
        mystore.subscribe(() => { this.setState({ flag: mystore.getState().loggedin }) })

        return (
            <div>
                <h2>WELCOME ADMIN</h2>

                <BrowserRouter>                 

                    <ul className="nav nav-tabs">
                        <li className="nav-item"><Link className="nav-link" to="/reg">Doctor Register</Link></li>
                        
                        <li className="nav-item"><Link className="nav-link" to="/sreg">Staff Register</Link></li>

                    </ul>
                    
                    <div>
                        <Switch>
                            <Route path='/reg' component={Register} />
                            <Route path='/sreg' component={RegisterStaff} />
                        </Switch>
                    </div>

                    <Route path="/DoctorHome" component={DoctorHome} />
                    <Route path="/StaffHome" component={StaffHome} />

                </BrowserRouter>
            </div>

        )
    }
}
export default AdminLogin;