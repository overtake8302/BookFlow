import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Home from "./routes/Home";
import OrderDetails from "./routes/order/OrderDetails";
import OrderList from "./routes/order/OrderList";
import JoinTest from "./routes/loginTest/JoinTest";
import LoginTest from "./routes/loginTest/LoginTest";
import OrderCompleted from "./routes/order/OrderCompleted";

function App() {
  return (
    <Router>
    <Switch>
      <Route path="/orderDetails/:orderId">
        <OrderDetails />
      </Route>
      <Route path="/orderList">
        <OrderList />
      </Route>
      <Route path="/orderCompleted">
        <OrderCompleted />
      </Route>

      <Route path="/joinTest">
        <JoinTest />
      </Route>
      <Route path="/loginTest">
        <LoginTest />
      </Route>


      <Route path="/">
        <Home />
      </Route>
    </Switch>
  </Router>
  );
}

export default App;
