import "./CartBook.css"
import {useEffect, useState} from "react";
import Photo from "../../resources/cart/forDesign.png";
import {useParams} from "react-router-dom";

function CartBook({userName}){
    // 장바구니
    const  cartName = `cart-${userName}`;
    const initialCart = JSON.parse(localStorage.getItem(cartName) || []);
    const [cart, setCart] = useState(initialCart);

    console.log("장바구니: " + JSON.stringify(cart));
    console.log(`빈 장바구니: ${cart === null}`);

    const updateCart = (newCart) => {
        setCart(newCart);
        localStorage.setItem(cartName, JSON.stringify(newCart));
    }

    // 책 인덱스 찾기
    const findIndexOfBook = (book) => {
        return cart.findIndex((index) => index.book_id === book.book_id);
    }

    // 수량
    const clickMinus = (book) => {
        const i = findIndexOfBook(book);
        if (i !== -1 && cart[i].book_quantity > 1 ){
            const newCart = [...cart];
            newCart[i].book_quantity -= 1;
            console.log("수정후: " + JSON.stringify(newCart));
            updateCart(newCart);
        }
        else {
            alert("수량은 한 권 이상이어야 합니다.");
        }
    };
    const clickPlus = (book) => {
        const i = findIndexOfBook(book);
        if (i !== -1 && cart[i].book_quantity < cart[i].book_stock ){
            const newCart = [...cart];
            newCart[i].book_quantity += 1;
            updateCart(newCart);
        }
        else {
            alert("재고가 부족합니다.");
        }
    };

    // 체크
    const [checkEach, setCheckEach] = useState(false);
    const CheckEach = () => {
        setCheckEach((prev) => !prev);
    }

    // 특정 상품 삭제
    const clickDelete = (book) => {
        const i = findIndexOfBook(book);
        const newCart = [...cart];
        newCart.splice(i);
        alert(book.book_name + "이(가) 삭제되었습니다.");
        updateCart(newCart);
    }

    // 전체 상품 삭제
    // 선택한 상품 삭제

    return (
        <div>
            {cart.map((book) => (
                <div key={book.book_id} className="each-book">
                    <input
                        id="checkEach"
                        type="checkbox"
                        onChange={CheckEach}
                    />
                    <div className="about-book">
                        <img src={book.img_url} alt={Photo} />
                        <div id="title-price">
                            <div id="book-title">{book.book_name}</div>
                            <div id="book-price">{book.book_price}원</div>
                        </div>
                        <div className="separator"></div>
                        <div id="quantity-edit">
                            <div id="total-price"> {book.book_price * book.book_quantity}원</div>
                            <button onClick={() => clickMinus(book)}>-</button>
                            <span id="total-quantity"> {book.book_quantity} </span>
                            <button onClick={() => clickPlus(book)}>+</button>
                        </div>
                        <div>
                            <button onClick={() => clickDelete(book)}> x</button>
                        </div>
                    </div>
                </div>
                ))
            }
        </div>
    );
}

export default CartBook;