import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Home from "./routes/Home";
import OrderDetails from "./routes/order/OrderDetails";
import OrderList from "./routes/order/OrderList";
import JoinTest from "./routes/loginTest/JoinTest";
import LoginTest from "./routes/loginTest/LoginTest";
import OrderCompleted from "./routes/order/OrderCompleted";
import OrderListByAdmin from "./routes/order/OrderListByAdmin";
import OrderDetailsByAdmin from "./routes/order/OrderDetailsByAdmin";
import Cart from "./routes/Cart/Cart";

function App() {
  return (
    <Router>
    <Switch>
      <Route path="/orderDetails/:orderId">
        <OrderDetails />
      </Route>
      <Route path="/orderDetailsByAdmin/:orderId">
        <OrderDetailsByAdmin />
      </Route>
      <Route path="/orderList">
        <OrderList />
      </Route>
      <Route path="/orderCompleted">
        <OrderCompleted />
      </Route>
      <Route path="/orderListByAdmin">
        <OrderListByAdmin />
      </Route>

      <Route path="/joinTest">
        <JoinTest />
      </Route>
      <Route path="/loginTest">
        <LoginTest />
      </Route>


      <Route path="/cart/:userName">
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
