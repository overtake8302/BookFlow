import "./CartBook.css"
import {useState} from "react";
import Photo from "../../resources/cart/forDesign.png";

function CartBook(){
    const [checkEach, setCheckEach] = useState(false);
    const CheckEach = () => {
        setCheckEach((prev) => !prev);
    }

    return (
        <div className="each-book">
            <input
                id="checkEach"
                type="checkbox"
                onChange={CheckEach}
            />
            <div className="about-book">
                <img src={Photo} alt={Photo} style={{height: 100, width: 80}}/>
                <div id="title-price">
                    <div id="book-title">스프링 부트 핵심 가이드</div>
                    <div id="book-price">25,000원</div>
                </div>
                <div className="separator"></div>
                <div id="quantity-edit">
                    <div id="total-price">50,000원</div>
                    <button>-</button>
                    <span id="total-quantity"> 2 </span>
                    <button>+</button>
                </div>
            </div>
        </div>
    );
}

export default CartBook;