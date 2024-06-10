import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Home from "./routes/Home";
import OrderDetails from "./routes/order/OrderDetails";
import OrderList from "./routes/order/OrderList";
import JoinTest from "./routes/loginTest/JoinTest";
import LoginTest from "./routes/loginTest/LoginTest";
import OrderCompleted from "./routes/order/OrderCompleted";
import OrderListByAdmin from "./routes/order/OrderListByAdmin";
import OrderDetailsByAdmin from "./routes/order/OrderDetailsByAdmin";
import Order from "./routes/order/Order";
import Cart from "./routes/Cart/Cart";


function App() {
  return (
    <Router>
    <Switch>
      <Route path="/order-details/:orderId">
        <OrderDetails />
      </Route>
      <Route path="/order-details-by-admin/:orderId">
        <OrderDetailsByAdmin />
      </Route>
      <Route path="/order-list">
        <OrderList />
      </Route>
      <Route path="/order-completed">
        <OrderCompleted />
      </Route>
      <Route path="/order-list-by-admin">
        <OrderListByAdmin />
      </Route>
      <Route path="/order">
        <Order />
      </Route>

      <Route path="/join-test">
        <JoinTest />
      </Route>
      <Route path="/login-test">
        <LoginTest />
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
