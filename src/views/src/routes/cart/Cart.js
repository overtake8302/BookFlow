import HomeHeader from "../../components/home/HomeHeader";
import CartBookList from "../../components/cart/CartBookList";
import CartHeader from "../../components/cart/CartHeader";
import CartPriceInfo from "../../components/cart/CartPriceInfo";
import "./Cart.css";

function Cart(){
    return (
        <div>
            <div>
                <HomeHeader />
            </div>
            <hr style={{borderColor: 'rgb(260, 260, 260)'}} />
            <div>
                <CartHeader />
                <div id="Book-Price">
                    <CartBookList />
                    <CartPriceInfo />
                </div>
            </div>
        </div>
    );
}

export default Cart;