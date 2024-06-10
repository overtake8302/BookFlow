import HomeHeader from "../../components/home/HomeHeader";
import CartBookList from "../../components/cart/CartBookList";
import CartHeader from "../../components/cart/CartHeader";
import CartPriceInfo from "../../components/cart/CartPriceInfo";
import "./Cart.css";
import {useParams} from "react-router-dom";

function Cart(){
    const {userName} = useParams();

    // 실행되면 정보 가져오기

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