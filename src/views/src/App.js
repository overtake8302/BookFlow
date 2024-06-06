import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Home from "./routes/Home";
import OrderDetails from "./routes/order/OrderDetails";
import OrderList from "./routes/order/OrderList";
<<<<<<< HEAD
=======
import JoinTest from "./routes/loginTest/JoinTest";
import LoginTest from "./routes/loginTest/LoginTest";
import OrderCompleted from "./routes/order/OrderCompleted";
>>>>>>> 3bd465834f53b723681605371ce84809a3467005

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
<<<<<<< HEAD
=======
      <Route path="/orderCompleted">
        <OrderCompleted />
      </Route>

      <Route path="/joinTest">
        <JoinTest />
      </Route>
      <Route path="/loginTest">
        <LoginTest />
      </Route>
>>>>>>> 3bd465834f53b723681605371ce84809a3467005


      <Route path="/">
        <Home />
      </Route>
    </Switch>
  </Router>
  );
}

export default App;
