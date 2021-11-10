//import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Link, Route } from 'react-router-dom';
import Header from './components/Header';
import MainMenu from './components/MainMenu';
import Footer from './components/Footer';

function App() {
  return (

    //<div className="App"style={{backgroundImage:'url("./components/images/hospital_img.jpg")',height:"300px",backgroundRepeat:"no-repeat"}}  >
    //<div class="bg_image"
    //style={{
    //backgroundImage:'url("./components/images/hospital_img.jpg")',
    //backgroundSize:"cover",
    //height:"100vh"
    // }}
    //>
    /*
    <div className="App" 
      
      style={{backgroudImage:'url("https://github.com/arijitiiest/Hospital-Management-System/blob/master/client/src/photos/doctor1.jpg?raw=true")'}}>
    
      
    <Header />
   
   <div>  
    <MainMenu />
 
    
    </div>
    <Footer />
  </div>*/
    /*
        <div className="App"style={{ backgroundImage: "url(/hospital_img.jpg)" }}>
          <Header />
          <div> 
          <MainMenu />
          </div>
          <Footer />
        </div>*/

    <div>
      <Header />
      <div className="background_img">
        <MainMenu />
        
        <Footer />
      </div>

    </div>

  );
}
export default App;
