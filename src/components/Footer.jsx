
import React from "react";

class Footer extends React.Component{
    constructor(props)
    {
        super(props)
        this.state = {
        }
    }
    render(){
        return(
            <div class="container">
                <footer className="footer" style={{textAlign:"center"}} >
                   <p>All Rights Reserved 2021 @ Website
                   Contact us at:(+91)9876543210  ,Email id:admin@hospital.com
                   </p>
                </footer>
            </div>
        )
    }
}
export default Footer;