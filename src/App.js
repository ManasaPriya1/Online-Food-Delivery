import './App.css';
import Home from "./components/home";
import Login from "./components/login";
import "bootstrap/dist/css/bootstrap.css";
import Nav from "./components/nav";
import { Switch, Route, Redirect } from "react-router-dom";
import Logout from "./components/logout";

function App() {
  return (
    <div className="App">
      <Nav/>
      <Switch>
        <Route exact path="/" component={Home} />
        <Route path="/login" component={Login} />
        <Redirect from="/home" to="/" />
        <Route path="/logout" component={Logout} />
      </Switch>


      <Login/>
    </div>
  );
}

export default App;
