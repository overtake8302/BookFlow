import HomeHeader from "../components/home/HomeHeader";
import CartInfo from "../components/cart/CartInfo";

function Cart(){
    return (
        <div>
            <di>
                <HomeHeader />
            </di>
            <hr />
            <div>
                <h2>장바구니</h2>
                <div>
                    <CartInfo />
                </div>
            </div>
        </div>
    );
}

export default Cart;