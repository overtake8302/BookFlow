import "./CartPriceInfo.css"
import {Link} from "react-router-dom";

function CartPriceInfo({cart}){
    const checkedCart = cart.filter((book) => book.checked);

    let totalBookPrice = 0;
    let checkedQuantity = 0;
    checkedCart.forEach((book) => {
        const bookPrice = book.book_price;
        const bookQuantity = book.book_quantity;
        totalBookPrice += bookPrice * bookQuantity;
        checkedQuantity += bookQuantity;
    });

    const deliveryPrice = (totalBookPrice >= 50000)? 0 : 3000;
    const totalPrice = totalBookPrice + deliveryPrice;

    return (
        <div>
            {checkedCart.map((book) => (
                <div key={book.book_id} className="price-info">
                    <h3>결제정보</h3>
                    <div className="each-price">
                        <div id="book-price">
                            상품금액: {totalBookPrice}원
                        </div>
                        <div id="delivery-price">
                            배송비: + {deliveryPrice}원
                        </div>
                        <hr/>
                        <div id="total-price">
                            총 결제금액: {totalPrice}원
                        </div>
                    </div>
                    <div className="each-button">
                        <button id="go-to-buy">구매하기 ({checkedQuantity})</button>
                        <Link to="/">
                            <button id="more-book">더 담으러 가기</button>
                        </Link>
                    </div>
                </div>
            ))}
        </div>
    );
}

export default CartPriceInfo;