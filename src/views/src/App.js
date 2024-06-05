import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Order from "./routes/Order";
import Home from "./routes/Home";
import Cart from "./routes/Cart";

function App() {
  return (
    <Router>
    <Switch>
      <Route path="/order">
        <Order />
      </Route>
      <Route path="/cart">
        <Cart />
      </Route>
      <Route path="/">
        <Home />
      </Route>
    </Switch>
  </Router>
  );
}

export default App;
