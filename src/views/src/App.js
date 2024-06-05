import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Home from "./routes/Home";
import OrderDetails from "./routes/order/OrderDetails";
import OrderList from "./routes/order/OrderList";

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


      <Route path="/">
        <Home />
      </Route>
    </Switch>
  </Router>
  );
}

export default App;
