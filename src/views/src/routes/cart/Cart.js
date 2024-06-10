import HomeHeader from "../../components/home/HomeHeader";
import CartBookList from "../../components/cart/CartBookList";
import CartHeader from "../../components/cart/CartHeader";
import CartPriceInfo from "../../components/cart/CartPriceInfo";
import "./Cart.css";
import {Link, useParams} from "react-router-dom";

function Cart(){
    const {userName} = useParams();
    const cartName = `cart-${userName}`;
    const cart = JSON.parse(localStorage.getItem(cartName));
    console.log(cart);
    console.log(cart === null);

    return (
        <div>
            {cart === null?
                // 장바구니에 상품 없을 때
                <div>
                    <h2>장바구니</h2>
                    <div>
                        {/* 적절한 이미지*/}
                        장바구니에 담긴 책이 없습니다.
                    </div>
                    <Link to="/">
                        <button>책 담으러 가기</button>
                    </Link>
                </div>
            :
                <div>
                    // 장바구니에 상품 있을 때
                    <div>
                        <HomeHeader/>
                    </div>
                    <hr/>
                    <div>
                        <CartHeader/>
                        <div id="Book-Price">
                            <CartBookList userName={userName}/>
                            <CartPriceInfo userName={userName}/>
                        </div>
                    </div>
                </div>
            }
        </div>
    );
}

export default Cart;