import {useEffect, useState} from "react";
import bookData from "./testBookData.json";


function BookDetailTest(){
    // 책 수량
    const [bookQuantity, setBookQuantity] = useState(1);
    const clickMinus = () => {
        setBookQuantity((prev) => prev === 1? prev : prev - 1);
    };
    const clickPlus = (book_stock) => {
        setBookQuantity((prev) => prev === book_stock? prev : prev+1);
    };

    // 책 데이터
    const [books, setBooks] = useState([]);
    useEffect(() => {
        setBooks(bookData);
    } , []);

    // 장바구니 담기
    const addCart = () => {
        "작성 필요";
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
                            <button onClick={addCart}> 장바구니담기</button>
                        </p>
                    </ul>
                ))}
            </ul>
        </div>
    );
}

export default BookDetailTest;