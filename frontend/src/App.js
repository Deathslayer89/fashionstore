import "./App.css";
import Homepage from "./Pages/Homepage";
import Footer from "./customer/Components/Footer";
import Navigation from "./customer/Components/Navigation/Navigation";
function App() {
  return (
    <div>
      <Navigation />
      <div>
      <Homepage/>
      </div>
      <Footer/>
    </div>
  );
}

export default App;
