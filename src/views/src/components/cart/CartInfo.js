import "./CartInfo.css";
import { useEffect, useState } from "react";
import DeleteButton from "../../resources/cart/delete.png";


function CartInfo(){
    /*
    const [book,setBook] = useState("");
    const [price, setPrice] = useState("0");
    const [count, setCount] = useState("0");
     */

    return (
        <div className="cart-container">
            <div className="check-delete">
                {/* 전체 선택 체크박스 */}
                <input
                    id="checkAll"
                    type="checkbox"
                />
                <lable htmlFor="checkAll">전체선택</lable>
                {/* 선택 상품 삭제 버튼*/}
                <button id="delete">
                    <img src={DeleteButton} style={{width: "15px", height:"15px"}}/> 선택삭제
                </button>
            </div>
            <div className="book-price" style={{background:"rgb(239, 239, 239)"}}>
                <div className="book-list">
                    <span>상품 정보</span>
                </div>
                <div className="price-info">
                    <span>가격 정보</span>
                </div>
            </div>
        </div>
    );
}

export default CartInfo;