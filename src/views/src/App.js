import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Home from "./routes/Home";
import OrderDetails from "./routes/order/OrderDetails";
import OrderList from "./routes/order/OrderList";
import JoinTest from "./routes/loginTest/JoinTest";
import LoginTest from "./routes/loginTest/LoginTest";
import OrderCompleted from "./routes/order/OrderCompleted";
<<<<<<< HEAD
import OrderListByAdmin from "./routes/order/OrderListByAdmin";
import OrderDetailsByAdmin from "./routes/order/OrderDetailsByAdmin";
import Cart from "./routes/Cart/Cart";
=======
import AdminMenu from './routes/user/admin/AdminMenu';
import Join from './routes/user/auth/Join';
import Login from './routes/user/auth/Login';
import AdminUserList from './routes/user/admin/AdminUserList';
import OrderListByAdmin from "./routes/order/OrderListByAdmin";
import OrderDetailsByAdmin from "./routes/order/OrderDetailsByAdmin";
import Order from "./routes/order/Order";
import Cart from "./routes/Cart/Cart";

>>>>>>> origin/dev

function App() {
  return (
    <Router>
    <Switch>
      <Route path="/order-details/:orderId">
        <OrderDetails />
      </Route>
<<<<<<< HEAD
      <Route path="/orderDetailsByAdmin/:orderId">
        <OrderDetailsByAdmin />
      </Route>
      <Route path="/orderList">
=======
      <Route path="/order-details-by-admin/:orderId">
        <OrderDetailsByAdmin />
      </Route>
      <Route path="/order-list">
>>>>>>> origin/dev
        <OrderList />
      </Route>
      <Route path="/order-completed">
        <OrderCompleted />
      </Route>
<<<<<<< HEAD
      <Route path="/orderListByAdmin">
        <OrderListByAdmin />
      </Route>
=======
      <Route path="/order-list-by-admin">
        <OrderListByAdmin />
      </Route>
      <Route path="/order">
        <Order />
      </Route>
>>>>>>> origin/dev

      <Route path="/joinTest">
        <JoinTest />
      </Route>
      <Route path="/loginTest">
        <LoginTest />
      </Route>

      <Route path="/join">
        <Join />
      </Route>

<<<<<<< HEAD
=======
      <Route path="/login">
        <Login />
      </Route>

      <Route path="/admin/menu">
        <AdminMenu />
      </Route>

      <Route path="/userlist">
          <AdminUserList />
      </Route>

>>>>>>> origin/dev
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
