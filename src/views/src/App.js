import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Home from "./routes/Home";
import OrderDetails from "./routes/order/OrderDetails";
import OrderList from "./routes/order/OrderList";
import JoinTest from "./routes/loginTest/JoinTest";
import LoginTest from "./routes/loginTest/LoginTest";
import OrderCompleted from "./routes/order/OrderCompleted";
import AdminMenu from './routes/user/admin/AdminMenu';
import Join from './routes/user/auth/Join';
import Login from './routes/user/auth/Login';
import AdminUserList from './routes/user/admin/AdminUserList';

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

      <Route path="/join">
        <Join />
      </Route>

      <Route path="/login">
        <Login />
      </Route>

      <Route path="/admin/menu/userlist">
        <AdminUserList />
      </Route>

      <Route path="/admin/menu">
        <AdminMenu />
      </Route>

      <Route path="/">
        <Home />
      </Route>
    </Switch>
  </Router>
  );
}

export default App;
