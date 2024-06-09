import "./CartPriceInfo.css"
import {Link} from "react-router-dom";

function CartPriceInfo(){
    return (
        <div className="price-info">
            <h3>결제정보</h3>
            <div className="each-price">
                <div id="book-price">
                    상품금액: 50,000원
                </div>
                <div id="delivery-price">
                    배송비: + 3,000원
                </div>
                <hr/>
                <div id="total-price">
                    총 결제금액: 53,000원
                </div>
            </div>
            <div className="each-button">
                <button id="go-to-buy">구매하기 (2)</button>
                <Link to="/">
                    <button id="more-book">더 담으러 가기</button>
                </Link>
            </div>
        </div>
    );
}

export default CartPriceInfo;