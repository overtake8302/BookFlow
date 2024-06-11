import {useEffect, useState} from "react";
import bookData from "./testBookData.json";


function BookDetailTest(){
    // 책 데이터
    const [books, setBooks] = useState([]);
    useEffect(() => {
        setBooks(bookData);
    } , []);

    // 책 수량
    const [bookQuantity, setBookQuantity] = useState(1);
    const clickMinus = () => {
        setBookQuantity((prev) => prev === 1? prev : prev - 1);
    };
    const clickPlus = (book_stock) => {
        setBookQuantity((prev) => prev === book_stock? prev : prev+1);
    };

    // 장바구니: 상품 추가
    const clickAddCart = (book) => {
        const token = localStorage.getItem('token');
        if (token === null){
            alert("로그인 후 이용 가능합니다.");
        } else {
            // 사용자 카트 가져오기
            const cartName = `cart-${localStorage.getItem('userName')}`;
            let cart = JSON.parse(localStorage.getItem(cartName));

            // 빈 카트이면 빈 배열로 초기화
            if (cart === null) {
                cart = [];
                console.log("빈 장바구니: " + cart);
            }

            // 카트에 책 존재하면 위치 인덱스, 없으면 -1 반환
            const existingBookIndex = cart.findIndex((index) => index.book_id === book.book_id);
            console.log("위치인덱스: " + existingBookIndex);

            // 카트에 책 존재하면 수량 수정, 없으면 추가
            if (existingBookIndex === -1) {
                cart.push({...book, book_quantity: bookQuantity});
            } else {
                cart[existingBookIndex].book_quantity += bookQuantity;
            }
            localStorage.setItem(cartName, JSON.stringify(cart));
            console.log("장바구니: " + JSON.stringify(cart));
            alert("장바구니에 상품이 추가되었습니다!");
        }
    };

    return (
        <div>
            <ul>
                {books.map((book) => (
                    <ul key={book.book_id}>
                        <img src={book.img_url}/>
                        <p>{book.book_name}</p>
                        <p>{book.book_price}</p>
                        <button onClick={clickMinus}>-</button>
                        <span> {bookQuantity} </span>
                        <button onClick={() => clickPlus(book.book_stock)}> +</button>
                        <p>
                            <button onClick={() => clickAddCart(book)}> 장바구니담기</button>
                        </p>
                    </ul>
                ))}
            </ul>
        </div>
    );
}

export default BookDetailTest;