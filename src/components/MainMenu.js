import React from "react";
import { BrowserRouter, Link, Route, Switch } from "react-router-dom";
import DoctorHome from "./DoctorHome";
import UserLogin from "./UserLogin";
import Register from "./Register";
import mystore from "./store";
import RegisterStaff from "./RegisterStaff";
import StaffHome from "./StaffHome";
import AdminLogin from "./AdminLogin";
//import myimg from '../images/hospital_img.jpg';

class MainMenu extends React.Component {

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
                {/*</div><div style={{  background: myimg }}>*/}
                <BrowserRouter>
                    {/*<div style={{  backgroundImage: `url("https://via.placeholder.com/500")`}}>
              <div style={{display: this.state.flag?'none':'block' }}>*/}
                    <nav>

                        <Link to="/login"><h4>LOGIN</h4></Link>
                        

                    </nav>

                    <Route path='/login' component={UserLogin} />
                    <Route path='/AdminLogin' component={AdminLogin} />
                    <Route path='/StaffHome' component={StaffHome} />
                    <Route path='/DoctorHome' component={DoctorHome} />

                </BrowserRouter>
                                
            </div>

        )
    }
}
export default MainMenu;