
import React from "react";

class Header extends React.Component{
    constructor(props)
    {
        super(props)
        this.state = {
        }
    }
    render(){
        return(
            <div class="container" style={{textAlign:"center"}}>
                <header>
                 <p class="bg-info" ><h1>Welcome To Hospital Management Website</h1></p>
                </header>
            </div>
        )
    }
}
export default Header;